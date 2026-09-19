//入力受付・入力チェック
package SakiYaru;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
	Scanner scan = new Scanner(System.in);

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

	public String inputString() {
		String text = scan.nextLine();
		return text;
	}
}
