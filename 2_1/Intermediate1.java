package intermediate;

/**
 * 中級問題2_1
 * @author Taichi SHINDO
 */
public class Intermediate1 {

	/**
	 * 10進数の数を2進数表記に変換する関数
	 * @param src　10進数の数
	 * @return　2進数表記に変換した文字列
	 */
	public static String toBinaryString(int src) {
		String binaryString = "";

		if (src < 0) {
			throw new IllegalArgumentException();
		}

		while (src > 0) {
			binaryString += src % 2;
			src /= 2;
		}

		if (binaryString.length() == 0) {
			binaryString += "0";
		}

		binaryString = new StringBuilder(binaryString).reverse().toString();

		return binaryString;
	}
}
