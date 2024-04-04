-- Database: tasks

-- DROP DATABASE IF EXISTS tasks;

CREATE TABLE IF NOT EXISTS public.aluno
(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    idade INTEGER NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL
);

-- INSERT
INSERT INTO public.aluno (nome, email, idade, cpf, telefone)
VALUES
    ('João Silva', 'joao@example.com', 25, '123.456.789-01', '(11) 98765-4321'),
    ('Maria Santos', 'maria@example.com', 30, '987.654.321-09', '(22) 12345-6789'),
    ('Carlos Oliveira', 'carlos@example.com', 22, '456.789.012-34', '(33) 55555-5555');
