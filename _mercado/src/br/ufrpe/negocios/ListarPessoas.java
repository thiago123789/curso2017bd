package br.ufrpe.negocios;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.dados.PessoaDAO;
import br.ufrpe.dados.interfaces.IPessoaDAO;
import br.ufrpe.negocios.beans.Pessoa;

public class ListarPessoas {
	private static ListarPessoas instance;
	private IPessoaDAO pessoa;
	
	private ListarPessoas(){
		pessoa = PessoaDAO.getInstance();
	}
	
	public static ListarPessoas getInstance(){
		if(instance == null){
			instance = new ListarPessoas();
		}
		return instance;
	}
	
	public ArrayList<Pessoa> ListaDePessoasECPF(){
		ArrayList<Pessoa> retorno = new ArrayList<Pessoa>();
		try {
			ArrayList<Pessoa> pessoasDoSistema = pessoa.listar();
			
		
		
		} catch (SQLException e) {
			e.printStackTrace();
						
		}
		
		return retorno;
	}
	
	
	
}
