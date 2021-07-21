INSERT INTO `roles` (`id`, `name`) VALUES
(1, 'ROLE_USERFREE'),
(2, 'ROLE_USERPRIME'),
(3, 'ROLE_ADMIN');
INSERT INTO `user` (`id`, `email`, `first_name`, `password`, `username`, `address`, `city`, `neighborhood`, `tipopersona`, `userid`, `phone`) VALUES
(1, 'admin3@visiturroom.site', NULL, '$2a$10$0g2rSOdMFFmCQ4ext1YNresnZl5A8v/UcRF0O7lrlhyk/l8mu1wHi', 'admin', 'Calle 332', 'Bogota DC', 'elBarrio', 'natural', 34324324, NULL);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 3);
INSERT INTO `rooms` (`id`, `area`, `desctription`, `direccion`, `image`, `lat`, `lng`, `price`, `register_time`, `superficie`, `tipo`, `title`, `update_time`, `owner_user_id`) VALUES
(1, 154, 'Dúplex, Iluminado, amplio, moderno, acabados de excelente calidad, vista panorámica, pisos en madera, cortinas y blackouts en todas las ventanas, cocina abierta, cuarto y baño de servicio, chimenea, 3 garajes y depósito. .', 'Carrera 1A, Cl. 78 #77\'70, Bogotá', 'https://s3.amazonaws.com/imagenes.fincaraiz.com.co/FC_COL/2021/04/05/6230841/apartamento-venta-cundinamarca-bogota-370365980.jpg', '4.656752000000', '-74.055674200000', '990.000.000', '2021-07-18 17:15:33', 154, 'Venta', 'Apartamento en  venta en Los Rosales', '2021-07-18 17:15:33', 1);

--
-- Indices de la tabla `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhc0o4ccx3lnrcsq7rsfoj0idi` (`owner_user_id`);
COMMIT;