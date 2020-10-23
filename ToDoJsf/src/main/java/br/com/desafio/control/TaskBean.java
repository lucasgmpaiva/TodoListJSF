package br.com.desafio.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

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
		this.task = new Task();
		try {
			this.tasks = taskDAO.list();
		} catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao listar tarefas!");
			e.printStackTrace();
		}
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

	public void save() {
		try { 
			taskDAO.save(task);
			tasks.add(task);
			Messages.addGlobalInfo("Tarefa cadastrada com sucesso!");
			startar();
		} catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao cadastrar tarefa!");
			e.printStackTrace();
		}
		
	}
	
	public void delete() {
		taskDAO.delete(task);
	}
	
	public void update() {
		taskDAO.update(task);
	}
	
}
