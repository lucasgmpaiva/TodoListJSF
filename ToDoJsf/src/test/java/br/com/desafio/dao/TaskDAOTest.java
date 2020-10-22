package br.com.desafio.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.desafio.model.Task;

public class TaskDAOTest {

	//testando inserção no banco
	@Test
	@Ignore
	public void save() {
		Task task = new Task();
		task.setName("Ler O Silmarillion");
		task.setDescription("Após ler O Senhor dos Anéis, preciso ler O Silmarillion");
		
		TaskDAO dao = new TaskDAO();
		dao.save(task);
	}
	
	//testando listar
	@Test
	@Ignore
	public void list() {
		TaskDAO dao = new TaskDAO();
		List<Task> result =  dao.list();
		for(Task task : result) {
			System.out.println(task.getName() + " - " + task.getDescription());
		}
	}
	
	//testando busca
	@Test
	@Ignore
	public void search() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getById(1);
		if(task != null) {
			System.out.println("Busquei " + task.getName() + " - " + task.getDescription());
		} else {
			System.out.println("Não encontrei tarefa com este id.");
		}
	}
	
	//testando delete
	@Test
	@Ignore
	public void delete() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getById(1);
		if(task != null) {
			System.out.println("Busquei e deletei a tarefa: " + task.getName() + " - " + task.getDescription());
			dao.delete(task);
		} else {
			System.out.println("Não encontrei tarefa com este id.");
		}
	}
	
	//testando update
	@Test
	@Ignore
	public void update() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getById(2);
		if(task != null) {
			System.out.println("Busquei e encontrei a tarefa: " + task.getName() + " - " + task.getDescription());
			task.setName("Ler O Senhor dos Anéis");
			task.setDescription("Terminar de ler O Senhor dos Anéis!");
			dao.update(task);
		} else {
			System.out.println("Não encontrei tarefa com este id.");
		}
	}
	
}
