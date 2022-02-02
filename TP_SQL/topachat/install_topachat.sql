create table topachat.produit as (select * from scott.produit);
alter table produit add constraint pk_produit primary key (noProduit);
commit;