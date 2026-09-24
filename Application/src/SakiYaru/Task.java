//タスクデータの保持
package SakiYaru;

import java.time.LocalDate;

public class Task {
	private int id;
	private String taskName;
	private int importance;
	private LocalDate deadline;
	private boolean completed;

	// コンストラクタ
	public Task(int id, String taskName, int importance, LocalDate deadline, boolean completed) {
		this.id = id;
		this.taskName = taskName;
		this.importance = importance;
		this.deadline = deadline;
		this.completed = completed;
	}

	// ゲッターとセッター
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
