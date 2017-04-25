package principal;

import java.util.Scanner;

import br.ufrpe.negocios.CadastrarCliente;
import br.ufrpe.negocios.beans.Cliente;
import br.ufrpe.negocios.beans.Pessoa;

public class Principal {

	public static void main(String[] args) {
		CadastrarCliente cadastrar = CadastrarCliente.getInstance();
		
		Pessoa p = new Pessoa();
		p.setTipo_pessoa(3);
		Scanner scn = new Scanner(System.in);
		System.out.println("Insira os dados do Cliente a ser cadastrada");
		System.out.println("CPF:");
		p.setCpf(scn.next());
		System.out.println("Nome:");
		p.setNome(scn.next());
		System.out.println("Senha:");
		p.setSenha(scn.next());
		System.out.println("Idade:");
		p.setIdade(scn.nextInt());
		System.out.println("Sexo => 1 = M / 2 = F:");
		int sexo = scn.nextInt();
		p.setSexo(sexo == 1? true: false);
		Cliente c = new Cliente();
		c.setCpf(p.getCpf());
		c.setIdade(p.getIdade());
		c.setNome(p.getNome());
		c.setSenha(p.getSenha());
		c.setSexo(p.isSexo());
		c.setTipo_pessoa(3);
		cadastrar.cadastraPessoa(c);
		
		
		
	}

}
