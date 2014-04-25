package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

/**
 * ChatServerクラス
 * 実行方法：
 * java -jar ChatServer.jar
 * java -jar ChatServer.jar 12345
 *
 * 1番目の引数はポート番号
 * ポート番号を指定がなければデフォルトで44444ポートを使用する
 *
 * @author Taichi SHINDO
 */
public class ChatServer {
	/** 接続されているソケットのリスト */
	public static Map<Socket, String> socketList = new HashMap<Socket, String>();

	/**
	 * メイン関数
	 * サーバーソケットを生成して、クライアントからの接続待機状態に入る
	 * クライアントが接続されれば、スレッドを生成する
	 * @param args
	 */
	public static void main(String[] args) {
		int port;
		if (args.length == 0) {
			port = ChatUtil.DEFAULT_PORT;
		} else {
			// ポート番号を取得
			port = ChatUtil.fetchPort(args[0]);
		}

		// 指定したポート番号でサーバーソケットを生成
		ServerSocket serverSocket;
		try {
			// 指定したポート番号でサーバーソケットを生成
			serverSocket = new ServerSocket(port);
			SystemMessage.printRunServerInfo(serverSocket.getLocalPort());

			// 複数のクライアントからの接続を可能にするため
			while (true) {
				// acceptメソッドを呼び出し、クライアントからの接続待機状態に入る
				Socket socket = serverSocket.accept();

				// 新しくスレッドを作成する
				HandleAClient task = new HandleAClient(socket);

				// スレッドを起動
				new Thread(task).start();
			}
		} catch (SocketException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}

