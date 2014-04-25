package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * ChatClientクラス
 * 実行方法：
 * java -jar ChatClient.jar localhost 44444
 * java -jar ChatClient.jar 192.168.0.120 12345
 *
 * 1番目の引数はホスト
 * 2番目の引数はポート番号
 *
 * @author Taichi SHINDO
 */
public class ChatClient {

	/**
	 * メイン関数
	 * サーバー情報を指定して、サーバーに接続
	 * キーボードからの入力をサーバーに送信し、サーバーからチャット更新情報があれば受信して表示する
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			SystemMessage.printClientManual();
			return;
		}

		// ホスト名を取得
		String host = ChatUtil.fetchHost(args[0]);

		// ポート番号を取得
		int port = ChatUtil.fetchPort(args[1]);

		try {
			// サーバー情報を指定して、サーバーに接続
			Socket socket = new Socket(host, port);

			// ソケットに対して入力するためのReaderを作成
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// ソケットに対して出力するためのWriterを作成
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			// キーボードからの入力を受付
			BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				while (in.ready()) {
					// サーバーから受け取った文字列を取得して表示する
					System.out.println(in.readLine());
				}
				if (keyIn.ready()) {
					String message = keyIn.readLine();

					// exit の入力でチャットから退室
					if (message.equals("exit")) {
						SystemMessage.printShutdownMessage();
						socket.close();
						System.exit(1);
					}

					// キーボードに入力した文字列をサーバーに送信
					out.println(message);
				}
			}
		} catch (SocketException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
