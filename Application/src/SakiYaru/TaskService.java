//登録・一覧表示・更新・削除・完了・並び替え・絞り込み
package SakiYaru;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
	private int nextId = 1;
	List<Task> taskList = new ArrayList<Task>();
	TaskView taskView = new TaskView();

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
		System.out.println("Enterキーを押してメニューに戻ります");
		inputUtil.inputString();
	}

	public void showTaskList(InputUtil inputUtil) {
		System.out.println("表示方法を選択してください");
		System.out.println();
		System.out.println("1.通常表示");
		System.out.println("2.重要度順");
		System.out.println("3.締切日順");
		System.out.println("4.未完了のみ");
		System.out.println("0.メニューに戻る");
		System.out.println();
		System.out.println("番号を入力してください");

		int viewNumber = inputUtil.inputInt(0, 4);

		switch (viewNumber) {
		case 1:
			taskView.taskListView(taskList);
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			break;
		case 2:
			sortImportance();
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			break;
		case 3:
			sortDeadline();
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			break;
		case 4:
			filterIncomplete();
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			break;
		case 0:
			break;
		}
	}

	public void sortImportance() {
		List<Task> importanceList = new ArrayList<Task>(taskList);
		importanceList.sort(Comparator.comparingInt(Task::getImportance).reversed());
		taskView.taskListView(importanceList);
	}

	public void sortDeadline() {
		List<Task> deadlineList = new ArrayList<Task>(taskList);
		deadlineList.sort(Comparator.comparing(Task::getDeadline));
		taskView.taskListView(deadlineList);
	}

	public void filterIncomplete() {
		List<Task> incompleteList = taskList.stream()
				.filter(task -> !task.isCompleted())
				.collect(Collectors.toList());
		taskView.taskListView(incompleteList);
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
