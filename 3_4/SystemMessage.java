package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

/**
 * システムメッセージを出力するクラス
 * @author Taichi SHINDO
 */
public class SystemMessage {
	/**
	 * ChatClientの使用方法を出力する関数
	 * @param port
	 */
	public static void printClientManual() {
		System.out.println("使い方:");
		System.out.println("java -jar ChatClient.jar ホスト名 ポート番号");
	}

	/**
	 * サーバー起動情報を出力する関数
	 * @param port
	 */
	public static void printRunServerInfo(int port) {
		System.out.println("ポート番号" + port + "をオープンします。");
		System.out.println("オープンに成功しました。サーバを起動しました。");
	}

	/**
	 * 接続したクライアントの名前をたずねる関数
	 * @param out
	 */
	public static void printWhatYourName(PrintWriter out) {
		out.println("あなたのお名前:\n>");
	}

	/**
	 * 接続したクライアントにあいさつする関数
	 * @param out
	 * @param name
	 */
	public static void printHello(PrintWriter out, String name) {
		out.println("こんにちは" + name + "さん");
	}

	/**
	 * チャットルームの情報を表示する関数
	 * @param out
	 * @param socketList 既に接続しているソケットのリスト
	 * @param mySocket   現在接続しているソケット
	 */
	public static void printChatroomInfo(PrintWriter out, Map<Socket, String> socketList, Socket mySocket) {
		if (socketList.size() == 1) {
			out.println("あなたが最初の入室者です。他の方の入室を待ちましょう。");
			out.println();
		} else {
			out.print("現在の参加者は");

			for (String str : socketList.values()) {
				if (str.equals(socketList.get(mySocket))) {
					continue;
				}
				out.print("、");
				out.print(str + "さん");
			}
			out.println("です。");
			out.println();
		}
	}

	/**
	 * 入室者の情報を出力する関数
	 * @param out
	 * @param socketList 既に接続しているソケットのリスト
	 * @param mySocket   現在接続しているソケット
	 */
	public static void printVisitorInfo(Map<Socket, String> socketList, Socket mySocket) throws IOException {
		for (Socket socket : socketList.keySet()) {
			// ソケットに対して出力するためのWriterを作成
			PrintWriter sysMessage = new PrintWriter(socket.getOutputStream(), true);

			if (socket == mySocket) {
				continue;
			} else {
				sysMessage.println(socketList.get(mySocket) + "さんが入室しました。");
				sysMessage.println();
			}
		}
	}

	/**
	 * クライアントの接続が切断したときのメッセージを出力する関数
	 * @param out
	 */
	public static void printShutdownMessage() {
		System.out.println("サーバとの接続が切れました。");
	}

}
