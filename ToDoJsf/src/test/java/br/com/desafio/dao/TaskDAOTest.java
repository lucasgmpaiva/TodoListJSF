package br.com.desafio.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.desafio.model.Task;

public class TaskDAOTest {

	@Test
	@DisplayName("Teste de Inserção")
	public void save() {
		Task task = new Task();
		task.setName("Ler O Silmarillion");
		task.setDescription("Após ler O Senhor dos Anéis, preciso ler O Silmarillion");

		TaskDAO dao = new TaskDAO();
		dao.save(task);
	}

	@Test
	@DisplayName("Teste de Listagem")
	public void list() {
		TaskDAO dao = new TaskDAO();
		List<Task> result = dao.list();
		for (Task task : result) {
			System.out.println(task.getName() + " - " + task.getDescription());
		}
	}

	@Test
	@DisplayName("Teste de Busca")
	public void search() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getById(1);
		if (task != null) {
			System.out.println("Busquei " + task.getName() + " - " + task.getDescription());
		} else {
			System.out.println("Não encontrei tarefa com este id.");
		}
	}

	@Test
	@DisplayName("Teste de Remoção")
	public void delete() {
		TaskDAO dao = new TaskDAO();
		Task task = dao.getById(1);
		if (task != null) {
			System.out.println("Busquei e deletei a tarefa: " + task.getName() + " - " + task.getDescription());
			dao.delete(task);
		} else {
			System.out.println("Não encontrei tarefa com este id.");
		}
	}

	@Test
	@DisplayName("Teste de Atualização")
	public void update() {
		TaskDAO dao = new TaskDAO();
		
		Task task1 = new Task();
		task1.setName("taskInicial");
		task1.setDescription("taskInicial");
		dao.save(task1);
		
		Task alterTask = new Task();
		alterTask.setId(1L);
		alterTask.setName("Ler O Senhor dos Anéis");
		alterTask.setDescription("Terminar de ler O Senhor dos Anéis!");
		
		Task task = dao.getById(1);
		task.setName("Ler O Senhor dos Anéis");
		task.setDescription("Terminar de ler O Senhor dos Anéis!");
		dao.update(task);
		
		Assertions.assertEquals(alterTask.getId(), task.getId());
		Assertions.assertEquals(alterTask.getName(), task.getName());
		Assertions.assertEquals(alterTask.getDescription(), task.getDescription());
	}

}
