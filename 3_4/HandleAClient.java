package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

/**
 * HandleAClientクラス
 * クライアントが接続状態に入ったときの処理をする
 *
 * @author Taichi SHINDO
 */
class HandleAClient implements Runnable {
	/** 接続したクライアントのソケット */
	private Socket mySocket;

	/** 現在サーバーに接続されているクライアントのソケット */
	private Map<Socket, String> socketList;

	/**
	 * コンストラクタ
	 * @param socket 接続状態に入ったソケット
	 */
	public HandleAClient(Socket socket) {
		this.mySocket = socket;
		this.socketList = ChatServer.socketList;
		initialize();
	}

	/**
	 * クライアント情報やチャットルームの情報を流す関数
	 */
	public void initialize() {
		try {
			// ソケットに対して出力するためのWriterを作成
			PrintWriter out = new PrintWriter(this.mySocket.getOutputStream(), true);

			// 接続したクライアントの名前を訪ねる
			SystemMessage.printWhatYourName(out);

			// ソケットに対して入力するためのReaderを作成
			BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

			// クライアントから受け取った文字列を取得
			String name = in.readLine();

			// ソケットリストに登録
			socketList.put(mySocket, name);

			// 接続したソケットに挨拶
			SystemMessage.printHello(out, name);

			// 接続したソケットに現在のチャットルームの情報を流す
			SystemMessage.printChatroomInfo(out, socketList, mySocket);

			// 既に接続しているソケットに入室者の情報を流す
			SystemMessage.printVisitorInfo(socketList, mySocket);

		} catch (SocketException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	/**
	 * クライアント同士の会話を管理する関数
	 */
	public void run() {
		try {
			// ソケットに対して入力するためのReaderを作成
			BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));

			while (true) {

				// クライアントから受け取った文字列を取得
				String line = in.readLine();

				// ソケット通信できなくなったとき
				if (line == null) {
					socketList.remove(mySocket);
					continue;
				}

				String fromUser = socketList.get(mySocket);

				// 既に接続しているソケットにチャットメッセージを送る
				for (Socket socket : socketList.keySet()) {

					if (socket == mySocket) {
						continue;
					}

					// ソケットに対して出力するためのWriterを作成
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

					// 受け取った文字列をクライアントに送信
					out.println("(" + fromUser + ") " + line);
					out.println();
				}
			}
		} catch (SocketException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
