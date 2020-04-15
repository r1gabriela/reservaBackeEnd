CREATE TABLE Pessoa (
  idPessoa INTEGER NOT NULL generated always as identity,
  nome VARCHAR(255) NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  PRIMARY KEY(idPessoa)
);

CREATE TABLE Mesa (
  idMesa INTEGER NOT NULL generated always as identity,
  capacidade INTEGER NOT NULL,
  localizacao VARCHAR(255) NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(idMesa)
);

CREATE TABLE TipoFuncionario (
  idTipoFuncionario INTEGER NOT NULL generated always as identity,
  descricao VARCHAR(255) NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(idTipoFuncionario)
);

CREATE TABLE TipoComemoracao (
  idTipoComemoracao INTEGER NOT NULL generated always as identity,
  descricao VARCHAR(255) NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(idTipoComemoracao)
);

CREATE TABLE Usuario (
  idUsuario INTEGER NOT NULL generated always as identity,
  Pessoa_idPessoa INTEGER NOT NULL,
  login VARCHAR(8) NOT NULL,
  senha VARCHAR(255) NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(idUsuario),
  FOREIGN KEY(Pessoa_idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE INDEX Usuario_FKIndex1 on Usuario(Pessoa_idPessoa);

CREATE TABLE Funcionario (
  Pessoa_idPessoa INTEGER NOT NULL,
  TipoFuncionario_idTipoFuncionario INTEGER NOT NULL,
  PRIMARY KEY(Pessoa_idPessoa),
  FOREIGN KEY(Pessoa_idPessoa)
    REFERENCES Pessoa(idPessoa),
  FOREIGN KEY(TipoFuncionario_idTipoFuncionario)
    REFERENCES TipoFuncionario(idTipoFuncionario)
);

CREATE INDEX Funcionario_FKIndex1 on Funcionario(Pessoa_idPessoa);
CREATE INDEX Funcionario_FKIndex2 on Funcionario(TipoFuncionario_idTipoFuncionario);

CREATE TABLE Cliente (
  Pessoa_idPessoa INTEGER NOT NULL,
  telefone VARCHAR(11) NOT NULL,
  email VARCHAR(255) NOT NULL,
  PRIMARY KEY(Pessoa_idPessoa),
  FOREIGN KEY(Pessoa_idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE INDEX Cliente_FKIndex1 on Cliente(Pessoa_idPessoa);

CREATE TABLE Dependente (
  Pessoa_idPessoa INTEGER NOT NULL,
  Cliente_Pessoa_idPessoa INTEGER NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(Pessoa_idPessoa),
  FOREIGN KEY(Pessoa_idPessoa)
    REFERENCES Pessoa(idPessoa),
  FOREIGN KEY(Cliente_Pessoa_idPessoa)
    REFERENCES Cliente(Pessoa_idPessoa)
);

CREATE INDEX Dependente_FKIndex1 on Dependente(Pessoa_idPessoa);
CREATE INDEX Dependente_FKIndex2 on Dependente(Cliente_Pessoa_idPessoa);

CREATE TABLE Reserva (
  idReserva INTEGER NOT NULL generated always as identity,
  Mesa_idMesa INTEGER NOT NULL,
  Cliente_Pessoa_idPessoa INTEGER NOT NULL,
  dataHora TIMESTAMP NOT NULL,
  ativo BOOLEAN NOT NULL DEFAULT TRUE,
  PRIMARY KEY(idReserva),
  FOREIGN KEY(Cliente_Pessoa_idPessoa)
    REFERENCES Cliente(Pessoa_idPessoa),
  FOREIGN KEY(Mesa_idMesa)
    REFERENCES Mesa(idMesa)
);

CREATE INDEX Reserva_FKIndex1 on Reserva(Cliente_Pessoa_idPessoa);
CREATE INDEX Reserva_FKIndex2 on Reserva(Mesa_idMesa);

CREATE TABLE DataComemorativa (
  idDataComemorativa INTEGER NOT NULL generated always as identity,
  Pessoa_idPessoa INTEGER NOT NULL,
  Cliente_Pessoa_idPessoa INTEGER NOT NULL,
  TipoComemoracao_idTipoComemoracao INTEGER NOT NULL,
  data_comemoracao DATE NOT NULL,
  PRIMARY KEY(idDataComemorativa),
  FOREIGN KEY(TipoComemoracao_idTipoComemoracao)
    REFERENCES TipoComemoracao(idTipoComemoracao),
  FOREIGN KEY(Cliente_Pessoa_idPessoa)
    REFERENCES Cliente(Pessoa_idPessoa),
  FOREIGN KEY(Pessoa_idPessoa)
    REFERENCES Pessoa(idPessoa)
);

CREATE INDEX DataComemorativa_FKIndex1 on DataComemorativa(TipoComemoracao_idTipoComemoracao);
CREATE INDEX DataComemorativa_FKIndex2 on DataComemorativa(Cliente_Pessoa_idPessoa);
CREATE INDEX DataComemorativa_FKIndex3 on DataComemorativa(Pessoa_idPessoa);