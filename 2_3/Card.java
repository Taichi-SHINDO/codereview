package intermediate;

/**
 * トランプのカードを表現するクラス。
 * カードはマーク（クラブ、ダイヤ、ハート、スペード）と数字（１〜１３）を持つ。
 * また、基本の52枚以外にジョーカーも存在する。
 * カードには順序が規定されており、
 * クラブの１〜１３→ダイヤの１〜１３→ハートの１〜１３→スペードの１〜１３→ジョーカー
 * という順序を持つ（クラブの１が一番小さく、スペードの１３まで順番に、そしてジョーカーが一番大きい）
 *
 * @author Taichi SHINDO
 */
public class Card implements Comparable<Card>{

	enum Mark {
		CLUB,
		DIA,
		HEART,
		SPADE,
		JOKER
		}

	/**
	 * トランプのマークを表現するフィールド
	 * (クラブ, ダイヤ, ハート, スペード, ジョーカー)
	 */
	private Mark mark;

	/**
	 * トランプの数字を表現するフィールド
	 * (1〜13)
	 */
	private int number;

	/**
	 * コンストラクタ
	 */
	public Card(Mark mark, int number) {
		this.mark = mark;
		this.number = number;
	}

	/**
	 * トランプのマークを取得する関数
	 * @return トランプのマーク
	 */
	public Mark getMark() {
		return mark;
	}

	/**
	 * トランプの数字を取得する関数
	 * @return トランプの数字
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * オブジェクトの比較をする関数
	 * @param カード
	 * @return
	 * 		this > o => 正の値
	 * 		this = o => 0
	 * 		this < o => 負の値
	 */
	public int compareTo(Card o) {
		int delta = this.mark.ordinal() - o.mark.ordinal();
		if (delta != 0) {
			return delta;
		} else {
			return this.number - o.number;
		}
	}

	/**
	 * インスタンスの情報を文字列で表示する関数
	 */
	public String toString() {
		return "( " + mark + " : " + number + " )" ;
	}
}
