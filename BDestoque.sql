create table produto (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	codigo VARCHAR(5),
	descricao VARCHAR(100),
	precocusto double,
	precovenda double,
	garantia date,
	quantidade int,
	imagem VARCHAR(100)
);