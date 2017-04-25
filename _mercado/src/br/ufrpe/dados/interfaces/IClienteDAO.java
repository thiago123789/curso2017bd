package br.ufrpe.dados.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import br.ufrpe.negocios.beans.Cliente;

public interface IClienteDAO {
	public void inserir(Cliente p) throws SQLException;
	public ArrayList<Cliente> listar() throws SQLException;
}
