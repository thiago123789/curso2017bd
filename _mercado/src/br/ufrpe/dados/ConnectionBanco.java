package br.ufrpe.dados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufrpe.dados.interfaces.IBancoConnection;

public class ConnectionBanco implements IBancoConnection {
	private static ConnectionBanco instance;
	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet resultSet;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Problemas carregando o Driver do MySQL");
		}
	}

	public static ConnectionBanco getInstance() {
		if (instance == null) {
			instance = new ConnectionBanco();
		}
		return instance;
	}

	private ConnectionBanco() {
		try {
			conexao = setConexao();
			conexao.setAutoCommit(false);
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionBanco.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private ConnectionBanco(int user) {
		try {
			conexao = setConexao();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionBanco.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private static Connection setConexao() throws SQLException {
		Connection retorno = null;
		retorno = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/supermercado?autoReconnect=true&useSSL=false",
				"curso", "senha@2017");
		retorno.setAutoCommit(false);
		System.out.println("Logou com Administrador");
		return retorno;

	}

	public PreparedStatement retornoStatement(String query) {
		try {
			this.statement = (com.mysql.jdbc.PreparedStatement) this.conexao.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.statement;
	}

	public ResultSet comandoSQL(String query) {
		try {
			this.statement = (com.mysql.jdbc.PreparedStatement) this.getConexaoCommit().prepareStatement(query);
			this.resultSet = this.statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.resultSet;
	}

	public Connection getConexaoCommit() {
		try {
			this.conexao.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conexao;
	}

	public Connection getConexao() {
		try {
			this.conexao.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.conexao;
	}

	public void setConnectionNull() {
		this.conexao = null;
		instance = null;
	}

	public boolean commit() throws SQLException {
		boolean commitou = false;
		try {
			this.conexao.commit();
			commitou = true;
			System.out.println("Commitou");
		} catch (SQLException e) {
			System.out.println("Deu Erro");
			this.conexao.rollback();
		}
		return commitou;

	}

	public void closeConnection() {
		try {
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

