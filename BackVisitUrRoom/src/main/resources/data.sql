INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USERFREE'),
(2, 'ROLE_USERPRIME'),
(3, 'ROLE_ADMIN');
INSERT INTO `user` (`id`, `email`, `first_name`, `password`, `username`, `address`, `city`, `neighborhood`, `tipopersona`, `userid`, `phone`) VALUES
(1, 'admin3@visiturroom.site', NULL, '$2a$10$0g2rSOdMFFmCQ4ext1YNresnZl5A8v/UcRF0O7lrlhyk/l8mu1wHi', 'admin', 'Calle 332', 'Bogota DC', 'elBarrio', 'natural', 34324324, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 3);