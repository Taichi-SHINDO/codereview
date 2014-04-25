import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 素数リストを出力するプログラム
 * @author Taichi SHINDO
 */
public class Eratosthenes {
    /**
     * 素数が収納されるリスト
     */
    public static ArrayList<Integer> primeList = new ArrayList<Integer>();
    
    /**
     * メインメソッド
     * 入力した値を取得して、素数のリストを取得する
     * その後、素数のリストを表示する
     * @param args
     */
    public static void main (String[] args) {
	int num = inputNum();

	getPrimeList(num);
	
	for (int prime : primeList) {
	    System.out.printf("%-2d", prime);
	}
    }

    /**
     * 素数リストを出力するプログラムの説明を表示する関数
     */
    public static void preMessage() {
	System.out.println("素数リストを出力するプログラムです。");
	System.out.println("リストの最大値を整数で入力してください。");
    }
    
    /**
     * 数値を入力する関数
     * @return 入力した数値を返す
     */
    public static int inputNum () {
	preMessage();

	int num = 0;
	Scanner scan = new Scanner(System.in);

	try {
	    num = scan.nextInt();
	} catch (InputMismatchException e){
	    System.out.println("不正な値が入力されました。");
	}
	
	return num;
   }
    
    /**
     * 素数のリストを取得する関数
     * @param 入力した値
     */
    public static void getPrimeList (int num) {
	
	if (2 <= num) {
	    primeList.add(2);
	}

	for (int i = 3; i <= num; i++) {
	    boolean primeFlg = true;
	    for (int j = 2; j < i; j++) {
		if ( i % j == 0 ) {
		    primeFlg = false;
		}
	    }
	    
	    if (primeFlg) {
		primeList.add(i);
	    }
	}
    }
}
