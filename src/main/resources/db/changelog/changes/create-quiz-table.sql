CREATE TABLE `quiz` (
                        `id` bigint NOT NULL,
                        `description` text,
                        `topic_id` bigint NOT NULL,
                        `archived` INT NOT NULL DEFAULT '0',
                        `create_date` date DEFAULT NULL,
                        `difficult` VARCHAR(255) NOT NULL DEFAULT 'easy',
                        `duration` INT DEFAULT NULL,
                        `header` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `quiz_header_uindex` (`header`),
                        KEY `fk_quiz_topic1_idx` (`topic_id`),
                        CONSTRAINT `fk_quiz_topic1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
