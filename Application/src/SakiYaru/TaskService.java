//登録・一覧表示・更新・削除・完了
package SakiYaru;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
	private int nextId = 1;
	List<Task> taskList = new ArrayList<Task>();

	public void taskRegistration(InputUtil inputUtil) {

		System.out.println("タスク名を入力してください");
		String taskName = inputUtil.inputString();
		System.out.println("重要度を1〜5の整数で入力してください");
		int importance = inputUtil.inputInt(1, 5);
		System.out.println("期限を8桁の形式で入力してください(例：20260928)");
		LocalDate deadline = inputUtil.inputLocalDate();
		boolean completed = false;
		Task task = new Task(nextId, taskName, importance, deadline, completed);
		taskList.add(task);
		nextId += 1;
		System.out.println("登録が完了しました");
//		System.out.println("メニューに戻ります");
	}

	public void showTaskList() {
		System.out.println("表示方法を選択してください");
	}

	public void taskUpdate() {
		System.out.println("更新するIDを入力してください");
	}

	public void taskDelete() {
		System.out.println("削除するIDを入力してください");
	}

	public void taskCompleted() {
		System.out.println("完了するタスクのIDを入力してください");
	}

	public void appClose() {
		System.exit(0);
	}
}
