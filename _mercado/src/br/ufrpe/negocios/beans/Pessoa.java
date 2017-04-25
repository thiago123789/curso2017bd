package br.ufrpe.negocios.beans;

import java.util.Calendar;
import java.util.List;

public class Pessoa{
	
	private String cpf;
	private String nome;
	private String senha;
	private boolean sexo; //true = masculino, false = feminino;
	private int idade;
	private Calendar data_nascimento;
	private int tipo_pessoa; //0 = A, 1 = F, 2 = C;
	private List<Telefone> telefones;
	
	public Pessoa(){}
	
	public Pessoa(String cpf, String nome, String senha, 
			boolean sexo, int idade, Calendar data_nascimento, int tipo_pessoa){
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSenha(senha);
		this.setIdade(idade);
		this.setData_nascimento(data_nascimento);
		this.setTipo_pessoa(tipo_pessoa);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		if(idade >= 1){
			this.idade = idade;
		}	
	}

	public Calendar getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Calendar data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public int getTipo_pessoa() {
		return tipo_pessoa;
	}

	public void setTipo_pessoa(int tipo_pessoa) {
		if(tipo_pessoa == 1 || tipo_pessoa == 2 || tipo_pessoa == 3){
			this.tipo_pessoa = tipo_pessoa;	
		}
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", senha=" + senha + ", sexo=" + sexo + ", idade=" + idade
				+ ", data_nascimento=" + data_nascimento + ", tipo_pessoa=" + tipo_pessoa + ", telefones=" + telefones
				+ "]";
	}
	
	
	
	
	
	

}