package model;

import java.io.Serializable;
import java.time.LocalDate;

public class TodoItemBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private long id;
	private String title;
	private String username;
	private LocalDate targetDate;
	private boolean isDone;
	
	public TodoItemBean() { }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

}
