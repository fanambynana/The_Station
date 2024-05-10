INSERT INTO station(station_name, location, reference)
VALUES
('Galana', 'Ivandry', 'galana-ivandry-1'),
('Jovena', 'Ankorondrano', 'jovena-ankorondrano-1'),
('Total', 'Analamahitsy', 'total-analamahitsy-1');

INSERT INTO product(product_name)
VALUES
('essence'),
('gasoil'),
('petrole'); 

INSERT INTO evaporation(rate, period, change_date, id_product)
VALUES
(100, 'PER_DAY', '2024-05-01', 1),
(50, 'PER_DAY', '2024-05-01', 2),
(10, 'PER_DAY', '2024-05-01', 3);

INSERT INTO price(unit_price, app_date, id_product)
VALUES
('5900', '2023-10-01', 1),
('4900', '2023-10-01', 2),
('2130', '2023-10-01', 3);
