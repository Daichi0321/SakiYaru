//入力受付・入力チェック
package SakiYaru;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
	Scanner scan = new Scanner(System.in);

	public int inputInt() {
		int menuNumber;

		while (true) {
			try {
				menuNumber = scan.nextInt();
			} catch (InputMismatchException inputMiss) {
				System.out.println("入力した値は整数ではありません");
				System.out.println("0～5の整数を再入力してください");
				scan.nextLine();
				continue;
			}

			if (menuNumber >= 0 && menuNumber <= 5) {
				return menuNumber;
			} else {
				System.out.println("入力した値は0～5ではありません");
				System.out.println("0～5の整数を再入力してください");
			}
		}
	}
}
