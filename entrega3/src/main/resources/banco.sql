CREATE TABLE `animais` (
  `id` int NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `data_nasc` varchar(255) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `data_entrada` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `data_adocao` varchar(255) DEFAULT NULL,
  `adotado_por` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `data_nasc` varchar(255) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `papel` varchar(15) DEFAULT NULL,
  `pets_adotados` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

