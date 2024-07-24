package pos_java_jdbc.pos_java_jdbc;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import conexao.jdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserPosDAO userPosDAO =  new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		
		userposjava.setNome("juju");
		userposjava.setEmail("Juju@boken.ruim");
		
		
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for(Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("-----------------------------------");
			}
		

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		
		UserPosDAO dao = new UserPosDAO();
		try {
		Userposjava userposjava = dao.buscar(4L);
		System.out.println(userposjava);		
	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void iniAtualizar() {
		
		
		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco = dao.buscar(4L);
			
			objetoBanco.setNome("Nome atualizado");
			
			dao.atualizar(objetoBanco);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(5L);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
