CREATE TABLE `user` (
                        `id` bigint NOT NULL,
                        `block` INT DEFAULT NULL,
                        `create_date` date DEFAULT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `surname` varchar(255) DEFAULT NULL,
                        `role_id` bigint DEFAULT NULL,
                        PRIMARY KEY (`id`),
                        KEY `FKn82ha3ccdebhokx3a8fgdqeyy` (`role_id`),
                        CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
