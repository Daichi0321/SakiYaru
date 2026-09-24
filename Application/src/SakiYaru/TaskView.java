//タスクの表示
package SakiYaru;

import java.util.List;

public class TaskView {
	// タスク一覧を表示
	public void taskListView(List<Task> taskList) {
		for (Task task : taskList) {
			System.out.println();
			System.out.println("タスクID：" + task.getId());
			System.out.println("タスク名：" + task.getTaskName());
			System.out.println("重要度：" + task.getImportance());
			System.out.println("期限：" + task.getDeadline());

			if (task.isCompleted()) {
				System.out.println("進捗：完了済み");
			} else {
				System.out.println("進捗：未完了");
			}
		}
	}

	// タスク一覧の表示方法の選択メニューを表示
	public void showTaskListMenu() {
		System.out.println("表示方法を選択してください");
		System.out.println();
		System.out.println("1.通常表示");
		System.out.println("2.重要度順");
		System.out.println("3.締切日順");
		System.out.println("4.未完了のみ");
		System.out.println("0.メニューに戻る");
		System.out.println();
		System.out.println("番号を入力してください");
	}

	// タスク更新の変更項目の選択メニューを表示
	public void showUpdateMenu() {
		System.out.println("変更項目を選択してください");
		System.out.println();
		System.out.println("1.タスク名");
		System.out.println("2.重要度");
		System.out.println("3.締切日");
		System.out.println("0.メニューに戻る");
		System.out.println();
		System.out.println("番号を入力してください");
	}

	// Enterキーの入力を待ってメニューに戻る
	public void backToMenu(InputUtil inputUtil) {
		System.out.println("Enterキーを押してメニューに戻ります");
		inputUtil.inputString();
	}
}
