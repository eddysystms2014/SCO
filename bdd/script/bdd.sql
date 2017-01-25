/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     12/02/2016 0:37:27                           */
/*==============================================================*/


/*==============================================================*/
/* Table: HISTORIACAB                                           */
/*==============================================================*/
create table HISTORIACAB (
   ID_HISTORIACAB       SERIAL not null,
   ID_PACIENTES         INT4                 null,
   ID_MEDICOS           INT4                 null,
   FECHA_HISTORIACAB    DATE                 null,
   TOTAL_HISTORIACAB    NUMERIC              null,
   ESTADO_HISTORIACAB   BOOL                 null,
   constraint PK_HISTORIACAB primary key (ID_HISTORIACAB)
);

/*==============================================================*/
/* Table: HISTORIADET                                           */
/*==============================================================*/
create table HISTORIADET (
   ID_HISTORIACAB       INT4                 null,
   ID_HISTORIADET       SERIAL not null,
   SINTOMAS_HISTORIADET VARCHAR(200)         null,
   FECHA_HISTORIADET    DATE                 null,
   PAGOUNITARIO_HISTORIADET NUMERIC              null,
   constraint PK_HISTORIADET primary key (ID_HISTORIADET)
);

/*==============================================================*/
/* Table: MEDICOS                                               */
/*==============================================================*/
create table MEDICOS (
   ID_MEDICOS           SERIAL not null,
   CEDULA_MEDICOS       VARCHAR(15)          null,
   APELLIDOS_MEDICOS    VARCHAR(100)         null,
   NOMBRES_MEDICOS      VARCHAR(100)         null,
   DOMICILIO_MEDICOS    VARCHAR(100)         null,
   TELEFONO_MEDICOS     VARCHAR(10)          null,
   CELULAR_MEDICOS      VARCHAR(10)          null,
   IMAGEN_MEDICOS       CHAR(254)            null,
   ESTADO_MEDICOS       BOOL                 null,
   constraint PK_MEDICOS primary key (ID_MEDICOS)
);

/*==============================================================*/
/* Table: PACIENTES                                             */
/*==============================================================*/
create table PACIENTES (
   ID_PACIENTES         SERIAL not null,
   CEDULA_PACIENTES     VARCHAR(15)          null,
   APELLIDOS_PACIENTES  VARCHAR(100)         null,
   NOMBRES_PACIENTES    VARCHAR(200)         null,
   DOMICILIO_PACIENTES  VARCHAR(200)         null,
   TELEFONO_PACIENTES   VARCHAR(20)          null,
   CELULAR_PACIENTES    VARCHAR(15)          null,
   IMAGEN_PACIENTES     CHAR(254)            null,
   ESTADO_PACIENTES     BOOL                 null,
   constraint PK_PACIENTES primary key (ID_PACIENTES)
);

/*==============================================================*/
/* Table: PAGOS                                                 */
/*==============================================================*/
create table PAGOS (
   ID_PAGOS             SERIAL not null,
   ID_HISTORIACAB       INT4                 null,
   ESTADO_PAGOS         BOOL                 null,
   constraint PK_PAGOS primary key (ID_PAGOS)
);

/*==============================================================*/
/* Table: ROLES                                                 */
/*==============================================================*/
create table ROLES (
   ID_ROLES             SERIAL not null,
   NOMBRE_ROLES         VARCHAR(20)          null,
   DESCRIPCION_ROLES    VARCHAR(100)         null,
   ESTADO_ROLES         BOOL                 null,
   constraint PK_ROLES primary key (ID_ROLES)
);

/*==============================================================*/
/* Table: USUARIOS                                              */
/*==============================================================*/
create table USUARIOS (
   ID_USUARIOS          SERIAL not null,
   ID_ROLES             INT4                 null,
   NOMBRE_USUARIOS      VARCHAR(20)          null,
   CONTRASENA_USUARIOS  VARCHAR(20)          null,
   ESTADO_USUARIOS      BOOL                 null,
   constraint PK_USUARIOS primary key (ID_USUARIOS)
);

alter table HISTORIACAB
   add constraint FK_HISTORIA_REFERENCE_MEDICOS foreign key (ID_MEDICOS)
      references MEDICOS (ID_MEDICOS)
      on delete restrict on update restrict;

alter table HISTORIACAB
   add constraint FK_HISTORIA_REFERENCE_PACIENTE foreign key (ID_PACIENTES)
      references PACIENTES (ID_PACIENTES)
      on delete restrict on update restrict;

alter table HISTORIADET
   add constraint FK_HISTORIA_REFERENCE_HISTORIA foreign key (ID_HISTORIACAB)
      references HISTORIACAB (ID_HISTORIACAB)
      on delete restrict on update restrict;

alter table PAGOS
   add constraint FK_PAGOS_REFERENCE_HISTORIA foreign key (ID_HISTORIACAB)
      references HISTORIACAB (ID_HISTORIACAB)
      on delete restrict on update restrict;

alter table USUARIOS
   add constraint FK_USUARIOS_REFERENCE_ROLES foreign key (ID_ROLES)
      references ROLES (ID_ROLES)
      on delete restrict on update restrict;

