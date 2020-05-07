CREATE TABLE Privilegio (
  idPrivilegio INTEGER NOT NULL generated always as identity,
  nome VARCHAR(255) NOT NULL,
  url VARCHAR(255) NOT NULL,
  PRIMARY KEY(idPrivilegio)
);

CREATE TABLE Role (
  idRole INTEGER NOT NULL generated always as identity,
  nome VARCHAR(255) NOT NULL,
  PRIMARY KEY(idRole)
);