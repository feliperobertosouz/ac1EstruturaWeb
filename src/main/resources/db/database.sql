-- Database: tasks

-- DROP DATABASE IF EXISTS tasks;

CREATE DATABASE tasks
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TEMPLATE = template0
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.categoria

-- DROP TABLE IF EXISTS public.categoria;

CREATE TABLE IF NOT EXISTS public.categoria
(
    id serial PRIMARY KEY,
    nome character varying(255) NOT NULL
);

ALTER TABLE IF EXISTS public.categoria
    OWNER TO postgres;

-- Table: public.task

-- DROP TABLE IF EXISTS public.task;

CREATE TABLE IF NOT EXISTS public.task
(
    id bigserial PRIMARY KEY,
    title character varying COLLATE pg_catalog."default",
    description character varying COLLATE pg_catalog."default",
    categoria_id integer,
    CONSTRAINT fk_task_categoria FOREIGN KEY (categoria_id)
        REFERENCES public.categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

ALTER TABLE IF EXISTS public.task
    OWNER TO postgres;

    -- Inserção de dados
INSERT INTO public.task (id, title, description, categoria_id)
VALUES (1, 'Tarefa 1', 'Descrição da Tarefa 1', 1),
       (2, 'Tarefa 2', 'Descrição da Tarefa 2', 2),
       (3, 'Tarefa 3', 'Descrição da Tarefa 3', 1);