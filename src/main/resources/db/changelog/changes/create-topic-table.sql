CREATE TABLE `topic` (
                         `id` bigint NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `archived` tinyint NOT NULL DEFAULT '0',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
