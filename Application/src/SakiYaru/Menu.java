//メニュー表示・選択
package SakiYaru;

public class Menu {
	public void showMenu() {
		System.out.println("-SakiYaru-");
		System.out.println();
		System.out.println("1.タスク登録");
		System.out.println("2.タスク一覧");
		System.out.println("3.タスク更新");
		System.out.println("4.タスク削除");
		System.out.println("5.タスク完了");
		System.out.println("0.終了");
		System.out.println();
		System.out.println("番号を入力してください");
	}

	public void menuChoice() {
		InputUtil inputUtil = new InputUtil();
		TaskService taskService = new TaskService();

		while (true) {
			showMenu();

			int menuNumber = inputUtil.inputInt(0, 5);

			switch (menuNumber) {
			case 1:
				taskService.taskRegistration(inputUtil);
				break;
			case 2:
				taskService.showTaskList(inputUtil);
				break;
			case 3:
				taskService.taskUpdate(inputUtil);
				break;
			case 4:
				taskService.taskDelete(inputUtil);
				break;
			case 5:
				taskService.taskCompleted(inputUtil);
				break;
			case 0:
				System.out.println("アプリを終了します");
				taskService.appClose();
				break;
			}
		}
	}
}
