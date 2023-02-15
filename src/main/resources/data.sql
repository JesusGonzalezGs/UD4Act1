
insert into biblioteca (id, nombre, direccion, telefono) values (1, 'Dita', '53 Old Gate Drive', '188-231-7620');
insert into biblioteca (id, nombre, direccion, telefono) values (2, 'Binni', '0 Autumn Leaf Drive', '227-642-0622');
insert into biblioteca (id, nombre, direccion, telefono) values (3, 'Maire', '159 Beilfuss Alley', '302-727-2556');
insert into biblioteca (id, nombre, direccion, telefono) values (4, 'Erroll', '47 Rockefeller Center', '314-980-2839');
insert into biblioteca (id, nombre, direccion, telefono) values (5, 'Claudetta', '9 Sheridan Point', '178-513-5766');
insert into biblioteca (id, nombre, direccion, telefono) values (6, 'Nonah', '9 Oakridge Terrace', '137-673-7648');
insert into biblioteca (id, nombre, direccion, telefono) values (7, 'Jamison', '61612 Pepper Wood Way', '911-708-1566');
insert into biblioteca (id, nombre, direccion, telefono) values (8, 'Ulysses', '66 Sunnyside Plaza', '709-398-4960');
insert into biblioteca (id, nombre, direccion, telefono) values (9, 'Filia', '34048 Bunting Center', '981-578-1342');
insert into biblioteca (id, nombre, direccion, telefono) values (10, 'Wildon', '2538 Raven Circle', '142-362-8218');

insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (1, 'Lotta', 'Boddy', 'lboddy0@i2i.jp', 'P8NR8Rv7A', 1);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (2, 'Lucienne', 'MacAless', 'lmacaless1@baidu.com', 'vYUS5xn2ZqW', 2);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (3, 'Yasmeen', 'Hutchcraft', 'yhutchcraft2@tuttocitta.it', 'LL8e54Hb', 3);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (4, 'Dyana', 'Linnane', 'dlinnane3@wisc.edu', '3s3dHLAQE', 4);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (5, 'Joscelin', 'Whotton', 'jwhotton4@ocn.ne.jp', 'hKjzdjASqmTq', 5);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (6, 'Ulrikaumeko', 'Kinchin', 'ukinchin5@ebay.com', 'XnSNsGV', 6);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (7, 'Mathilde', 'Hugonet', 'mhugonet6@washingtonpost.com', 'obrVCt6OlXQ', 7);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (8, 'Ferdinanda', 'Walentynowicz', 'fwalentynowicz7@phoca.cz', 'FjLwJU', 8);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (9, 'Alanson', 'Skeleton', 'askeleton8@cloudflare.com', 'I9ARD6esnl', 9);
insert into usuario (id, nombre, apellidos, email, password, biblioteca_id) values (10, 'Lissie', 'Ipsgrave', 'lipsgrave9@seattletimes.com', 'oqH2uI', 10);

insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (1, 'Tabloid', 'Kellie', 'Deadline', '151037262-8', 1, 'Documentary', 12.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (2, 'Conquest of the Planet of the Apes', 'Genna', 'Young and the Damned, The (Olvidados, Los)', '049066061-4', 2, 'Action|Sci-Fi', 15.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (3, 'Michael Collins', 'Maddy', 'Shriek of the Mutilated', '258021859-9', 3, 'Drama', 9.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (4, 'Vacancy 2: The First Cut', 'Blaine', 'Milk Money', '465128274-1', 4, 'Horror|Thriller', 19.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (5, 'Hamlet', 'Shelley', 'Thank You a Lot', '032545851-0', 5, 'Drama', 14.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (6, 'European Vacation (aka National Lampoon''s European Vacation)', 'Minny', 'Hannah and Her Sisters', '662781224-X', 6, 'Adventure|Comedy|Romance', 9.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (7, 'Likeable Mister R, The (Simpaticul domn R)', 'Hilde', 'Kitty Foyle', '751798131-5', 7, 'Action|Crime|Thriller', 19.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (8, 'Ivan the Terrible, Part Two (Ivan Groznyy II: Boyarsky zagovor)', 'Anastasie', 'Stevie', '508896309-2', 8, 'Drama', 19.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (9, 'Re-Animator', 'Arne', 'Talk of the Town, The', '716564068-1', 9, 'Comedy|Horror|Sci-Fi', 19.99);
insert into libro (id, titulo, autor, editorial, isbn, num_paginas, categoria, precio) values (10, 'Battleground', 'Hedwig', 'Faithful', '360105657-7', 10, 'Action|Drama|War', 19.99);

insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (1, '2022-04-17', '2022-10-05', 1, 1, 1);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (2, '2022-05-06', '2023-02-06', 2, 2, 2);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (3, '2022-07-16', '2023-01-26', 3, 3, 3);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (4, '2023-01-05', '2022-06-12', 4, 4, 4);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (5, '2022-11-05', '2022-10-15', 5, 5, 5);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (6, '2023-01-22', '2022-04-10', 6, 6, 6);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (7, '2022-12-19', '2022-02-14', 7, 7, 7);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (8, '2022-12-06', '2022-07-07', 8, 8, 8);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (9, '2022-07-04', '2023-01-14', 9, 9, 9);
insert into reserva (id, fecha_in, fecha_out, usuario_id, libro_id, biblioteca_id) values (10, '2022-11-19', '2022-07-13', 10, 10, 10);

insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (1, 1, 1);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (2, 2, 2);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (3, 3, 3);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (4, 4, 4);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (5, 5, 5);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (6, 6, 6);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (7, 7, 7);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (8, 8, 8);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (9, 9, 9);
insert into biblioteca_has_libro (biblioteca_id, libro_id, stock) values (10, 10, 10);
