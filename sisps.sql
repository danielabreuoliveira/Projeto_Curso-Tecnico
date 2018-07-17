SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `sisps` ;
CREATE SCHEMA IF NOT EXISTS `sisps` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
SHOW WARNINGS;
USE `sisps` ;

-- -----------------------------------------------------
-- Table `Menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Menu` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Menu` (
  `idMenu` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(255) NOT NULL ,
  `link` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idMenu`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Perfil`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Perfil` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Perfil` (
  `idPerfil` INT NOT NULL AUTO_INCREMENT ,
  `perfil` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idPerfil`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Perfil_Menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Perfil_Menu` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Perfil_Menu` (
  `Perfil_idPerfil` INT NOT NULL ,
  `Menu_idMenu` INT NOT NULL ,
  PRIMARY KEY (`Perfil_idPerfil`, `Menu_idMenu`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Empresa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Empresa` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Empresa` (
  `cnpj` VARCHAR(18) NOT NULL ,
  `nomeEmpresa` VARCHAR(127) NOT NULL ,
  `endereco` VARCHAR(255) NOT NULL ,
  `cidade` VARCHAR(45) NOT NULL ,
  `uf` VARCHAR(2) NOT NULL ,
  `telefone` VARCHAR(9) NOT NULL ,
  `ddd` INT NOT NULL ,
  PRIMARY KEY (`cnpj`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Usuario` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NOT NULL ,
  `nome` VARCHAR(45) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  `Perfil_idPerfil` INT NOT NULL ,
  PRIMARY KEY (`idUsuario`, `Perfil_idPerfil`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Cliente` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(127) NOT NULL ,
  `endereco` VARCHAR(255) NOT NULL ,
  `cidade` VARCHAR(45) NOT NULL ,
  `uf` VARCHAR(2) NOT NULL ,
  `telefone` VARCHAR(9) NOT NULL ,
  `ddd` INT NOT NULL ,
  `Empresa_cnpj` VARCHAR(18) NOT NULL ,
  `Usuario_idUsuario` INT NOT NULL ,
  PRIMARY KEY (`idCliente`, `Empresa_cnpj`, `Usuario_idUsuario`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Funcionario` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(127) NOT NULL ,
  `endereco` VARCHAR(255) NOT NULL ,
  `telefone` VARCHAR(9) NOT NULL ,
  `ddd` INT NOT NULL ,
  `cidade` VARCHAR(45) NOT NULL ,
  `uf` VARCHAR(2) NOT NULL ,
  `Empresa_cnpj` VARCHAR(18) NOT NULL ,
  `Usuario_idUsuario` INT NOT NULL ,
  PRIMARY KEY (`idFuncionario`, `Empresa_cnpj`, `Usuario_idUsuario`) )
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `Mensagem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Mensagem` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `Mensagem` (
  `idMensagem` INT NOT NULL AUTO_INCREMENT ,
  `descricao` VARCHAR(255) NOT NULL ,
  `titulo` VARCHAR(20) NOT NULL ,
  `Funcionario_idFuncionario` INT NOT NULL ,
  `Cliente_idCliente` INT NOT NULL ,
  PRIMARY KEY (`idMensagem`, `Funcionario_idFuncionario`, `Cliente_idCliente`) )
ENGINE = InnoDB;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
