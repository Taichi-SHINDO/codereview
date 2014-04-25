/**
 * チャレンジ問題1_6
 * ヒストグラム
 * @author Taichi SHINDO
 */
public class Histogram {
    
    /**
     * メインメソッド
     * 引数がなければ、Histogramクラスの使い方の説明
     * 引数があれば、ヒストグラムの図を表示
     */
    public static void main (String[] args) {
	if (args.length == 0) {
	    printManualMessage();
	} else {
	    printHistogram(args);
	}
   }
    
    /**
     * Histogramクラスの使い方の説明する関数
     */
    public static void printManualMessage() {
	System.out.println("グラフにプロットする値を引数に指定してください。");
	System.out.println("例）java Histogram 1 2 3 3 2 1");
    }

    /**
     * ヒストグラムの図を表示する関数
     * @param args 与えられた引数
     */
    public static void printHistogram(String[] args) {
	// TODO: 与えられる引数のバリデータチェック
	int max = getMaxNum(args);
	
	for (int i = 0; i < max; i++) {
	    for (int j = 0; j < args.length; j++) {
		if ((max - Integer.valueOf(args[j])) <= i) {
		    System.out.printf("%-3s", "*");
		} else {
		    System.out.printf("%-3s", "");
		}
	    }
	    System.out.println();
	}
    }
    
    /**
     * 与えられた引数のうち、最大値を取得する関数
     * @params args 与えられた引数
     * @return 引数のうちの最大値
     */
    public static int getMaxNum(String[] args) {
	int max = 0;
	
	for (int i = 0; i < args.length; i++) {
	    if (max < Integer.valueOf(args[i]) ) {
		max = Integer.valueOf(args[i]);
	    }
	}
	return max;
    }
}
