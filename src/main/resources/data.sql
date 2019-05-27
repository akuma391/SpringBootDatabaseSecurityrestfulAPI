
  INSERT INTO `users` (`username`, `password`, `full_name`, `role`, `country`, `enabled`) VALUES
	('sean', '$2a$10$sQvhIPgfZOOZlAIbViz4pu7L3iSbKvM49fwe0DyqtptRgyb1a.fq6', 'Sean Murphy', 'ROLE_ADMIN', 'US', 1),
	('martin', '$2a$10$16DADbGHgSJnoZLjwfA3m.6TLepVksj0lWK3Vg797LQN2zG4GTpwC', 'Martin Bingel', 'ROLE_USER', 'India', 1); 

   INSERT INTO `topics` (`topic_id`, `title`, `category`) VALUES
	(1, 'Spring Rest Boot', 'Spring Boot'),
	(2, 'Spring Boot Security', 'Spring Boot'),
	(3, 'Spring MVC Framework', 'Spring Framework');