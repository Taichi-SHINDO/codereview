/**
 * じゃんけんゲーム

 *　@author Taichi SHINDO
 */
public class RPS {
    public static void main (String[] args) {
	// Messageクラスのインスタンスを生成
	Message.printPreMessage();
	
	// Handクラスのインスタンスを生成 (me)
	Hand myHand = new Hand();

	
	// Handクラスのインスランスを生成 (comp)
	Hand compHand = new Hand();

	// 勝ち負けつくと終了。あいこのときは繰り返す。
	do {
	    myHand.setupMyHand();	
	    compHand.setupCompHand();
	    Message.printHandInfo(myHand.getHandName(), compHand.getHandName());
	    Message.printWinner(myHand, compHand);
	} while (myHand.getHandId() == compHand.getHandId());
    } 
}
