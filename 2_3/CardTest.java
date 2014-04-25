package intermediate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class CardTest {

	@Test
	public void マークと数字を指定したカードが正しく生成されたことを確認する() {
		Card card = new Card(Card.Mark.DIA, 11);

		assertThat(card.getMark(), is(Card.Mark.DIA));
		assertThat(card.getNumber(), is(11));
	}

	@Test
	public void クラブよりダイヤの方が強い() {
		Card card1 = new Card(Card.Mark.CLUB, 1);
		Card card2 = new Card(Card.Mark.DIA, 1);

		assertThat(card1.compareTo(card2), is(-1));
	}

	@Test
	public void スペードよりJOKERの方が強い() {
		Card card1 = new Card(Card.Mark.SPADE, 1);
		Card card2 = new Card(Card.Mark.JOKER, 0);

		assertThat(card1.compareTo(card2), is(-1));
	}

	@Test
	public void マークが同じときは数字が高い方が強い() {
		Card card1 = new Card(Card.Mark.SPADE, 4);
		Card card2 = new Card(Card.Mark.SPADE, 5);

		assertThat(card1.compareTo(card2), is(-1));
	}
}
