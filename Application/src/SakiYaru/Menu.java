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
		int menuNumber = inputUtil.inputInt();
		TaskService taskService = new TaskService();

		switch (menuNumber) {
		case 1:
			taskService.taskRegistration();
			break;
		case 2:
			taskService.taskList();
			break;
		case 3:
			taskService.taskUpdate();
			break;
		case 4:
			taskService.taskDelete();
			break;
		case 5:
			taskService.taskComplete();
			break;
		case 0:
			taskService.appClose();
			break;
		}
	}
}
