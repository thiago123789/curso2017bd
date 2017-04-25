package br.ufrpe.dados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.ufrpe.dados.interfaces.IPessoaDAO;
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
		pm.setInt(4, p.isSexo()?1:2);
		pm.setInt(5, p.getIdade());
		pm.setDate(6, null);
		pm.setInt(7, p.getTipo_pessoa());
		pm.execute();
	}
	
	@Override
	public ArrayList<Pessoa> listar() throws SQLException{
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		String query = "SELECT * FROM supermercado.pessoa";
			ResultSet resultSet = conexao.comandoSQL(query);
			while(resultSet.next()){
				String cpf = resultSet.getString("cpf");
				String nome = resultSet.getString("nome");
				String senha = resultSet.getString("senha");
				boolean sexo = resultSet.getInt("sexo") == 0? true :false ;
				int idade = resultSet.getInt("idade");
				int tipo_pessoa = resultSet.getInt("tipo_pessoa");
				Pessoa p = new Pessoa(cpf, nome, senha, sexo, idade,null, tipo_pessoa);
				listaPessoas.add(p);
			}
		return listaPessoas;
	}


}
