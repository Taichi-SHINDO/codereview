package intermediate;

import java.util.ArrayList;

/**
 * 中級問題2_2
 * @author Taichi SHINDO
 */
public class Intermediate2 {
	/**
	 * 重複を取り除いた配列を返す関数
	 * @param src
	 * @return　重複を取り除いた配列
	 */
	public static int[] uniq(int[] src) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < src.length; i++) {
			if (0 < i && src[i - 1] == src[i]) {
				continue;
			} else {
				list.add(src[i]);
			}
		}

		int[] uniq = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			uniq[i] = list.get(i);
		}
		return uniq;
	}
}
