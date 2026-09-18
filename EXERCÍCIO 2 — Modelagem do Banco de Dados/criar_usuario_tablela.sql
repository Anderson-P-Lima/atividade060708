CREATE TABLE usuario{
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL CHECK (tipo IN (limite_itens > 0)),
};