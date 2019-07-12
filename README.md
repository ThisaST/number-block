
Change the following credentials in **application.properties file.**
1. **server.port=9696** -> change this port to your relevant port **eg:9595, 8080.**
    
2. **spring.datasource.url=jdbc:mysql://localhost:**3307**/numberblock** -> change the following port number to your relevant **MYSQL Server port.**
		
3. **spring.datasource.username=root** -> change the **username** to your relevant username on **MySQL Database.**
		
4. **spring.datasource.password=root** -> change the **Password** to your relevant Password on **MySQL Database.**

**Execute the following Queries in your MySQL Database**

**CREATE SCHEMA `numberblock`;**

**CREATE TABLE `number_block` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `number_combination` varchar(50) NOT NULL,
  `pick_type` varchar(20) NOT NULL,
  `cost` decimal(12,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;**
