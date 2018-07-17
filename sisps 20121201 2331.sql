-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.28


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sisps
--

CREATE DATABASE IF NOT EXISTS sisps;
USE sisps;

--
-- Definition of table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(127) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `ddd` int(11) NOT NULL,
  `Empresa_cnpj` varchar(18) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`,`Empresa_cnpj`,`Usuario_idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`,`nome`,`endereco`,`cidade`,`uf`,`telefone`,`ddd`,`Empresa_cnpj`,`Usuario_idUsuario`) VALUES 
 (2,'Daniel','Nao tem','nao tem ','DF','3232',61,'10',3),
 (3,'nao tem','nao tem','nao sei','mg','231',65,'10',4);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;


--
-- Definition of table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `cnpj` varchar(18) NOT NULL,
  `nomeEmpresa` varchar(127) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `ddd` int(11) NOT NULL,
  PRIMARY KEY (`cnpj`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empresa`
--

/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`cnpj`,`nomeEmpresa`,`endereco`,`cidade`,`uf`,`telefone`,`ddd`) VALUES 
 ('10','10','10','10','10','10',10);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


--
-- Definition of table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(127) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` varchar(9) NOT NULL,
  `ddd` int(11) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `Empresa_cnpj` varchar(18) NOT NULL,
  `Usuario_idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idFuncionario`,`Empresa_cnpj`,`Usuario_idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`idFuncionario`,`nome`,`endereco`,`telefone`,`ddd`,`cidade`,`uf`,`Empresa_cnpj`,`Usuario_idUsuario`) VALUES 
 (1,'Everton','nao tem','6565',61,'nao tem tambe,','10','10',2);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


--
-- Definition of table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
CREATE TABLE `mensagem` (
  `idMensagem` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `Funcionario_idFuncionario` int(11) NOT NULL,
  `Cliente_idCliente` int(11) NOT NULL,
  PRIMARY KEY (`idMensagem`,`Funcionario_idFuncionario`,`Cliente_idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mensagem`
--

/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` (`idMensagem`,`descricao`,`titulo`,`Funcionario_idFuncionario`,`Cliente_idCliente`) VALUES 
 (1,'asas','asa',1,2);
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;


--
-- Definition of table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `idMenu` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `link` varchar(45) NOT NULL,
  PRIMARY KEY (`idMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`idMenu`,`nome`,`link`) VALUES 
 (1,'Indice','index.jsp'),
 (2,'Perfil','listar_perfil.jsp'),
 (3,'Usuario','listar_usuario.jsp'),
 (4,'Menu','listar_menu.jsp'),
 (5,'Empresa','listar_empresa.jsp'),
 (6,'Cliente','listar_cliente.jsp'),
 (7,'Funcionario','listar_funcionario.jsp'),
 (8,'Mensagem','listar_mensagem.jsp');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE `perfil` (
  `idPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perfil`
--

/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`idPerfil`,`perfil`) VALUES 
 (1,'Administrador'),
 (2,'Funcionario'),
 (3,'Cliente');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


--
-- Definition of table `perfil_menu`
--

DROP TABLE IF EXISTS `perfil_menu`;
CREATE TABLE `perfil_menu` (
  `Perfil_idPerfil` int(11) NOT NULL,
  `Menu_idMenu` int(11) NOT NULL,
  PRIMARY KEY (`Perfil_idPerfil`,`Menu_idMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `perfil_menu`
--

/*!40000 ALTER TABLE `perfil_menu` DISABLE KEYS */;
INSERT INTO `perfil_menu` (`Perfil_idPerfil`,`Menu_idMenu`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (1,5),
 (1,6),
 (1,7),
 (1,8),
 (2,1),
 (2,2),
 (2,4),
 (2,5),
 (2,6),
 (2,7),
 (2,8),
 (3,1),
 (3,3),
 (3,8);
/*!40000 ALTER TABLE `perfil_menu` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `Perfil_idPerfil` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`Perfil_idPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`idUsuario`,`login`,`nome`,`senha`,`Perfil_idPerfil`) VALUES 
 (1,'adm','Administrador','123',1),
 (2,'evert','Everton','1234',2),
 (3,'daniel','Daniel','123',3),
 (4,'nop','Nao tem','123',3);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
