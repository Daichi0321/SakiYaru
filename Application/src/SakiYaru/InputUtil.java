//入力受付・入力チェック
package SakiYaru;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
	Scanner scan = new Scanner(System.in);

	// 引数で受け取った範囲の整数を入力
	public int inputInt(int min, int max) {
		int inputNumber;

		while (true) {
			try {
				inputNumber = scan.nextInt();
			} catch (InputMismatchException inputMiss) {
				System.out.println("入力した値は整数ではありません");
				System.out.println(min + "～" + max + "の整数を再入力してください");
				scan.nextLine();
				continue;
			}

			if (inputNumber >= min && inputNumber <= max) {
				scan.nextLine();
				return inputNumber;
			} else {
				System.out.println("入力した値は" + min + "～" + max + "ではありません");
				System.out.println(min + "～" + max + "の整数を再入力してください");
			}
		}
	}

	// 文字列を入力
	public String inputString() {
		String text = scan.nextLine();
		return text;
	}

	// 日付を8桁の形式で入力
	public LocalDate inputLocalDate() {
		while (true) {
			try {
				String inputDate = scan.nextLine();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuuMMdd")
						.withResolverStyle(ResolverStyle.STRICT);
				return LocalDate.parse(inputDate, dateFormat);
			} catch (DateTimeParseException inputMiss) {
				System.out.println("入力した日付が正しくありません");
				System.out.println("正しい日付を8桁の形式で入力してください");
				continue;
			}
		}
	}

	// 1以上のIDを入力
	public int inputId() {
		int id;

		while (true) {
			try {
				id = scan.nextInt();
			} catch (InputMismatchException inputMiss) {
				System.out.println("入力した値は整数ではありません");
				System.out.println("1以上の整数を再入力してください");
				scan.nextLine();
				continue;
			}

			if (id >= 1) {
				scan.nextLine();
				return id;
			} else {
				System.out.println("入力した値は1以上ではありません");
				System.out.println("1以上の整数を再入力してください");
			}
		}
	}

	// yかnを入力
	public boolean inputYesNo() {
		while (true) {
			String answer = scan.nextLine();

			if (answer.equals("y")) {
				return true;
			} else if (answer.equals("n")) {
				return false;
			} else {
				System.out.println("入力した値が正しくありません");
				System.out.println("y(yes)またはn(no)を再入力してください");
			}
		}
	}
}
