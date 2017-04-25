package br.ufrpe.dados;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ufrpe.dados.intefaces.IPessoaDAO;
import br.ufrpe.negocios.beans.Pessoa;

public class PessoaDAO implements IPessoaDAO{
	private static PessoaDAO instance;
	private ConnectionBanco conexao;
	
	private PessoaDAO(){
		this.conexao = ConnectionBanco.getInstance();
	}
	
	public static PessoaDAO getInstance(){
		if(instance == null){
			instance = new PessoaDAO();
		}
		return instance;
	}

	@Override
	public void inserir(Pessoa p) throws SQLException {
		String query = "insert into supermercado.pessoa(cpf, nome, "
				+ "senha, sexo, idade, data_nascimento, tipo_pessoa) "
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement pm = this.conexao.retornoStatement(query);
		pm.setString(1, p.getCpf());
		pm.setString(2, p.getNome());
		pm.setString(3, p.getSenha());
		pm.setInt(4, p.isSexo()?0:1);
		pm.setInt(5, p.getIdade());
		pm.setDate(6, null);
		pm.setInt(7, p.getTipo_pessoa());
	}


}
