# testForJobFullStack
Test for full stack job for fruit shop

## Initialize DB on Postgres 

Run this code in your db Postgress

```sql
-- Database: ShopFruits

-- DROP DATABASE IF EXISTS "ShopFruits";

CREATE DATABASE "ShopFruits"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False; 
```

## run back project

* set correct variables in <fruit-shop-back\src\main\resources\application.properties>
* install dependencies with maven `mvn install`
* run project with maven `mvn spring-boot:run`

### APIs

* GET http://localhost:8080/fruitcontroller
* POST http://localhost:8080/fruitcontroller
* DELETE http://localhost:8080/fruitcontroller/{id}
* PUT http://localhost:8080/fruitcontroller/{id}
* GET http://localhost:8080/ordercontroller
* POST http://localhost:8080/ordercontroller