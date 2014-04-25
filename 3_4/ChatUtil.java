package chat;

public class ChatUtil {

	/** デフォルトで接続するポート番号 */
	public static final int DEFAULT_PORT = 44444;

	/**
	 * 接続先のホスト名orIPアドレスを取得する関数
	 * @strPort ホスト名の文字列
	 * @return
	 * 		ホスト名の指定が適切であれば、そのホスト名を返す
	 */
	public static String fetchHost(String strHost) {
		return strHost;
	}

	/**
	 * ポート番号を取得する関数
	 * @strPort ポート番号の文字列
	 * @return
	 * 		ポート番号の指定が適切であれば、そのポート番号を返す
	 * 		ポート番号の指定が適切でなければ、デフォルトのポート番号44444を返す
	 */
	public static int fetchPort(String strPort) {
		try {
			return Integer.parseInt(strPort);
		} catch (NumberFormatException e) {
			return DEFAULT_PORT;
		}
	}
}
