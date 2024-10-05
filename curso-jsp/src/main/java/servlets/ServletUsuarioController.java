package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.ModelLogin;

import java.io.IOException;
import java.util.List;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.jakartaee.commons.compress.utils.IOUtils;
import java.util.Base64;

import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAOUsuarioRepository;


@MultipartConfig
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
				
			} 
			else if (acao.equalsIgnoreCase("downloadFoto")) {

				String idUser = request.getParameter("id");
				
				ModelLogin modelLogin = daoUsuarioRepository.consultaUsuarioID(idUser, super.getUserLogado(request));
				
				if(modelLogin.getFotouser() != null && !modelLogin.getFotouser().isEmpty()) {
					
					response.setHeader("Content-Disposition", "attachment;filename=arquivo." + modelLogin.getExtensaofotouser());
					
				    byte[] decodedImage = java.util.Base64.getDecoder().decode(modelLogin.getFotouser().split("\\,")[1]);//Decoda a imagem e splita para tirar o data/image:base64, antes da  imagem
				    
				    response.getOutputStream().write(decodedImage); // da a imagem pro user
				}				
			}
			else {
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
			String perfil = request.getParameter("perfil");
			String sexo = request.getParameter("sexo");
			String cep = request.getParameter("cep");
			String logradouro = request.getParameter("logradouro");
			String bairro = request.getParameter("bairro");
			String localidade = request.getParameter("localidade");
			String uf = request.getParameter("uf");
			String numero = request.getParameter("numero");

			ModelLogin modelLogin = new ModelLogin();

			modelLogin.setId(id != null && !id.isEmpty() ? Long.parseLong(id) : null);
			modelLogin.setNome(nome);
			modelLogin.setEmail(email);
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
			modelLogin.setPerfil(perfil);
			modelLogin.setSexo(sexo);
			modelLogin.setCep(cep);
			modelLogin.setLogradouro(logradouro);
			modelLogin.setBairro(bairro);
			modelLogin.setLocalidade(localidade);
			modelLogin.setUf(uf);
			modelLogin.setNumero(numero);
			
			Part part = request.getPart("fileFoto"); // Pega o arquivo enviado com o nome 'fileFoto'
            if (part != null && part.getSize() > 0) { // Verifica se o arquivo existe e tem tamanho
                byte[] foto = IOUtils.toByteArray(part.getInputStream()); // Converte a imagem em bytes
                String imagemBase64 = "data:"+ part.getContentType() + ";base64," +  Base64.getEncoder().encodeToString(foto); // Converte para base64    
                
                modelLogin.setFotouser(imagemBase64);
                modelLogin.setExtensaofotouser(part.getContentType().split("\\/")[1]);                
              
            }

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
