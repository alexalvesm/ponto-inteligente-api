CREATE TABLE empresa (
  id int NOT NULL PRIMARY KEY IDENTITY(1,1),
  cnpj varchar(255) NOT NULL,
  data_atualizacao datetime NOT NULL,
  data_criacao datetime NOT NULL,
  razao_social varchar(255) NOT NULL
);

CREATE TABLE funcionario (
  id int NOT NULL PRIMARY KEY IDENTITY(1,1),
  cpf varchar(255) NOT NULL,
  data_atualizacao datetime NOT NULL,
  data_criacao datetime NOT NULL,
  email varchar(255) NOT NULL,
  nome varchar(255) NOT NULL,
  perfil varchar(255) NOT NULL,
  qtd_horas_almoco float DEFAULT NULL,
  qtd_horas_trabalho_dia float DEFAULT NULL,
  senha varchar(255) NOT NULL,
  valor_hora decimal(19,2) DEFAULT NULL,
  empresa_id int DEFAULT NULL,
  FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);

CREATE TABLE lancamento (
  id int NOT NULL PRIMARY KEY IDENTITY(1,1),
  data datetime NOT NULL,
  data_atualizacao datetime NOT NULL,
  data_criacao datetime NOT NULL,
  descricao varchar(255) DEFAULT NULL,
  localizacao varchar(255) DEFAULT NULL,
  tipo varchar(255) NOT NULL,
  funcionario_id int DEFAULT NULL,
  FOREIGN KEY (funcionario_id) REFERENCES funcionario(id)
);