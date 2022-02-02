/*==============================================================*/
/* Nom de SGBD :  Sybase SQL Anywhere 11                        */
/* Date de création :  02/02/2022 14:52:58                      */
/*==============================================================*/


if exists(select 1 from sys.sysforeignkey where role='FK_COMPTE_REFERENCE_CLIENT') then
    alter table COMPTE
       delete foreign key FK_COMPTE_REFERENCE_CLIENT
end if;

if exists(select 1 from sys.sysforeignkey where role='FK_PRET_REFERENCE_CLIENT') then
    alter table PRET
       delete foreign key FK_PRET_REFERENCE_CLIENT
end if;

if exists(
   select 1 from sys.sysconstraint k
      join sys.systab t on (t.object_id = k.table_object_id and t.table_name='CLIENT')
   where
      k.constraint_type = 'P'
) then
    alter table CLIENT
   delete primary key
end if;

if exists(
   select 1 from sys.systable 
   where table_name='CLIENT'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table CLIENT
end if;

if exists(
   select 1 from sys.sysconstraint k
      join sys.systab t on (t.object_id = k.table_object_id and t.table_name='COMPTE')
   where
      k.constraint_type = 'P'
) then
    alter table COMPTE
   delete primary key
end if;

if exists(
   select 1 from sys.systable 
   where table_name='COMPTE'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table COMPTE
end if;

if exists(
   select 1 from sys.sysconstraint k
      join sys.systab t on (t.object_id = k.table_object_id and t.table_name='PRET')
   where
      k.constraint_type = 'P'
) then
    alter table PRET
   delete primary key
end if;

if exists(
   select 1 from sys.systable 
   where table_name='PRET'
     and table_type in ('BASE', 'GBL TEMP')
) then
    drop table PRET
end if;

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT 
(
   NOCLIENT             integer                        not null,
   NOMCLIENT            varchar(18)                    null,
   ADRESSECLIENT        varchar(20)                    null,
   NOTELEPHONE          varchar(15)                    null
);

alter table CLIENT
   add constraint PK_CLIENT primary key clustered (NOCLIENT);

/*==============================================================*/
/* Table : COMPTE                                               */
/*==============================================================*/
create table COMPTE 
(
   NOCOMPTE             integer                        not null,
   SOLDE                DECIMAL(10,2)                  null,
   DATEOUVERTURE        date                           null,
   NOCLIENT             integer                        null
);

alter table COMPTE
   add constraint PK_COMPTE primary key clustered (NOCOMPTE);

/*==============================================================*/
/* Table : PRET                                                 */
/*==============================================================*/
create table PRET 
(
   NOPRET               integer                        not null,
   MONTANTPRET          decimal(10,2)                  null,
   DATEDEBUT            date                           null,
   TAUXINTERET          decimal(10,2)                  null,
   FREQUENCEPAIEMENT    integer                        null,
   NOCLIENT             integer                        null
);

alter table PRET
   add constraint PK_PRET primary key clustered (NOPRET);

alter table COMPTE
   add constraint FK_COMPTE_REFERENCE_CLIENT foreign key (NOCLIENT)
      references CLIENT (NOCLIENT)
      on update restrict
      on delete restrict;

alter table PRET
   add constraint FK_PRET_REFERENCE_CLIENT foreign key (NOCLIENT)
      references CLIENT (NOCLIENT)
      on update restrict
      on delete restrict;

