import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 入力からのカレンダー表示
 * @author Taichi SHINDO
 */
public class Calendar {
	
    /**
     * メインメソッド
     * はじめに現在の年、月を取得し、その後、userInputYear()、userInputMonth()関数を呼び出す。
     * 入力された値をmakeCalenar()へ渡し、カレンダーを記述する。
     * 
     * @param args
     */
    public static void main (String[] args) {
		
	int year = userInput("YEAR");
	int month = userInput("MONTH");

	printCalendar(year, month);
    }

    /**
     * 月入力用メッセージ関数
     * 月を入力するためのメッセージを表示する
     */
    public static void printMessageForInputMonth() {
	System.out.println("月を入力してください(例：4)");
    }

    /**
     * 年入力用メッセージ関数
     * 年を入力するためのメッセージを表示する
     */
    public static void printMessageForInputYear() {
	System.out.println("年を入力してください(例：2014)");
    }
    
    /**
     * 入力用関数
     * システムからの入力を受け付ける
     * @param system (ex. "YEAR" or "MONTH")
     * @return 入力した値
     */
    public static int userInput(String system) {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean repeatCheck = false;
	int inputNumber = 0;

	while(! repeatCheck){
	    try {
		if (system.equals("YEAR")) {
		    // 年入力用メッセージを出力
		    printMessageForInputYear();
		    // システムの入力を読み込む
		    inputNumber = Integer.parseInt(br.readLine());
		    // 年入力のときのバリデータチェック
		    repeatCheck = validatorCheckForYear(inputNumber);

		} else if (system.equals("MONTH")) {
		    // 月入力用メッセージを出力
		    printMessageForInputMonth();
		    // システムの入力を読み込む
		    inputNumber = Integer.parseInt(br.readLine());
		    // 月入力のときのバリデータチェック
		    repeatCheck = validatorCheckForMonth(inputNumber);

		}
	    } catch(IOException e) {
		System.out.println(e);
	    } catch(NumberFormatException e) {
		System.out.println("数値の形式が正しくありません。");
	    }
	}

	return inputNumber;
    }

    /**
     * 年入力のバリデータチェック
     * @param input 入力した値
     * @return trueなら入力した値に問題なし
     */
    public static boolean validatorCheckForYear(int input) {
	boolean validatorCheck = false;
	
	if (input < 0) {
	    System.out.println("年は1以上の自然数で入力してください。");
	} else if (! String.valueOf(input).matches("^[0-9]+$")) {
	    System.out.println("数値の形式が正しくありません。");
	} else {
	    validatorCheck = true;
	}
	
	return validatorCheck;
    }

    /**
     * 月入力のバリデータチェック
     * @param input 入力した値
     * @return trueなら入力した値に問題なし
     */
    public static boolean validatorCheckForMonth(int input) {
	boolean validatorCheck = false;
	
	if (input < 1 || 12 < input) {
	    System.out.println("月は1～12の間で入力してください。");
	} else if (! String.valueOf(input).matches("^[0-9]+$")) {
	    System.out.println("数値の形式が正しくありません。");
	} else {
	    validatorCheck = true;
	}
	
	return validatorCheck;
    }
	
    /**
     * カレンダーを出力する関数
     * @param year 入力された年
     * @param month 入力された月
     * 
     */
    public static void printCalendar(int year, int month) {
	java.util.Calendar cal = java.util.Calendar.getInstance();		
	cal.set(year, month - 1, 1);
	int startDay = cal.get(java.util.Calendar.DAY_OF_WEEK);
	cal.add(java.util.Calendar.MONTH, 1);
	cal.add(java.util.Calendar.DATE, -1);
	int lastDate = cal.get(java.util.Calendar.DATE);
	    
	makeCalenar(year, month, startDay, lastDate);
    }

    /**
     * カレンダーの書式を設定する関数
     * 入力した年、月、月の開始曜日、月の最終日から、
     * カレンダーを記述します。
     * 
     * @param year 入力された年
     * @param month 入力された月
     * @param startDay 月の開始曜日
     * @param lastDate 月の最終日
     */
    public static void makeCalenar(int year, int month, int startDay, int lastDate){
	System.out.print(year + "年");
	if (month < 10) {
	    System.out.print(" ");
	}

	System.out.println(month + "月");
	System.out.println("日 月 火 水 木 金 土");

	for (int i = 1; i < startDay; i++) {
	    System.out.print("   ");
	}
		
	for (int i = 1; i <= lastDate; i++) {
	    if (i < 10) {
		System.out.print(" " + i);
	    } else if (i == lastDate) {
		System.out.println(i);
	    } else {
		System.out.print(i);
	    }
			
	    if (startDay == 7) {
		System.out.println("");
		startDay = 1;
	    } else {
		System.out.print(" ");
		startDay++;
	    }
	}
    }
}
