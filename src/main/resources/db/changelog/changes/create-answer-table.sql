CREATE TABLE `answer` (
                          `id` bigint NOT NULL,
                          `answer` INT DEFAULT NULL,
                          `description` varchar(255) DEFAULT NULL,
                          `question_id` bigint NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `fk_answer_question1_idx` (`question_id`),
                          CONSTRAINT `fk_answer_question1` FOREIGN KEY (`question_id`) REFERENCES `question` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
