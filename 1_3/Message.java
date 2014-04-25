/**
 * メッセージクラス
 */
public class Message {
	
    /**
     * ゲームの開始時のメッセージを出力
     */
    public static void printPreMessage() {
	System.out.println("じゃんけんをしましょう！");
	System.out.println("1: グー、2: チョキ、3: パー です。");
	System.out.println("じゃーんけーん・・");
    }

    /**
     * お互いのじゃんけんの手を出力
     */
    public static void printHandInfo(String myHand, String compHand) {
	System.out.println("ぽん！");
	System.out.println("あなた：" + myHand + 
			   "、コンピュータ：" + compHand);
    }

    /**
     * 勝ち負けのメッセージを出力する
     */
    public static void printWinner(Hand myHand, Hand compHand) {
	int code = myHand.checkWin(compHand.getHandId());
		
	switch (code) {
	case 0: System.out.println("あーいこーで・・");
	    break;
	case 1: System.out.println("あなたの勝ちです!");
	    break;
	case 2: System.out.println("あなたの負けです！");
	    break;
	default : break;
	}
    }
}
