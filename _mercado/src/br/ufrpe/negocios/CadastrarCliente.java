package br.ufrpe.negocios;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.ufrpe.dados.ClienteDAO;
import br.ufrpe.dados.ConnectionBanco;
import br.ufrpe.dados.PessoaDAO;
import br.ufrpe.dados.interfaces.IClienteDAO;
import br.ufrpe.dados.interfaces.IPessoaDAO;
import br.ufrpe.negocios.beans.Cliente;
import br.ufrpe.negocios.beans.Pessoa;

public class CadastrarCliente {
	private static CadastrarCliente instance;
	private IPessoaDAO pessoa;
	private IClienteDAO cliente;
	private ConnectionBanco conexao;
	
	private CadastrarCliente(){
		pessoa = PessoaDAO.getInstance();
		cliente = ClienteDAO.getInstance();
		conexao = ConnectionBanco.getInstance();
	}
	
	public static CadastrarCliente getInstance(){
		if(instance == null){
			instance = new CadastrarCliente();
		}
		return instance;
	}
	
	public void cadastraPessoa(Cliente p){
		try {
			pessoa.inserir(p);
			cliente.inserir(p);
			conexao.getConexao().commit();
		} catch (SQLException e) {
			try {
				conexao.getConexao().rollback();
			} catch (SQLException e1) {
				JOptionPane.showConfirmDialog(null, e1.getMessage(), "Erro", -1);
			}
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Erro", -1);
		}
	}
	
}
