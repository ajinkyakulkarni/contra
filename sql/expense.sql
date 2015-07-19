CREATE TABLE expense
(
  id         INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  amount     MEDIUMINT,
  date       DATETIME,
  location   TEXT,
  city       VARCHAR(128),
  type       VARCHAR(128),
  method     VARCHAR(64),
  currency   VARCHAR(16),
  notes      TEXT,
  insertdate TIMESTAMP
);
# example insert
INSERT INTO expense
(amount, date, location, city, type, method, currency, notes)
VALUES
  (
    100, '2015-06-24',
    'My Favorite Fish Restaurant',
    'New York',
    'Eating Out',
    'Debit',
    'USD',
    'Went out with friends'
  );
# example report select
SELECT
  sum(amount),
  date
FROM expense
GROUP BY YEAR(date), MONTH(date);

# MariaDB [expense]> select id,amount,type,method from expense;
# +----+--------+------------+--------+
# | id | amount | type       | method |
# +----+--------+------------+--------+
# |  1 |    100 | Eating Out | Debit  |
# +----+--------+------------+--------+
# ~~~~~~~~~~~~~~~~~~~~~~~~