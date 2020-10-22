package br.com.desafio.control;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.desafio.dao.TaskDAO;
import br.com.desafio.model.Task;

@Named("taskBean")
@ViewScoped
public class TaskBean implements Serializable{
	
	private TaskDAO taskDAO = new TaskDAO();
	private Task task;
	private List<Task> tasks;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void test() {
		System.out.println("Cheguei aqui");
	}

	public void save() {
		//taskDAO.save(task);
		System.out.println("oi");
	}
	
	public void delete() {
		taskDAO.delete(task);
	}
	
	public void update() {
		taskDAO.update(task);
	}
	
	public void list() {
		this.tasks = taskDAO.list();
	}

}
