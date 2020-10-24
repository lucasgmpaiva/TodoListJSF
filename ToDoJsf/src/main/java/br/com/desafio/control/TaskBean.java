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
			if(!task.getName().equals("")) {
				int occurrences = countName(task.getName());
				if(Objects.isNull(task.getId())) {
					if(occurrences == 0) {
						taskDAO.save(task);
						Messages.addGlobalInfo("Tarefa cadastrada com sucesso!");
					} else {
						Messages.addGlobalError("Tarefa já existente!");
					}
				} else {
						if(occurrences <= 1) {
							taskDAO.update(task);
							Messages.addGlobalInfo("Tarefa atualizada com sucesso!");
						} else {
							Messages.addGlobalError("Tarefa já existente!");
						}
				}
				startar();
			} else {
				Messages.addGlobalError("Campo nome é obrigatório!");
			}
		} catch(RuntimeException e) {
			Messages.addGlobalError(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private int countName(String name) {
		int count = 0;
		for(Task taskIterator : tasks) {
			if(taskIterator.getName().equals(name)) {
				count++;
			}
		}
		return count;
	}
	
	public void delete(ActionEvent event) {
		task = (Task) event.getComponent().getAttributes().get("taskSelected");
		try {
			taskDAO.delete(task);
			Messages.addGlobalInfo("Tarefa deletada com sucesso!");
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
