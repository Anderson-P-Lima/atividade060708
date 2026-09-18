CREATE TABLE item{
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor VARCHAR(150),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,
};