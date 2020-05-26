CREATE TABLE Role_Privilegio (
  role_idrole INTEGER NOT NULL,
  privilegio_idprivilegio INTEGER NOT NULL,
  FOREIGN KEY(role_idrole)
    REFERENCES role(idrole),
  FOREIGN KEY(privilegio_idprivilegio)
    REFERENCES privilegio(idprivilegio)
);

CREATE INDEX Role_Privilegio_FKIndex1 on role_privilegio(role_idrole);
CREATE INDEX Role_Privilegio_FKIndex2 on role_privilegio(privilegio_idprivilegio);