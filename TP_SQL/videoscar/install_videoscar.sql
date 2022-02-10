--/*==============================================================*/
--/* Nom de la base :  VIDEO                                     */
--/* Fichier          :  install_videoscar.sql                    */
--/*==============================================================*/

--/*==============================================================*/
--/* Table : ACTEUR                                               */
--/*==============================================================*/

create sequence seq_acteur start with 120;

create table ACTEUR  (
   ACTCOD               SMALLINT                         not null,
   ACTNOM               CHAR(15)                         not null,
   ACTPRE               CHAR(15),
   constraint PK_ACTEUR primary key (ACTCOD)
);

comment on table ACTEUR is
'Les acteurs de films';

comment on column ACTEUR.ACTCOD is
'Code de l''acteur';

comment on column ACTEUR.ACTNOM is
'Nom de l''acteur';

comment on column ACTEUR.ACTPRE is
'Prénom de l''acteur';

--/*==============================================================*/
--/* Table : CATEGORIE                                            */
--/*==============================================================*/


create sequence seq_categorie start with 40
;
create table CATEGORIE  (
   CATCOD               CHAR(2)                          not null,
   CATLIB               CHAR(20)                         not null,
   constraint PK_CATEGORIE primary key (CATCOD)
);

comment on table CATEGORIE is
'Les catégorie de film';

comment on column CATEGORIE.CATCOD is
'Code de la catégorie';

comment on column CATEGORIE.CATLIB is
'Libellé de la catégorie';

--/*==============================================================*/
--/* Table : REALISE                                              */
--/*==============================================================*/

create sequence seq_realise start with 60;
create table REALISE  (
   REACOD               SMALLINT                         not null,
   REANOM               CHAR(15)                         not null,
   REAPRE               CHAR(15)                         not null,
   constraint PK_REALISE primary key (REACOD)
);

comment on table REALISE is
'Les réalisateurs des films';

comment on column REALISE.REACOD is
'Code du réalisateur';

comment on column REALISE.REANOM is
'Nom du réalisateur';

comment on column REALISE.REAPRE is
'Prénom du réalisateur';

--/*==============================================================*/
--/* Table : FILM                                                 */
--/*==============================================================*/

create sequence seq_film start with 80;
create table FILM  (
   FILMCOD              SMALLINT                         not null,
   CATCOD               CHAR(2),
   REACOD               SMALLINT                         not null,
   FILMTIT              CHAR(40)                         not null,
   FILMAN               smallint                         not null,
   FILNAT               CHAR(3)                          not null,
   FILMDUR              SMALLINT,
   constraint PK_FILM primary key (FILMCOD),
   constraint FK_FILM_EST_REALI_REALISE foreign key (REACOD)
         references REALISE (REACOD),
   constraint FK_FILM_APPARTIEN_CATEGORI foreign key (CATCOD)
         references CATEGORIE (CATCOD)
);
--   FILMAN               SMALLINT                         not null,

comment on table FILM is
'Les films loués ou vendus';

comment on column FILM.FILMCOD is
'Code du film';

comment on column FILM.CATCOD is
'Code de la catégorie';

comment on column FILM.REACOD is
'Code du réalisateur';

comment on column FILM.FILMTIT is
'Titre du film';

comment on column FILM.FILMAN is
'Année de sortie du film';

comment on column FILM.FILNAT is
'Nationalité du film';

comment on column FILM.FILMDUR is
'Durée du film (en minute)';

--/*==============================================================*/
--/* Table : K7                                                   */
--/*==============================================================*/

create sequence seq_k7 start with 20;

create table K7  (
   K7COD                SMALLINT                         not null,
   FILMCOD              SMALLINT                         not null,
   K7TYP                CHAR(3)                        default 'VHS'
         constraint CKC_K7TYP_K7 check (K7TYP in ('V20','VHS')),
   K7LOC                CHAR(3)                        default 'VEN'
         constraint CKC_K7LOC_K7 check (K7LOC in ('LOC','VEN')),
   K7PRI                NUMBER(7,2)                      not null,
   K7DAT                DATE                          not null,
   constraint PK_K7 primary key (K7COD),
   constraint FK_K7_MEDIA_FILM foreign key (FILMCOD)
         references FILM (FILMCOD)
);
--   K7DAT                CHAR(6)                          not null,

comment on table K7 is
'Les cassettes de films';

comment on column K7.K7COD is
'Code de la cassette';

comment on column K7.FILMCOD is
'Code du film';

comment on column K7.K7LOC is
'Mode d''acquisition pour le client (location ou vente)';

comment on column K7.K7PRI is
'Prix de la cassette';

comment on column K7.K7DAT is
'Date d''entrée de la cassette';

--/*==============================================================*/
--/* Table : JOUER                                                */
--/*==============================================================*/


create table JOUER  (
   FILMCOD              SMALLINT                         not null,
   ACTCOD               SMALLINT                         not null,
   constraint PK_JOUER primary key (FILMCOD, ACTCOD),
   constraint FK_JOUER_JOUER_FILM foreign key (FILMCOD)
         references FILM (FILMCOD),
   constraint FK_JOUER_JOUER2_ACTEUR foreign key (ACTCOD)
         references ACTEUR (ACTCOD)
);

comment on table JOUER is
'L''acteur joue dans ce film';

comment on column JOUER.FILMCOD is
'Code du film';

comment on column JOUER.ACTCOD is
'Code de l''acteur';

