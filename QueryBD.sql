GO
create database LPII
GO
Use LPII
GO
create table Curso
(
  Id int primary key,
  Name varchar(30),
  Sigla varchar(4)
)
create table Semestre
(
  Id int primary key,
  Numeracao int
)
create table Bloco
(
  Id int primary key,
  Name varchar(10)
)
create table Sala
(
 Id int primary key,
 Name varchar(10),
 BlocoIdD int foreign key references Bloco(Id)
)
create table Professor
(
	Id int primary key,
	Name varchar(50)
)
create table Disciplina
(
  Id int primary key,
  Name varchar(40),
)
create table ProfessorDisciplina
(
	Id int primary key,
	DisciplinaId int foreign key references Disciplina(Id),
	ProfessorId int foreign key references Professor(Id)	
)
create table CursoSemestre
(
  Id int primary key,
  SemestreId int foreign key references Semestre(Id),
  CursoId int foreign key references Curso(Id)
)
create table Aula
(
  Id int primary key,
  SalaId int foreign key references Sala(Id),
  ProfessorDisciplinaId int foreign key references ProfessorDisciplina(Id),
  CursoSemestreId int foreign key references CursoSemestre(Id),
  Horario datetime
)
create table Perfil
(
  Id int primary key,
  Nome varchar(50),
  Senha varchar(200),--estará criptografado
  Sobrenome varchar(50),
  Categoria bit,
  CursoSemestreId int foreign key references CursoSemestre(Id)
)

