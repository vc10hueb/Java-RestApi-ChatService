CREATE ROLE dev LOGIN
 PASSWORD 'dev'
 SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

CREATE DATABASE message
 WITH OWNER dev;