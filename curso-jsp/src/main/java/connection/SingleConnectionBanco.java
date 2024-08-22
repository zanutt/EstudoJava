package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {

	private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "admin";
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	static {/*Conectar quando chamar a classe direto e nao estiver conectado*/
		conectar();
	}
	
	public SingleConnectionBanco() {/*Quando haver uma instancia ira conectar se nao estiver conectado*/
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");/*Carrega o driver de conexao do banco*/
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false);/*Para nao efetuar altera~cao no banco sem comando*/
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
