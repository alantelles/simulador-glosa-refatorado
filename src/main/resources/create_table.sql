create table tabela_de_precos
(
    valor  numeric(38, 2),
    codigo varchar(255) not null
        primary key
);


INSERT INTO tabela_de_precos (codigo, valor)
VALUES ('20201109', 190),
       ('40601200', 175),
       ('10102019', 132),
       ('78515998', 54),
       ('70193967', 56),
       ('90487540', 59),
       ('90302737', 76),
       ('60023406', 25);
