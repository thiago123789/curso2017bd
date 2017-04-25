package br.ufrpe.dados.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.negocios.beans.Pessoa;

public interface IPessoaDAO {
	
	public void inserir(Pessoa p) throws SQLException;
	public ArrayList<Pessoa> listar() throws SQLException;
	
}
