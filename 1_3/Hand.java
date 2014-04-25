import java.util.Scanner;
import java.util.Random;  
import java.util.InputMismatchException;

/**
 * Handクラス
 */
public class Hand {
    private int id;
	
    public Hand() {}
        
    /**
     * じゃんけんの手のIDを取得
     *
     * @return 1:グー, 2:チョキ, 3:パー
     */
    public int getHandId() {
	return this.id;
    }
	
    /**
     * じゃんけんで出した手の名前を取得する
     * (グー、チョキ、パー)
     *
     * @return じゃんけんの手の名前
     */
    public String getHandName () {
	String handName = "";
	switch (id) {
	case 1: handName = "グー";
	    break;
	case 2: handName = "チョキ";
	    break;
	case 3: handName = "パー";
	    break;
	}
	    
	return handName;
    }

    /**
     * 自分自身のじゃんけんの手を入力して確定する
     */
    public void setupMyHand() {
	while (true) {
	    System.out.print("出す手を入力 => ");
	    Scanner scan = new Scanner(System.in);
		
	    try {
		int input = scan.nextInt();
		    
		if (0 < input && input < 4) {
		    this.id = input;
		    return;
		}

	    } catch (InputMismatchException e){
	    }
	}
    }

    /**
     * コンピューターの手を自動で確定する
     */
    public void setupCompHand() {
	//Randomクラスのインスタンス化
        Random rnd = new Random();
        this.id = rnd.nextInt(3) + 1;
    }
	
    /**
     * じゃんけんゲームで勝つかどうかを判定
     *
     * @param compId コンピューターの手
     * @return 0: 引き分け, 1: 勝ち, 2: 負け
     */
    public int checkWin (int compId) {
	if (compId < this.id) {
	    compId += 3;
	}
	    
	return compId - this.id;
    }
}
