package br.ufrpe.dados;

import java.sql.SQLException;

import br.ufrpe.negocios.beans.Pessoa;

public interface IPessoaDAO {
	
	public void inserir(Pessoa p) throws SQLException;
	
	
}
