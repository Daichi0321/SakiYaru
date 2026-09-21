//タスクの表示
package SakiYaru;

import java.util.List;

public class TaskView {
	public void taskListView(List<Task> taskList) {
		for (Task task : taskList) {
			System.out.println("タスクID：" + task.getId());
			System.out.println("タスク名：" + task.getTaskName());
			System.out.println("重要度：" + task.getImportance());
			System.out.println("期限：" + task.getDeadline());

			if (task.isCompleted()) {
				System.out.println("進捗：完了済み");
			} else {
				System.out.println("進捗：未完了");
			}

			System.out.println();
		}
	}
}
