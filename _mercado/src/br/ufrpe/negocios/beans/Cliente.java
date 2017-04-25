package br.ufrpe.negocios.beans;

import java.util.Calendar;

public class Cliente extends Pessoa{

	boolean cliente;
	
	public Cliente(String cpf, String nome, String senha, 
			boolean sexo, int idade, Calendar data_nascimento, int tipo_pessoa, boolean isCliente){
		super(cpf, nome, senha, sexo, idade, data_nascimento, tipo_pessoa);
		this.setCliente(isCliente);
	}

	public Cliente( ) {}
	
	public boolean isCliente() {
		return cliente;
	}

	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cliente [cliente=" + cliente + ", getCpf()=" + getCpf() + ", getNome()=" + getNome() + ", getSenha()="
				+ getSenha() + ", isSexo()=" + isSexo() + ", getIdade()=" + getIdade() + ", getData_nascimento()="
				+ getData_nascimento() + ", getTipo_pessoa()=" + getTipo_pessoa() + ", getTelefones()=" + getTelefones()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
		
	
	
	
	
	

}