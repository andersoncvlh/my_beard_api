CREATE SEQUENCE empresa_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

create table empresa
(
  id bigint NOT NULL,
  razao_social character varying(100),
  nome_fantasia character varying(100),
  CONSTRAINT taxa_pbm_loja_pkey PRIMARY KEY (id)
)