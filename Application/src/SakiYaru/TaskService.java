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

	// タスク登録
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

	// タスク一覧
	public void showTaskList(InputUtil inputUtil) {
		taskView.showTaskListMenu();
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

	// 重要度順で並び替え
	public void sortImportance() {
		List<Task> importanceList = new ArrayList<Task>(taskList);
		importanceList.sort(Comparator.comparingInt(Task::getImportance).reversed());
		taskView.taskListView(importanceList);
	}

	// 締切日順で並び替え
	public void sortDeadline() {
		List<Task> deadlineList = new ArrayList<Task>(taskList);
		deadlineList.sort(Comparator.comparing(Task::getDeadline));
		taskView.taskListView(deadlineList);
	}

	// 未完了のみで絞り込み
	public void filterIncomplete() {
		List<Task> incompleteList = taskList.stream()
				.filter(task -> !task.isCompleted())
				.collect(Collectors.toList());
		taskView.taskListView(incompleteList);
	}

	// タスク更新
	public void taskUpdate(InputUtil inputUtil) {
		if (taskList.isEmpty()) {
			System.out.println("タスクが登録されていません");
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			return;
		} else {
			System.out.println("更新するIDを入力してください");
		}

		while (true) {
			int updateId = inputUtil.inputId();
			boolean found = false;

			for (Task task : taskList) {
				if (task.getId() == updateId) {
					taskView.showUpdateMenu();
					int updateNumber = inputUtil.inputInt(0, 3);
					found = true;

					switch (updateNumber) {
					case 1:
						System.out.println("タスク名を入力してください");
						String taskName = inputUtil.inputString();

						task.setTaskName(taskName);

						System.out.println("更新が完了しました");
						System.out.println("Enterキーを押してメニューに戻ります");
						inputUtil.inputString();
						return;
					case 2:
						System.out.println("重要度を1〜5の整数で入力してください");
						int importance = inputUtil.inputInt(1, 5);

						task.setImportance(importance);

						System.out.println("更新が完了しました");
						System.out.println("Enterキーを押してメニューに戻ります");
						inputUtil.inputString();
						return;
					case 3:
						System.out.println("期限を8桁の形式で入力してください(例：20260928)");
						LocalDate deadline = inputUtil.inputLocalDate();

						task.setDeadline(deadline);

						System.out.println("更新が完了しました");
						System.out.println("Enterキーを押してメニューに戻ります");
						inputUtil.inputString();
						return;
					case 0:
						return;
					}
				}
			}

			if (!found) {
				System.out.println("入力したIDは存在しません");
				System.out.println("存在するIDを再入力してください");
			}
		}
	}

	// タスク削除
	public void taskDelete(InputUtil inputUtil) {
		if (taskList.isEmpty()) {
			System.out.println("タスクが登録されていません");
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			return;
		} else {
			System.out.println("削除するIDを入力してください");
		}

		while (true) {
			int deleteId = inputUtil.inputId();
			boolean found = false;
			Task deleteTask = null;

			for (Task task : taskList) {
				if (task.getId() == deleteId) {
					found = true;
					deleteTask = task;
				}
			}

			if (!found) {
				System.out.println("入力したIDは存在しません");
				System.out.println("存在するIDを再入力してください");
			} else {
				System.out.println("本当に削除しますか？(y/n)");
				boolean confirm = inputUtil.inputYesNo();

				if (confirm) {
					taskList.remove(deleteTask);

					System.out.println("削除が完了しました");
					System.out.println("Enterキーを押してメニューに戻ります");
					inputUtil.inputString();
					return;
				} else {
					System.out.println("Enterキーを押してメニューに戻ります");
					inputUtil.inputString();
					return;
				}
			}
		}
	}

	// タスク完了
	public void taskCompleted(InputUtil inputUtil) {
		if (taskList.isEmpty()) {
			System.out.println("タスクが登録されていません");
			System.out.println("Enterキーを押してメニューに戻ります");
			inputUtil.inputString();
			return;
		} else {
			System.out.println("完了するIDを入力してください");
		}

		while (true) {
			int completeId = inputUtil.inputId();
			boolean found = false;
			boolean alreadyCompleted = false;

			for (Task task : taskList) {
				if (task.getId() == completeId) {
					found = true;

					if (task.isCompleted()) {
						alreadyCompleted = true;
					} else {
						task.setCompleted(true);
					}
				}
			}

			if (!found) {
				System.out.println("入力したIDは存在しません");
				System.out.println("存在するIDを再入力してください");
			} else if (alreadyCompleted) {
				System.out.println("入力したIDのタスクは既に完了しています");
				System.out.println("未完了のタスクのIDを再入力してください");
			} else {
				System.out.println("タスクを完了しました");
				System.out.println("Enterキーを押してメニューに戻ります");
				inputUtil.inputString();
				return;
			}
		}
	}

	// アプリ終了
	public void appClose() {
		System.out.println("アプリを終了します");
		System.exit(0);
	}
}
