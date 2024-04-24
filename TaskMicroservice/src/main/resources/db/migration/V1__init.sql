CREATE TABLE tasks (
  id serial PRIMARY KEY,
  title VARCHAR(255) NOT NULL
);

INSERT INTO tasks (title) VALUES ('task1'), ( 'task2'), ('task3'), ('task4');

CREATE TABLE employees (
  id serial PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  surname VARCHAR(255) NOT NULL,
  task_id bigint REFERENCES tasks(id)
);



