ALTER TABLE usuario ADD COLUMN role_idrole INTEGER NOT NULL;
ALTER TABLE usuario ADD CONSTRAINT  role_idrole FOREIGN KEY(role_idrole) REFERENCES role(idrole);
CREATE INDEX Usuario_FKIndex2 on usuario(role_idrole);