package br.ufrpe.dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.dados.interfaces.IClienteDAO;
import br.ufrpe.negocios.beans.Cliente;
import br.ufrpe.negocios.beans.Pessoa;

public class ClienteDAO implements IClienteDAO{
	private static ClienteDAO instance;
	private ConnectionBanco conexao;
	
	private ClienteDAO(){
		this.conexao = ConnectionBanco.getInstance();
	}
	
	public static ClienteDAO getInstance(){
		if(instance == null){
			instance = new ClienteDAO();
		}
		return instance;
	}

	@Override
	public void inserir(Cliente p) throws SQLException {
		String query = "insert into supermercado.cliente(cpf)"
				+ "values(?)";
		PreparedStatement pm = this.conexao.retornoStatement(query);
		pm.setString(1, p.getCpf());
		pm.execute();
	}

	@Override
	public ArrayList<Cliente> listar() throws SQLException {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		String query = "SELECT * FROM supermercado.cliente";
			ResultSet resultSet = conexao.comandoSQL(query);
			while(resultSet.next()){
				String cpf = resultSet.getString("cpf");
				Cliente c = new Cliente();
				c.setCpf(cpf);
				listaClientes.add(c);
			}
		return listaClientes;
	}

}
