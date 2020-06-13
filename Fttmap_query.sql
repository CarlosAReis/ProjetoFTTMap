/*create database fttmap;
use fttmap;
*/
CREATE TABLE `Usuario` (
  `Id` int  PRIMARY KEY auto_increment,
  `Username` varchar(20) unique,
  `Nome` varchar(20),
  `Sobrenome` varchar(50),
  `Senha` varchar(50),
  `Categoria` varchar(20),
  `Curso` varchar(20),
  `Semestre` int,
  `IsEnabled`boolean
  
);
/*104-107-116-112-117*/
insert into 
`Usuario`(`Username`,`Nome`,`Sobrenome`,`Senha`,`Categoria`,`Curso`,`Semestre`,`IsEnabled`) 
values ('admin','Administrador','Administrador','104-107-116-112-117','Administrador','ALL','0', true) ;

use fttmap;
select * from Usuario;

