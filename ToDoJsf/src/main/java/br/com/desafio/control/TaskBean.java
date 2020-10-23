package br.com.desafio.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.desafio.dao.TaskDAO;
import br.com.desafio.model.Task;

@ManagedBean(name = "myBean")
@ViewScoped
public class TaskBean implements Serializable{
	
	private TaskDAO taskDAO = new TaskDAO();
	private Task task;
	private List<Task> tasks;
	
	@PostConstruct
	public void startar() {
		System.out.println("Inicializei a task");
		this.task = new Task();
		this.tasks = taskDAO.list();
		System.out.println(tasks.get(0).getName());
	}
	
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
		taskDAO.save(task);
		tasks.add(task);
		startar();
	}
	
	public void delete() {
		taskDAO.delete(task);
	}
	
	public void update() {
		taskDAO.update(task);
	}
	
}
