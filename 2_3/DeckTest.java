package intermediate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class DeckTest {

	@Test
	public void デッキの枚数は52枚のカードとジョーカー() {
		// カード52枚 + ジョーカー2枚のデッキを作成
		Deck deck = new Deck(2);

		assertThat(deck.checkRest(), is(54));
	}

	@Test
	public void デッキから2枚のカードを引いたあとの残り枚数() {
		// カード52枚 + ジョーカー2枚のデッキを作成
		Deck deck = new Deck(2);

		try {
			// 5枚のカードを引く
			deck.fetchCards(5);
		} catch (DrawException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		assertThat(deck.checkRest(), is(49));
	}

	@Test(expected = DrawException.class)
	public void 残り枚数よりも大きな数をひくと例外を投げる() throws DrawException {
		// カード52枚 + ジョーカー2枚のデッキを作成
		Deck deck = new Deck(2);

		// 5枚のカードを引く
		deck.fetchCards(55);
	}
}
