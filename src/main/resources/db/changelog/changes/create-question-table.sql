CREATE TABLE `question` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quiz_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_question_quiz1_idx` (`quiz_id`),
  CONSTRAINT `fk_question_quiz1` FOREIGN KEY (`quiz_id`) REFERENCES `quiz` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
