CREATE TABLE `result` (
                          `id` bigint NOT NULL,
                          `passed_date` datetime(6) DEFAULT NULL,
                          `score` int DEFAULT NULL,
                          `user_id` bigint NOT NULL,
                          `quiz_id` bigint NOT NULL DEFAULT '0',
                          PRIMARY KEY (`id`),
                          KEY `fk_result_user1_idx` (`user_id`),
                          KEY `fk_result_quiz1_idx` (`quiz_id`),
                          CONSTRAINT `FKpjjrrf0483ih2cvyfmx70a16b` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                          CONSTRAINT `result_quiz_id_fk` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
