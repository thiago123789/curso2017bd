package br.ufrpe.negocios.beans;

import java.util.Calendar;

public class Cliente extends Pessoa{

	boolean cliente;
	
	public Cliente(String cpf, String nome, String senha, 
			boolean sexo, int idade, Calendar data_nascimento, int tipo_pessoa, boolean isCliente){
		super(cpf, nome, senha, sexo, idade, data_nascimento, tipo_pessoa);
		this.setCliente(isCliente);
	}

	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}