package intermediate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * トランプのデッキ（デック、カードの山）を表現するクラス。
 * デッキは基本52枚のカードとジョーカーをランダムな順番で保持する。
 * @author Taichi SHINDO
 */
public class Deck {
	private List<Card> deck = new LinkedList<Card>();

	/**
	 * コンストラクタ
	 */
	Deck(int jokersNum) {

		// カードをデッキに格納する
		for (Card.Mark mark : Card.Mark.values()) {
			if (! mark.equals(Card.Mark.JOKER)) {
				// ジョーカー以外のカードをリストに追加
				for (int i = 1; i <= 13; i++) {
					deck.add(new Card(mark, i));
				}
			} else {
				// ジョーカーをリストに追加
				for (int i = 1; i <= jokersNum; i++) {
					deck.add(new Card(Card.Mark.JOKER, i));
				}
			}
		}

		// シャッフルする
		Collections.shuffle(deck);
	}

	/**
	 * デッキの残り枚数を確認する関数
	 * @return デッキの残り枚数
	 */
	public int checkRest() {
		return deck.size();
	}

	/**
	 * カードが格納されているデッキを取得する関数
	 * @return カードが格納されているデッキ
	 */
	public List<Card> getDeck() {
		return deck;
	}

	/**
	 * デッキをセットする関数
	 * @param セットするデッキ
	 */
	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	/**
	 * 指定枚数だけカードをひく関数
	 * @param num カードの枚数
	 * @throws DrawException
	 */
	public void fetchCards(int num) throws DrawException {
		for (int i = 0; i < num; i++) {
			if (deck.isEmpty()) {
				throw new DrawException();
			}
			deck.remove(0);
		}
		setDeck(deck);
	}
}

/**
 * 残り枚数よりも大きな数をひこうとすると起きる例外クラス
 * @author Taichi SHINDO
 */
class DrawException extends Exception {
	private static final long serialVersionUID = 1L;

	DrawException() {
		super("これ以上カードは引きません");
	}
}
