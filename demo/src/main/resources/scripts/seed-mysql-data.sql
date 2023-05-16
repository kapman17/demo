DROP TABLE IF EXISTS
  api_key;

CREATE TABLE IF NOT EXISTS
  api_key (
    id VARCHAR(1024) PRIMARY KEY,
    deals_api_key VARCHAR(1024) NOT NULL
  );

INSERT INTO
  api_key
VALUES
  ('1', 'myHash'),
  ('1337', 'newHash');

DROP TABLE IF EXISTS
  os;

CREATE TABLE IF NOT EXISTS
  os (
    id tinyint(4) NOT NULL PRIMARY KEY,
    name varchar(255) DEFAULT NULL,
    option_id tinyint(4) NOT NULL DEFAULT '6',
    UNIQUE KEY os_name (name)
  );

INSERT INTO
  os (id, name, option_id)
VALUES
  (0, 'Unknown', 6),
  (1, 'Windows Phone OS', 4),
  (2, 'Windows', 4),
  (3, 'Android', 1),
  (4, 'Linux', 5),
  (5, 'iPhone', 2),
  (6, 'iPod', 2),
  (7, 'iPad', 2),
  (8, 'Mac', 3),
  (9, 'BlackBerry', 6),
  (10, 'other', 6),
  (11, 'Roku', 7),
  (12, 'Tizen', 8),
  (13, 'SmartCast', 9),
  (14, 'webOS', 10),
  (15, 'PlayStation', 11),
  (16, 'tvOS', 12);

DROP TABLE IF EXISTS
  browser;

CREATE TABLE IF NOT EXISTS
  browser (
    id tinyint(4) NOT NULL PRIMARY KEY,
    name varchar(255) DEFAULT NULL,
    option_id tinyint(4) NOT NULL DEFAULT '6',
    UNIQUE KEY browser_name (name)
  );

INSERT INTO
  browser (id, name, option_id)
VALUES
  (0, 'Unknown', 6),
  (1, 'MSIE', 2),
  (2, 'Firefox', 3),
  (3, 'Chrome', 1),
  (4, 'Safari', 4),
  (5, 'Opera', 5),
  (6, 'iPhone', 6),
  (7, 'BlackBerry', 6),
  (8, 'Android', 6),
  (9, 'MSIE 7', 2),
  (10, 'MSIE 8', 2),
  (11, 'MSIE 9', 2),
  (12, 'MSIE 10', 2),
  (13, 'MSIE 11', 2),
  (14, 'Other', 6),
  (15, 'Bot', 6),
  (16, 'Edge', 8),
  (17, 'WebView', 9),
  (18, 'Facebook', 7),
  (19, 'Samsung', 10),
  (20, 'Amazon Silk', 11),
  (21, 'MIUI', 12),
  (22, 'web OS', 13),
  (23, 'Huawei', 14);
