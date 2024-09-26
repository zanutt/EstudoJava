package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOUsuarioRepository;

public class ServletUsuarioController extends ServletGenericUtil {
	private static final long serialVersionUID = 1L;

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();

	public ServletUsuarioController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String acao = request.getParameter("acao");

			// Se a ação não estiver definida, por padrão será listar os usuários
			if (acao == null || acao.isEmpty()) {
				acao = "listarUser"; // Define a ação padrão
			}

			if (acao.equalsIgnoreCase("deletarajax")) {
				String idUser = request.getParameter("id");
				if (idUser != null && !idUser.isEmpty()) {
					daoUsuarioRepository.deletarUser(idUser);
					response.getWriter().write("Usuário excluído com sucesso!");
				}
			} else if (acao.equalsIgnoreCase("deletar")) {
				String idUser = request.getParameter("id");
				if (idUser != null && !idUser.isEmpty()) {
					daoUsuarioRepository.deletarUser(idUser);
					
					List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
					request.setAttribute("modelLogins", modelLogins);	
					
					request.setAttribute("msg", "Usuario excluído com sucesso!");
					request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
					
					
				}
				
			} else if (acao.equalsIgnoreCase("buscarUsuarioAjax")) {
				String nomeBusca = request.getParameter("nomeBusca");
				if (nomeBusca != null && !nomeBusca.isEmpty()) {
					List<ModelLogin> dadosJsonUser = daoUsuarioRepository.consultaUsuarioList(nomeBusca, super.getUserLogado(request));
					ObjectMapper mapper = new ObjectMapper();
					String json = mapper.writeValueAsString(dadosJsonUser);
					response.getWriter().write(json);
				}
				
			} else if (acao.equalsIgnoreCase("buscarEditar")) {
				
				String id = request.getParameter("id");
				
				ModelLogin modelLogin = daoUsuarioRepository.consultaUsuarioID(id, super.getUserLogado(request));
				
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
				request.setAttribute("modelLogins", modelLogins);				
				
				request.setAttribute("msg", "Usuario em Edição");
				request.setAttribute("modelLogin", modelLogin);
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				
			} else if (acao.equalsIgnoreCase("listarUser")) {
				
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
				
				request.setAttribute("msg", "Usuarios carregados");
				request.setAttribute("modelLogins", modelLogins);
				request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
				
			} else {
				// Redirecionar para página padrão
				List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
				request.setAttribute("modelLogins", modelLogins);	
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String msg = "";

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			ModelLogin modelLogin = new ModelLogin();

			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);

			if (daoUsuarioRepository.validarLogin(modelLogin.getLogin()) && modelLogin.getId() == null) {
				msg = "Já Existe um usuario com o mesmo login, informe outro login!";
			} else {
				if (modelLogin.isNovo()) {
					msg = "Usuario criado com sucesso!";
				} else {
					msg = "Usuario atualizado com sucesso!";
				}
				modelLogin = daoUsuarioRepository.gravarUsuario(modelLogin, super.getUserLogado(request));
			}

			List<ModelLogin> modelLogins = daoUsuarioRepository.consultaUsuarioList(super.getUserLogado(request));
			request.setAttribute("modelLogins", modelLogins);
			
			request.setAttribute("msg", msg);
			request.setAttribute("modelLogin", modelLogin);
			request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
		}

	}

}
