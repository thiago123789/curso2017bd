-- criar um schema na base de dados;
create schema supermercado;

-- definir schema a ser utilizado;
use supermercado;

-- entidade generalização
create table pessoa(
	cpf varchar(11) primary key,
    nome varchar(100) not null,
    senha varchar(10) not null,
    sexo enum('M','F') not null,
    idade int(3) not null,
    data_nascimento date,
	tipo_pessoa enum('A','F','C') not null    
);

-- entidade endereço relação a pessoa
create table endereco(
	cep varchar(8) not null,
    logradouro varchar(50) not null,
    estado varchar(15) not null,
    cidade varchar(15) not null,
    numero int(5) not null,
    bairro varchar(50) not null,
    constraint unique key `endereco_individual`(cep, logradouro)
);

-- atributo multivalorado
create table telefones_pessoa(
	cpf varchar(11) not null,
	telefone varchar(10) not null,
    constraint unique key `id_unique_telefone`(cpf, telefone)
);

-- administrador, cliente, funcionario (especializações de pessoa)
create table administrador(
	cpf varchar(11) primary key,
    foreign key (cpf) references pessoa(cpf)
);

create table cliente(
	cpf varchar(11) primary key,
    foreign key (cpf) references pessoa(cpf)
);

-- entidade funcionario
create table funcionario(
	cpf_func varchar(11) primary key,
    tipo_funcionario enum('G','S','OP','E') not null,
    foreign key (cpf_func) references pessoa(cpf)
);

create table gerente(
	cpf varchar(11) primary key,
    foreign key (cpf) references funcionario(cpf_func)
);

create table supervisor(
	cpf varchar(11) primary key,
    foreign key (cpf) references funcionario(cpf_func)
);

create table operador_de_caixa(
	cpf varchar(11) primary key,
    foreign key (cpf) references funcionario(cpf_func)
);

create table estoquista(
	cpf varchar(11) primary key,
    foreign key (cpf) references funcionario(cpf_func)
);

-- entidade produto
create table produto(
	cod_produto int(5) primary key,
	nome varchar(30) not null,
    preco decimal(3,2) not null,
    descricao varchar(100)
);

-- entidade compra
create table compra(
	cod_compra int(4) primary key,
    valor_total decimal(3,2) default 0.00
);

create table cupom_fiscal(
	cod_cupom int(10) primary key
);

-- entidade associativa cliente x realiza x compra
create table clinte_realiza_compra(
	cliente_cpf varchar(11) not null,
    cod_cupom_fiscal int(10) not null,
    cod_compra int(4) not null,
    data_compra timestamp not null,
    op_cx_cpf varchar(11),
    constraint unique key `compra_cliente`(cliente_cpf, cod_compra),
    foreign key (op_cx_cpf) references operador_de_caixa(cpf),
    foreign key (cliente_cpf) references pessoa(cpf),
    foreign key (cod_compra) references compra(cod_compra),
	foreign key (cod_cupom_fiscal) references cupom_fiscal(cod_cupom)
);

-- tabela que mapeia a relação entre compra e produtos (M:N)
create table produto_compra(
	cod_compra int(4) not null,
    cod_produto int(5) not null,
    quant_produtos int(3) not null,
    preco_parcial decimal(4,2) not null,
    constraint unique key `produtos_compra`(cod_compra, cod_produto),
	foreign key (cod_compra) references compra(cod_compra),
    foreign key (cod_produto) references produto(cod_produto)    
)



 


