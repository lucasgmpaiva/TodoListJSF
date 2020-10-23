package br.com.desafio.control;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
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
			if(Objects.isNull(task.getId())) {
				int verificador = 0;
				for(Task task : tasks) {
					if(task.getName().toLowerCase().equals(this.task.getName().toLowerCase())) {
						verificador++;
					}
				}
				if(verificador == 0) {
					taskDAO.save(task);
					Messages.addGlobalInfo("Tarefa cadastrada com sucesso!");
				} else {
					Messages.addGlobalInfo("Tarefa já existente!");
				}
			} else {
				taskDAO.update(task);
				Messages.addGlobalInfo("Tarefa atualizada com sucesso!");
			}
			startar();
		} catch(RuntimeException e) {
			Messages.addGlobalError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public void delete(ActionEvent event) {
		task = (Task) event.getComponent().getAttributes().get("taskSelected");
		try {
			taskDAO.delete(task);
			startar();
		} catch(RuntimeException e) {
			Messages.addGlobalError("Erro ao deletar tarefa!");
			e.printStackTrace();
		}
	}
	
	public void update(ActionEvent event) {
		task = (Task) event.getComponent().getAttributes().get("taskSelected");
	}
	
}
