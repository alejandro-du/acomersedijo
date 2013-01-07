-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.44-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema acomersedijo
--

CREATE DATABASE IF NOT EXISTS acomersedijo;
USE acomersedijo;

--
-- Definition of table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
CREATE TABLE `articulo` (
  `art_id` bigint(20) NOT NULL,
  `art_publicado` tinyint(1) NOT NULL DEFAULT '0',
  `art_resumen` varchar(5000) NOT NULL,
  `art_titulo` varchar(255) NOT NULL,
  `art_texto` varchar(50000) NOT NULL,
  `art_sub_titulo` varchar(255) DEFAULT NULL,
  `sec_id` bigint(20) NOT NULL,
  `art_visitas` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`art_id`),
  KEY `FK_articulo_sec_id` (`sec_id`),
  CONSTRAINT `FK_articulo_sec_id` FOREIGN KEY (`sec_id`) REFERENCES `seccion` (`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulo`
--

/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` (`art_id`,`art_publicado`,`art_resumen`,`art_titulo`,`art_texto`,`art_sub_titulo`,`sec_id`,`art_visitas`) VALUES 
 (9102,1,'<p style=\"text-align: left;\"><img align=\"right\" src=\"../../images/articulos/welcome10.jpg\" alt=\"\" /></p>\r\n<p style=\"text-align: left;\">En <strong>&iexcl;A comer se dijo!</strong> encontrar&aacute; todo lo que estaba buscando sobre restaurantes: Un completo cat&aacute;logo con los restaurantes de su ciudad, eventos relacionados con nuestros clientes y todo tipo de opiniones y consejos que lo ayudar&aacute;n a relizar la mejor elecci&oacute;n.</p>\r\n<p style=\"text-align: left;\">&nbsp;</p>','Bienvenido al mejor sitio de restaurantes en la web','<p style=\"text-align: left;\"><img alt=\"\" src=\"../../images/articulos/welcome10.jpg\" />En <strong>&iexcl;A comer se dijo!</strong> encontrar&aacute; todo lo que estaba buscando sobre restaurantes: Un completo cat&aacute;logo con los restaurantes de su ciudad, eventos relacionados con nuestros clientes y todo tipo de opiniones y consejos que lo ayudar&aacute;n a relizar la mejor elecci&oacute;n.</p>\r\n<h3 style=\"text-align: left;\">Cat&aacute;logo de restaurantes</h3>\r\n<p style=\"text-align: left;\"><strong>&iexcl;A comer se dijo!</strong> ofrece un cat&aacute;logo con los restaurantes m&aacute;s importantes de cada ciudad y que puede ser consultado por cualquier persona. <strong>No requiere ser un usuario registrado</strong> para consultar nuestro cat&aacute;logo de restaurantes.</p>\r\n<p style=\"text-align: left;\">Puede encontrar r&aacute;pidamente el restaurante que m&aacute;s se acom&oacute;de a sus gustos o requerimientos. Puede realizar una b&uacute;squeda directa con el <strong>buscador</strong> de la parte superior izquierda o puede <strong>navegar por las listas de restaurantes</strong> a partir de una especialidad (por ejemplo comida china o italiana).</p>\r\n<p style=\"text-align: left;\">Si desea realizar una b&uacute;squeda de restaurantes m&aacute;s detallada, puede usar la opci&oacute;n <strong>B&uacute;squeda avanzada</strong>, que le permitir&aacute; especificar par&aacute;metros como ciudad, zona dentro de la ciudad, nombre del restaurante, direcci&oacute;n, o cualquier informaci&oacute;n adicional.</p>\r\n<h3 style=\"text-align: left;\">Eventos&nbsp;</h3>\r\n<p style=\"text-align: left;\"><strong>&iexcl;A comer se dijo!</strong> proporciona informaci&oacute;n sobre <strong>eventos, inauguraciones, fiestas, promociones, conciertos, espect&aacute;culos</strong> o cualquier otro tipo de evento relacionado con nuestros anunciantes, ofreciendo un punto de encuentro que permite intercactuar con la comunidad y con los organizadores del evento.</p>\r\n<h3 style=\"text-align: left;\">Espacio de publicidad para restaurantes</h3>\r\n<p style=\"text-align: left;\"><strong>&iexcl;A comer se dijo!</strong> es adem&aacute;s, un <strong>espacio de publicidad</strong> que se ajusta a sus necesidades y a sus posibilidades. Contamos con una amplia gama de espacios de publicidad que se adaptan a usted. Contamos con un plan <strong>gratuito</strong>, el cual le permitir&aacute; aparecer en nuestro cat&aacute;logo y ser visto por cualquier persona que lo visite.</p>\r\n<p style=\"text-align: left;\">Para los restaurantes que desean <strong>hacer presencia en internet</strong>, esta es una opci&oacute;n econ&oacute;mica, <strong>rentable y efic&aacute;z</strong>. Usted no tendr&aacute; que buscar a sus clientes, ellos lo encontrar&aacute;n a usted. En cada p&aacute;gina de navegaci&oacute;n de nuestro portal web, encontrar&aacute; espacios de publicidad que est&aacute;n a su disposici&oacute;n.</p>','Publicado el 1 de Noviembre de 2008 por Administrador',8903,15),
 (9103,1,'<p style=\"text-align: left;\"><span style=\"font-size: small;\"><strong><img align=\"left\" src=\"../../images/articulos/welcome1.jpg\" alt=\"\" />&iexcl;A comer se dijo!</strong> lo invita a registrar su restaurante completamente <strong>GRATIS</strong>.             Reg&iacute;strese ahora, elija los </span><a href=\"../../../../servicios/inicio/inicio.html\"><span style=\"font-size: small;\">servicios</span></a><span style=\"font-size: small;\"> que desee y pague s&oacute;lo por lo que necesita. Contamos con un plan gratuito que podr&aacute; actualizar en cualquier momento. </span><a href=\"../../../servicios/registrarse\"><span style=\"font-size: small;\">!Reg&iacute;strese ahora!</span></a><span style=\"font-size: small;\">.</span></p>\r\n<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\"><span style=\"font-size: x-small;\"><span style=\"font-family: Courier New;\"><span>TODO: Definir links al sitio de producci&oacute;n.</span></span></span></span></p>','¡Registre su restaurante! ','<p style=\"text-align: left;\"><span style=\"font-size: small;\"><strong>&iexcl;A comer se dijo!</strong> lo invita a registrar su restaurante completamente <strong>GRATIS</strong>.             Reg&iacute;strese ahora, elija los </span><a href=\"../../../../servicios/inicio/inicio.html\"><span style=\"font-size: small;\">servicios</span></a><span style=\"font-size: small;\"> que desee y pague s&oacute;lo por lo que necesita. Contamos con un plan gratuito que podr&aacute; actualizar en cualquier momento. </span><a href=\"../../../../servicios/registrarse\"><span style=\"font-size: small;\">!Reg&iacute;strese ahora!</span></a><span style=\"font-size: small;\">.</span></p>\r\n<p style=\"text-align: left;\"><span style=\"color: rgb(255, 0, 0);\"><span style=\"font-size: x-small;\"><span style=\"font-family: Courier New;\"><span>TODO: Definir links al sitio de producci&oacute;n.</span></span></span></span></p>','Publicado el 1 de Noviembre de 2008 por Administrador',8905,6),
 (9202,1,'<table cellspacing=\"1\" cellpadding=\"1\" border=\"0\" width=\"100%\">\r\n    <tbody>\r\n        <tr>\r\n            <td width=\"50%\"><span style=\"font-size: small;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo.&nbsp;</span></td>\r\n            <td width=\"50%\"><span style=\"font-size: small;\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</span></td>\r\n        </tr>\r\n    </tbody>\r\n</table>','Sólo en Bogotá','<p style=\"text-align: left;\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>\r\n<p style=\"text-align: left;\">Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?</p>\r\n<p style=\"text-align: left;\">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.</p>','Noticia sólo para Bogotá (test)',8903,7);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;


--
-- Definition of table `articulo_ciudad`
--

DROP TABLE IF EXISTS `articulo_ciudad`;
CREATE TABLE `articulo_ciudad` (
  `art_id` bigint(20) NOT NULL,
  `ciu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`art_id`,`ciu_id`),
  KEY `FK_articulo_ciudad_ciu_id` (`ciu_id`),
  CONSTRAINT `FK_articulo_ciudad_art_id` FOREIGN KEY (`art_id`) REFERENCES `articulo` (`art_id`),
  CONSTRAINT `FK_articulo_ciudad_ciu_id` FOREIGN KEY (`ciu_id`) REFERENCES `ciudad` (`ciu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articulo_ciudad`
--

/*!40000 ALTER TABLE `articulo_ciudad` DISABLE KEYS */;
INSERT INTO `articulo_ciudad` (`art_id`,`ciu_id`) VALUES 
 (9102,1753),
 (9103,1753),
 (9102,2902),
 (9103,2902),
 (9102,2952),
 (9103,2952),
 (9102,3103),
 (9103,3103),
 (9202,3103),
 (9102,6802),
 (9103,6802),
 (9102,6803),
 (9103,6803),
 (9102,6804),
 (9103,6804),
 (9102,6805),
 (9103,6805),
 (9102,6806),
 (9103,6806),
 (9102,6807),
 (9103,6807),
 (9102,6808),
 (9103,6808),
 (9102,6809),
 (9103,6809),
 (9102,6810),
 (9103,6810),
 (9102,6811),
 (9103,6811),
 (9102,6812),
 (9103,6812),
 (9102,6813),
 (9103,6813),
 (9102,6814),
 (9103,6814),
 (9102,6815),
 (9103,6815),
 (9102,6816),
 (9103,6816),
 (9102,6817),
 (9103,6817),
 (9102,6818),
 (9103,6818),
 (9102,6819),
 (9103,6819),
 (9102,6820),
 (9103,6820),
 (9102,6821),
 (9103,6821),
 (9102,6822),
 (9103,6822);
/*!40000 ALTER TABLE `articulo_ciudad` ENABLE KEYS */;


--
-- Definition of table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE `ciudad` (
  `ciu_id` bigint(20) NOT NULL,
  `ciu_nombre` varchar(255) NOT NULL,
  `pai_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ciu_id`),
  UNIQUE KEY `UNQ_ciudad_0` (`pai_id`,`ciu_nombre`),
  KEY `FK_ciudad_pai_id` (`pai_id`),
  CONSTRAINT `FK_ciudad_pai_id` FOREIGN KEY (`pai_id`) REFERENCES `pais` (`pai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ciudad`
--

/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`ciu_id`,`ciu_nombre`,`pai_id`) VALUES 
 (6816,'Armenia',3102),
 (1753,'Barranquilla',3102),
 (6819,'Bello',3102),
 (3103,'Bogotá',3102),
 (6809,'Bucaramanga',3102),
 (6817,'Buenaventura',3102),
 (6803,'Cali',3102),
 (6804,'Cartagena',3102),
 (6808,'Cúcuta',3102),
 (6822,'Floridablanca',3102),
 (6811,'Ibagué',3102),
 (6802,'Manizales',3102),
 (2902,'Medellín',3102),
 (6814,'Montería',3102),
 (2952,'Neiva',3102),
 (6818,'Palmira',3102),
 (6812,'Pasto',3102),
 (6805,'Pereira',3102),
 (6820,'Popayán',3102),
 (6806,'San Andrés',3102),
 (6807,'Santa Marta',3102),
 (6821,'Sincelejo',3102),
 (6810,'Soledad',3102),
 (6815,'Valledupar',3102),
 (6813,'Villavicencio',3102);
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;


--
-- Definition of table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
CREATE TABLE `comentario` (
  `com_id` bigint(20) NOT NULL,
  `com_texto` varchar(500) NOT NULL,
  `com_autor` varchar(255) DEFAULT NULL,
  `com_fecha` varchar(255) NOT NULL,
  `com_email` varchar(255) DEFAULT NULL,
  `sec_id` bigint(20) DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `eve_id` bigint(20) DEFAULT NULL,
  `art_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`com_id`),
  KEY `FK_comentario_sec_id` (`sec_id`),
  KEY `FK_comentario_emp_id` (`emp_id`),
  KEY `FK_comentario_art_id` (`art_id`),
  CONSTRAINT `FK_comentario_art_id` FOREIGN KEY (`art_id`) REFERENCES `articulo` (`art_id`),
  CONSTRAINT `FK_comentario_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `empresa` (`emp_id`),
  CONSTRAINT `FK_comentario_sec_id` FOREIGN KEY (`sec_id`) REFERENCES `sector` (`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `comentario`
--

/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` (`com_id`,`com_texto`,`com_autor`,`com_fecha`,`com_email`,`sec_id`,`emp_id`,`eve_id`,`art_id`) VALUES 
 (8003,'Dfj sakldj fañsldkj aweof asñdklfj wepof ajsdñklja sñdfla sdf!','','2008-08-16 21:48','',NULL,NULL,7802,NULL),
 (8159,'DF asd flkasjdñflkajsdñflkaj','asdfasdf','2008-08-17 11:56','',NULL,NULL,8157,NULL),
 (8252,'asdfasdf','asdfasdfasdfasdf','2008-08-21 11:16','',2602,NULL,NULL,NULL),
 (8403,'Yes it is!','yeah','2008-08-22 12:19','',NULL,NULL,8402,NULL),
 (9253,'sdfgsdfgsdfgsdfg sdfg sdfsdfsd fsdfg','sdfg','2008-08-24 22:25','ddsfg@sdfg.sdfg',NULL,NULL,NULL,9202),
 (9254,'SDF asd fasdlkjfasñdkl jasñdlkjfa sñdkljf asdf.','','2008-08-24 22:38','',NULL,NULL,NULL,9103),
 (9302,'asdfasdfasdf','asdf','2008-08-25 18:24','',2602,NULL,NULL,NULL),
 (10756,'Si, el restaurante es muy bueno, pa&#39; que pero sí.','Pepito Pérez','2010-03-13 21:00','pepito@pepito.pérez',NULL,10755,NULL,NULL),
 (10761,'Opino que el restaurante tiene una ambientación excelente, la comida es exquisita y el servicio al cliente es insuperable. Sin duda es uno de los mejores sitios económicos para ir a comer. Felicitaciones!!!','','2010-03-13 21:18','',NULL,10755,NULL,NULL),
 (10762,'La buena mesa y la conversación siempre son un buen lugar  para arreglar el mundo. .... me encanto el lugar , la onda que se forma es muy buena y me senti como en ....  Me encanto el sitio, jamás voy a un restaurante sin recomendaciones.','','2010-03-13 21:19','',NULL,10755,NULL,NULL),
 (10763,'Es bueno, pero me queda muy lejos de la casa XD XD XD','','2010-03-13 21:19','',NULL,10755,NULL,NULL),
 (10765,'¡¡¡¡¡¡¡¡¡Yo quiero ir!!!!!!!!!!!','Alcohólico anónimo','2010-03-13 21:22','',NULL,NULL,10764,NULL);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;


--
-- Definition of table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `emp_id` bigint(20) NOT NULL,
  `emp_email` varchar(255) DEFAULT NULL,
  `emp_website` varchar(255) DEFAULT NULL,
  `emp_nombre` varchar(255) DEFAULT NULL,
  `emp_anuncio` varchar(50000) DEFAULT NULL,
  `emp_direccion` varchar(255) DEFAULT NULL,
  `emp_visitas` bigint(20) unsigned DEFAULT NULL,
  `emp_telefono` varchar(255) DEFAULT NULL,
  `sec_id` bigint(20) DEFAULT NULL,
  `emp_url_imagen` varchar(255) DEFAULT NULL,
  `usu_id` bigint(20) NOT NULL,
  `pla_id` bigint(20) NOT NULL,
  `emp_activa` tinyint(1) NOT NULL,
  `emp_fecha_registro` varchar(255) DEFAULT NULL,
  `zon_id` bigint(20) DEFAULT NULL,
  `emp_precio_promedio` varchar(255) DEFAULT NULL,
  `emp_pago_efectivo` tinyint(1) DEFAULT NULL,
  `emp_pago_american_express` tinyint(1) DEFAULT NULL,
  `emp_pago_diners_club` tinyint(1) DEFAULT NULL,
  `emp_pago_master_card` tinyint(1) DEFAULT NULL,
  `emp_pago_maestro` tinyint(1) DEFAULT NULL,
  `emp_pago_visa` tinyint(1) DEFAULT NULL,
  `emp_domicilios` tinyint(1) DEFAULT NULL,
  `emp_url_banner_adt` varchar(255) DEFAULT NULL,
  `emp_url_banner_aib` varchar(255) DEFAULT NULL,
  `emp_url_banner_aii` varchar(255) DEFAULT NULL,
  `emp_url_banner_asm` varchar(255) DEFAULT NULL,
  `pla_solicitado_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FK_empresa_sec_id` (`sec_id`),
  KEY `FK_empresa_usu_id` (`usu_id`) USING BTREE,
  KEY `FK_empresa_pla_id` (`pla_id`),
  KEY `FK_empresa_zon_id` (`zon_id`),
  CONSTRAINT `FK_empresa_pla_id` FOREIGN KEY (`pla_id`) REFERENCES `plan` (`pla_id`),
  CONSTRAINT `FK_empresa_pla_solicitado_id` FOREIGN KEY (`pla_id`) REFERENCES `plan` (`pla_id`),
  CONSTRAINT `FK_empresa_sec_id` FOREIGN KEY (`sec_id`) REFERENCES `sector` (`sec_id`),
  CONSTRAINT `FK_empresa_usu_id` FOREIGN KEY (`usu_id`) REFERENCES `usuario` (`usu_id`),
  CONSTRAINT `FK_empresa_zon_id` FOREIGN KEY (`zon_id`) REFERENCES `zona` (`zon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empresa`
--

/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` (`emp_id`,`emp_email`,`emp_website`,`emp_nombre`,`emp_anuncio`,`emp_direccion`,`emp_visitas`,`emp_telefono`,`sec_id`,`emp_url_imagen`,`usu_id`,`pla_id`,`emp_activa`,`emp_fecha_registro`,`zon_id`,`emp_precio_promedio`,`emp_pago_efectivo`,`emp_pago_american_express`,`emp_pago_diners_club`,`emp_pago_master_card`,`emp_pago_maestro`,`emp_pago_visa`,`emp_domicilios`,`emp_url_banner_adt`,`emp_url_banner_aib`,`emp_url_banner_aii`,`emp_url_banner_asm`,`pla_solicitado_id`) VALUES 
 (10735,NULL,NULL,'Chin chan chun',NULL,'Calle 123 # 456',1,'555-4 44 22 11',2602,NULL,10732,10733,1,NULL,7353,'15000',1,1,1,1,1,1,1,NULL,NULL,NULL,NULL,10734),
 (10755,'servicio@mamamia.com','http://www.mamamia.com','Mama mía','<p style=\"text-align: left;\"><strong>Mama m&iacute;a </strong>es el mejor restaurante de <em>comida Italiana</em> de la ciudad.</p>\r\n<p style=\"text-align: left;\"><span style=\"color: rgb(0, 0, 255);\">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod  tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim  veniam, quis nostrud <span style=\"font-size: medium;\">exercitation ullamco</span> laboris nisi ut aliquip ex ea  commodo consequat.</span></p>\r\n<p style=\"text-align: left;\"><span style=\"color: rgb(0, 0, 255);\">Duis aute irure dolor in reprehenderit in voluptate  velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint  occaecat cupidatat non proident, sunt in culpa qui officia deserunt  mollit anim id est laborum.</span></p>\r\n<p><span style=\"color: rgb(255, 0, 0);\"><span style=\"font-size: large;\">&iexcl;Lo esperamos!</span></span></p>','Carrera rápida #44-66',7,'555 222 99 88',6752,'/acomersedijo/images/empresas/imagenes/10755.png',10752,10753,1,NULL,7356,'10000',1,0,0,1,0,1,1,NULL,NULL,NULL,NULL,10754),
 (10760,NULL,NULL,'El dragón rojo','<p style=\"text-align: left;\"><span style=\"font-family: Comic Sans MS;\">Sed ut perspiciatis unde omnis iste natus error sit voluptatem  accusantium doloremque laudantium, totam rem aperiam, eaque ipsa<span style=\"color: rgb(128, 128, 128);\"> quae ab  illo inventore veritatis et quasi architecto beatae vitae dicta sunt  e</span>xplicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut  odit aut fugit, sed q<span style=\"color: rgb(51, 102, 255);\">uia consequuntur magni dolores eos qui ratione  voluptatem sequi nesciunt. </span><span style=\"color: rgb(128, 0, 0);\">Neque porro quisquam est, qui dolorem ipsum  quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam  e</span>ius modi tempora incidunt ut labore et dolore magnam aliquam quaerat  voluptatem. Ut enim ad minima <span style=\"color: rgb(0, 128, 128);\">veniam, quis nostrum exercitationem ullam  corporis suscipit laboriosam, ni</span>si ut aliquid ex ea commodi consequatur?  Qui<span style=\"color: rgb(153, 204, 0);\">s autem vel eum iure reprehenderit qui in ea voluptate velit esse  quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo  vo</span>luptas nulla pariatur?</span></p>','Trv. 1 #2-3',2,'555 66 55 44',2602,'/acomersedijo/images/empresas/imagenes/10760.png',10757,10758,1,NULL,7356,'8000',1,1,0,1,0,1,1,NULL,NULL,NULL,NULL,10759);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


--
-- Definition of table `evento`
--

DROP TABLE IF EXISTS `evento`;
CREATE TABLE `evento` (
  `ID` bigint(20) NOT NULL,
  `eve_precio` varchar(255) DEFAULT NULL,
  `eve_descripcion` varchar(1000) NOT NULL,
  `eve_titulo` varchar(255) NOT NULL,
  `eve_informes` varchar(255) DEFAULT NULL,
  `eve_hora` varchar(255) DEFAULT NULL,
  `eve_lugar` varchar(255) DEFAULT NULL,
  `eve_fecha` varchar(255) NOT NULL,
  `emp_id` bigint(20) NOT NULL,
  `zon_id` bigint(20) NOT NULL,
  `eve_visitas` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_evento_zon_id` (`zon_id`),
  KEY `FK_evento_emp_id` (`emp_id`),
  CONSTRAINT `FK_evento_emp_id` FOREIGN KEY (`emp_id`) REFERENCES `empresa` (`emp_id`),
  CONSTRAINT `FK_evento_zon_id` FOREIGN KEY (`zon_id`) REFERENCES `zona` (`zon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `evento`
--

/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`ID`,`eve_precio`,`eve_descripcion`,`eve_titulo`,`eve_informes`,`eve_hora`,`eve_lugar`,`eve_fecha`,`emp_id`,`zon_id`,`eve_visitas`) VALUES 
 (10736,'GRATIS!','Gran fiesta de inauguración.\r\nPROMOCIONES!\r\nLos esperamos!','Fiesta de inauguración!!!','Tel. 555 44 22 11','A partir de las 12:00 pm','Calle falsa &amp;&#3535 123-345','2010-03-19 19:09',10735,7353,1),
 (10764,'5 lucas','Farra y más farra. Lorem ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet ipsum dolor sit amet lorem ipsum dolor sit amet.','¡¡¡Farra!!!','Aquí XD','9 pm','Allá ','2010-03-23 21:20',10760,7355,2);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;


--
-- Definition of table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
CREATE TABLE `grupo` (
  `gru_id` bigint(20) NOT NULL,
  `gru_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`gru_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grupo`
--

/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` (`gru_id`,`gru_nombre`) VALUES 
 (100,'Administradores del sistema'),
 (101,'Usuarios autenticados'),
 (102,'Anunciantes');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;


--
-- Definition of table `grupo_servicio`
--

DROP TABLE IF EXISTS `grupo_servicio`;
CREATE TABLE `grupo_servicio` (
  `gru_id` bigint(20) NOT NULL,
  `ser_id` bigint(20) NOT NULL,
  PRIMARY KEY (`gru_id`,`ser_id`),
  KEY `FK_grupo_servicio_ser_id` (`ser_id`),
  CONSTRAINT `FK_grupo_servicio_gru_id` FOREIGN KEY (`gru_id`) REFERENCES `grupo` (`gru_id`),
  CONSTRAINT `FK_grupo_servicio_ser_id` FOREIGN KEY (`ser_id`) REFERENCES `servicio` (`ser_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grupo_servicio`
--

/*!40000 ALTER TABLE `grupo_servicio` DISABLE KEYS */;
INSERT INTO `grupo_servicio` (`gru_id`,`ser_id`) VALUES 
 (101,200),
 (101,201),
 (101,202),
 (102,203),
 (100,400),
 (100,401),
 (100,402),
 (100,403),
 (100,404),
 (100,405),
 (100,406),
 (100,407),
 (100,408),
 (100,409),
 (100,3202),
 (102,3253),
 (100,5402),
 (102,6652),
 (100,7302),
 (100,7652),
 (102,8352),
 (100,8852),
 (100,8952),
 (100,9352),
 (100,10352),
 (100,10402),
 (102,10454),
 (100,10652);
/*!40000 ALTER TABLE `grupo_servicio` ENABLE KEYS */;


--
-- Definition of table `ip`
--

DROP TABLE IF EXISTS `ip`;
CREATE TABLE `ip` (
  `ip_id` bigint(20) NOT NULL,
  `ip_ip` varchar(255) NOT NULL,
  `ip_alias` varchar(255) NOT NULL,
  PRIMARY KEY (`ip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ip`
--

/*!40000 ALTER TABLE `ip` DISABLE KEYS */;
INSERT INTO `ip` (`ip_id`,`ip_ip`,`ip_alias`) VALUES 
 (1000,'asd asdf fasdf','asdfasdfasdf'),
 (2802,'asdfasdf','asdf'),
 (2803,'qwerqwer','gh'),
 (8902,'111111111','111111111111'),
 (9453,'22222','222222222222'),
 (9552,'4444444444444444','444444444444'),
 (9553,'ggggggggg','hhhhhhhhhhhh'),
 (9602,'xxxxxxxx','xxxxxx'),
 (10003,'3333','33333333333333'),
 (10005,'44444','4444444444444'),
 (10006,'asd asdf fasdf','asdfasdfasdf'),
 (10007,'asd asdf fasdf','asdfasdfasdf'),
 (10009,'asd asdf fasdf','asdfasdfasdf'),
 (10010,'asd asdf fasdf','asdfasdfasdf'),
 (10020,'wwwwwwwwwwww','wwwwwwwwwwwww'),
 (10050,'asd asdf fasdf','asdfasdfasdf'),
 (10060,'asd asdf fasdf','asdfasdfasdf'),
 (10070,'asd asdf fasdf','asdfasdfasdf'),
 (10080,'asd asdf fasdf','asdfasdfasdf'),
 (10200,'asd asdf fasdf','asdfasdfasdf'),
 (10400,'asd asdf fasdf','asdfasdfasdf'),
 (10500,'asd asdf fasdf','asdfasdfasdf'),
 (10600,'asd asdf fasdf','asdfasdfasdf'),
 (10900,'asd asdf fasdf','asdfasdfasdf'),
 (11000,'asd asdf fasdf','asdfasdfasdf'),
 (12000,'asd asdf fasdf','asdfasdfasdf'),
 (13000,'asd asdf fasdf','asdfasdfasdf'),
 (14000,'asd asdf fasdf','asdfasdfasdf'),
 (15000,'asd asdf fasdf','asdfasdfasdf'),
 (16000,'a333334','333333333'),
 (17000,'asd asdf fasdf','asdfasdfasdf'),
 (18000,'asd asdf fasdf','asdfasdfasdf'),
 (19000,'asd asdf fasdf','asdfasdfasdf'),
 (21000,'asd asdf fasdf','asdfasdfasdf'),
 (31000,'asd asdf fasdf','asdfasdfasdf'),
 (41000,'asd asdf fasdf','asdfasdfasdf'),
 (51000,'asd asdf fasdf','asdfasdfasdf'),
 (61000,'asd asdf fasdf','asdfasdfasdf'),
 (71000,'asd asdf fasdf','asdfasdfasdf'),
 (81000,'asd asdf fasdf','asdfasdfasdf'),
 (91000,'asd asdf fasdf','asdfasdfasdf'),
 (111000,'asd asdf fasdf','asdfasdfasdf'),
 (112000,'asd asdf fasdf','asdfasdfasdf'),
 (113000,'asd asdf fasdf','asdfasdfasdf'),
 (114000,'asd asdf fasdf','asdfasdfasdf'),
 (115000,'asd asdf fasdf','asdfasdfasdf'),
 (116000,'asd asdf fasdf','asdfasdfasdf'),
 (117000,'asd asdf fasdf','asdfasdfasdf'),
 (118000,'asd asdf fasdf','asdfasdfasdf'),
 (119000,'asd asdf fasdf','asdfasdfasdf'),
 (120000,'asd asdf fasdf','asdfasdfasdf'),
 (121000,'asd asdf fasdf','asdfasdfasdf'),
 (122000,'asd asdf fasdf','asdfasdfasdf'),
 (123000,'asd asdf fasdf','asdfasdfasdf'),
 (125000,'asd asdf fasdf','asdfasdfasdf'),
 (126000,'asd asdf fasdf','asdfasdfasdf'),
 (127000,'asd asdf fasdf','asdfasdfasdf'),
 (128000,'asd asdf fasdf','asdfasdfasdf'),
 (129000,'asd asdf fasdf','asdfasdfasdf'),
 (134000,'asd asdf fasdf','asdfasdfasdf');
/*!40000 ALTER TABLE `ip` ENABLE KEYS */;


--
-- Definition of table `menu`
--

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `men_id` bigint(20) NOT NULL,
  `men_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`men_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` (`men_id`,`men_nombre`) VALUES 
 (1,'Buscar'),
 (2,'Su cuenta'),
 (3,'Información'),
 (4,'Administración');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;


--
-- Definition of table `pais`
--

DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais` (
  `pai_id` bigint(20) NOT NULL,
  `pai_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`pai_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pais`
--

/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` (`pai_id`,`pai_nombre`) VALUES 
 (3102,'Colombia');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;


--
-- Definition of table `plan`
--

DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan` (
  `pla_id` bigint(20) NOT NULL,
  `pla_link_website` tinyint(1) NOT NULL DEFAULT '0',
  `pla_imagen` tinyint(1) NOT NULL DEFAULT '0',
  `pla_estrellas` bigint(20) NOT NULL,
  `pla_caracteres_html` bigint(20) NOT NULL,
  `pla_banner_aib` tinyint(1) NOT NULL,
  `pla_banner_aii` tinyint(1) NOT NULL,
  `pla_banner_aim` tinyint(1) NOT NULL,
  `pla_banner_asm` tinyint(1) NOT NULL,
  `pla_banner_adt` tinyint(1) unsigned NOT NULL,
  `pla_fecha_pago` varchar(255) DEFAULT NULL,
  `pla_precio` bigint(40) NOT NULL,
  `pla_numero_consignacion` varchar(255) DEFAULT NULL,
  `pla_documento_pagador` varchar(255) DEFAULT NULL,
  `pla_fecha_confirmacion_registro` varchar(255) DEFAULT NULL,
  `pla_notificacion_pago` tinyint(1) unsigned NOT NULL,
  `pla_codigo_registro` varchar(255) NOT NULL,
  `pla_fecha_solicitud_registro` varchar(255) NOT NULL,
  `pla_anterior_id` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`pla_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `plan`
--

/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` (`pla_id`,`pla_link_website`,`pla_imagen`,`pla_estrellas`,`pla_caracteres_html`,`pla_banner_aib`,`pla_banner_aii`,`pla_banner_aim`,`pla_banner_asm`,`pla_banner_adt`,`pla_fecha_pago`,`pla_precio`,`pla_numero_consignacion`,`pla_documento_pagador`,`pla_fecha_confirmacion_registro`,`pla_notificacion_pago`,`pla_codigo_registro`,`pla_fecha_solicitud_registro`,`pla_anterior_id`) VALUES 
 (10733,0,0,0,0,0,0,0,0,0,NULL,0,NULL,NULL,'2010-03-13 19:05',0,'aoqUhNrGRtnkvEW3dtJ9EqBY6zZCmbytkvahpCbUeTpjWqup1T','2010-03-13 19:04',NULL),
 (10734,0,0,0,0,0,0,0,0,0,NULL,0,NULL,NULL,'2010-03-13 19:05',0,'aoqUhNrGRtnkvEW3dtJ9EqBY6zZCmbytkvahpCbUeTpjWqup1T','2010-03-13 19:04',NULL),
 (10753,1,1,0,50000,1,1,1,1,1,'2010-03-13',436200,'333','222','2010-03-13 20:48',0,'pXpHvLCTXBC54PQHeL89Vg1CfadHZe1SfStGgAu9DpXwUb21cn','2010-03-13 20:47',NULL),
 (10754,1,1,0,50000,1,1,1,1,1,'2010-03-13',436200,'333','222','2010-03-13 20:48',0,'pXpHvLCTXBC54PQHeL89Vg1CfadHZe1SfStGgAu9DpXwUb21cn','2010-03-13 20:47',NULL),
 (10758,0,1,3,3000,0,0,1,0,0,'2010-03-13 21:05',113200,'999','333','2010-03-13 21:03',0,'KV6ikMXCnyXf5hB2eQjBigspWkgifUuhMuUfUlcLGHTSfHO2k2','2010-03-13 21:03',NULL),
 (10759,0,1,3,3000,0,0,1,0,0,'2010-03-13 21:05',113200,'999','333','2010-03-13 21:03',0,'KV6ikMXCnyXf5hB2eQjBigspWkgifUuhMuUfUlcLGHTSfHO2k2','2010-03-13 21:03',NULL);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;


--
-- Definition of table `reporte`
--

DROP TABLE IF EXISTS `reporte`;
CREATE TABLE `reporte` (
  `rep_id` bigint(20) NOT NULL,
  `rep_nombre` varchar(255) CHARACTER SET latin1 NOT NULL,
  `rep_consulta` varchar(500) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`rep_id`),
  UNIQUE KEY `UNQ_reporte_0` (`rep_nombre`,`rep_consulta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reporte`
--

/*!40000 ALTER TABLE `reporte` DISABLE KEYS */;
INSERT INTO `reporte` (`rep_id`,`rep_nombre`,`rep_consulta`) VALUES 
 (3152,'Test','SELECT\r\n    emp_nombre Nombre\r\nFROM\r\n   acomersedijo.empresa'),
 (3252,'Test 2','SELECT * FROM acomersedijo.ciudad');
/*!40000 ALTER TABLE `reporte` ENABLE KEYS */;


--
-- Definition of table `seccion`
--

DROP TABLE IF EXISTS `seccion`;
CREATE TABLE `seccion` (
  `sec_id` bigint(20) NOT NULL,
  `sec_nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seccion`
--

/*!40000 ALTER TABLE `seccion` DISABLE KEYS */;
INSERT INTO `seccion` (`sec_id`,`sec_nombre`) VALUES 
 (8903,'Index 1'),
 (8904,'Index 2'),
 (8905,'Index 3');
/*!40000 ALTER TABLE `seccion` ENABLE KEYS */;


--
-- Definition of table `sector`
--

DROP TABLE IF EXISTS `sector`;
CREATE TABLE `sector` (
  `sec_id` bigint(20) NOT NULL,
  `sec_nombre` varchar(255) NOT NULL,
  `sec_visitas` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sector`
--

/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` (`sec_id`,`sec_nombre`,`sec_visitas`) VALUES 
 (1754,'Pastas',640),
 (2202,'Sopas',85),
 (2553,'Pizza',70),
 (2602,'China',530),
 (2603,'Francesa',120),
 (2604,'Japonesa',46),
 (6752,'Italiana',11),
 (6753,'Rápida',3),
 (6754,'Árabe',9);
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;


--
-- Definition of table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sequence`
--

/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` (`SEQ_NAME`,`SEQ_COUNT`) VALUES 
 ('SEQ_GEN','10801');
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;


--
-- Definition of table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
CREATE TABLE `servicio` (
  `ser_id` bigint(20) NOT NULL,
  `ser_url` varchar(255) NOT NULL,
  `ser_publico` tinyint(1) NOT NULL DEFAULT '0',
  `ser_nombre` varchar(255) NOT NULL,
  `men_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ser_id`),
  UNIQUE KEY `UNQ_servicio_0` (`men_id`,`ser_nombre`),
  KEY `FK_servicio_men_id` (`men_id`),
  CONSTRAINT `FK_servicio_men_id` FOREIGN KEY (`men_id`) REFERENCES `menu` (`men_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `servicio`
--

/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`ser_id`,`ser_url`,`ser_publico`,`ser_nombre`,`men_id`) VALUES 
 (1,'/servicios/empresas/',1,'Empresas',NULL),
 (2,'/servicios/registrarse/',1,'Registrarse',NULL),
 (200,'/servicios/autenticacion/',1,'Iniciar sesión',2),
 (201,'/servicios/cerrarSesion/',0,'Cerrar sesión',2),
 (202,'/servicios/actualizarDatos/',0,'Actualizar datos',2),
 (203,'/servicios/editarAnuncio/',0,'Editar anuncio',2),
 (400,'/servicios/administracion/ip/',0,'Administrar IPs',4),
 (401,'/servicios/administracion/usuario/',0,'Administrar usuarios',4),
 (402,'/servicios/administracion/grupo/',0,'Administrar grupos',4),
 (403,'/servicios/administracion/servicio/',0,'Administrar servicios',4),
 (404,'/servicios/administracion/menu/',0,'Administrar menús',4),
 (405,'/servicios/administracion/reporte/',0,'Administrar reportes',4),
 (406,'/servicios/administracion/sector/',0,'Administrar sectores',4),
 (407,'/servicios/administracion/pais/',0,'Administrar paises',4),
 (408,'/servicios/administracion/ciudad/',0,'Administrar ciudades',4),
 (409,'/servicios/administracion/empresa/',0,'Administrar empresas',4),
 (1010,'/comun/',1,'Común',NULL),
 (3202,'/servicios/reportes/reporte.html?sid=3152',0,'Test',3),
 (3253,'/servicios/reportes/reporte.html?sid=3252',0,'Test 2',3),
 (3352,'/servicios/inicio/',1,'Inicio',NULL),
 (4152,'/servicios/contactenos/',1,'Contactenos',NULL),
 (4202,'/servicios/reestablecerPassword/',1,'Reestablecer contraseña',NULL),
 (5402,'/servicios/administracion/comentario/',0,'Administrar comentarios',4),
 (6652,'/servicios/publicarBanners/',0,'Publicar banners',2),
 (7302,'/servicios/administracion/zona/',0,'Administrar zonas',4),
 (7452,'/scripts/',1,'Scripts',NULL),
 (7652,'/servicios/administracion/evento/',0,'Administrar eventos',4),
 (8002,'/servicios/eventos/',1,'Ver evento',NULL),
 (8202,'/servicios/seleccionarCiudad/',1,'Seleccionar ciudad',NULL),
 (8352,'/servicios/publicarEvento/',0,'Publicar evento',2),
 (8852,'/servicios/administracion/seccion/',0,'Administrar secciones',4),
 (8952,'/servicios/administracion/articulo/',0,'Administrar artículos',4),
 (9252,'/servicios/articulos/',1,'Ver artículo',NULL),
 (9352,'/servicios/administracion/fileBrowser/',0,'File Browser',4),
 (9402,'/servicios/genericCrud/',1,'Test Crud',NULL),
 (10352,'/servicios/administracion/plan/',0,'Administrar planes',4),
 (10402,'/servicios/administracion/registrarPago/',0,'Registrar pago',4),
 (10454,'/servicios/pagos/',0,'Confirmar pago',2),
 (10652,'/servicios/administracion/denegarPago/',0,'Denegar pago',4);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `usu_id` bigint(20) NOT NULL,
  `usu_apellido2` varchar(255) DEFAULT NULL,
  `usu_email` varchar(255) NOT NULL,
  `usu_nombre2` varchar(255) DEFAULT NULL,
  `usu_password` varchar(255) NOT NULL,
  `usu_nombre1` varchar(255) NOT NULL,
  `usu_activo` tinyint(1) NOT NULL DEFAULT '0',
  `usu_apellido1` varchar(255) NOT NULL,
  PRIMARY KEY (`usu_id`),
  UNIQUE KEY `UNQ_usuario_0` (`usu_email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`usu_id`,`usu_apellido2`,`usu_email`,`usu_nombre2`,`usu_password`,`usu_nombre1`,`usu_activo`,`usu_apellido1`) VALUES 
 (100,'','admin@admin.admin','','admin','Administrador',1,'Administrador'),
 (10732,'','alejandro.du2@hotmail.com','','test','Alejandro',1,'Duarte'),
 (10752,'','alejandro.du3@hotmail.com','','test','Alejandro',1,'Duarte'),
 (10757,'','alejandro.du4@hotmail.com','','test','Alejandro',1,'Duarte');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;


--
-- Definition of table `usuario_grupo`
--

DROP TABLE IF EXISTS `usuario_grupo`;
CREATE TABLE `usuario_grupo` (
  `usu_id` bigint(20) NOT NULL,
  `gru_id` bigint(20) NOT NULL,
  PRIMARY KEY (`usu_id`,`gru_id`),
  KEY `FK_usuario_grupo_gru_id` (`gru_id`),
  CONSTRAINT `FK_usuario_grupo_gru_id` FOREIGN KEY (`gru_id`) REFERENCES `grupo` (`gru_id`),
  CONSTRAINT `FK_usuario_grupo_usu_id` FOREIGN KEY (`usu_id`) REFERENCES `usuario` (`usu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario_grupo`
--

/*!40000 ALTER TABLE `usuario_grupo` DISABLE KEYS */;
INSERT INTO `usuario_grupo` (`usu_id`,`gru_id`) VALUES 
 (100,100),
 (100,101),
 (10732,101),
 (10752,101),
 (10757,101),
 (10732,102),
 (10752,102),
 (10757,102);
/*!40000 ALTER TABLE `usuario_grupo` ENABLE KEYS */;


--
-- Definition of table `zona`
--

DROP TABLE IF EXISTS `zona`;
CREATE TABLE `zona` (
  `zon_id` bigint(20) NOT NULL DEFAULT '0',
  `zon_nombre` varchar(255) NOT NULL,
  `ciu_id` bigint(20) NOT NULL,
  PRIMARY KEY (`zon_id`),
  UNIQUE KEY `UNQ_zona_0` (`ciu_id`,`zon_nombre`),
  KEY `FK_zona_ciu_id` (`ciu_id`),
  CONSTRAINT `FK_zona_ciu_id` FOREIGN KEY (`ciu_id`) REFERENCES `ciudad` (`ciu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zona`
--

/*!40000 ALTER TABLE `zona` DISABLE KEYS */;
INSERT INTO `zona` (`zon_id`,`zon_nombre`,`ciu_id`) VALUES 
 (7352,'Norte',1753),
 (7357,'Centro',3103),
 (7356,'Chapinero',3103),
 (7353,'Norte',3103),
 (7355,'Occidente',3103),
 (7354,'Sur',3103);
/*!40000 ALTER TABLE `zona` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
