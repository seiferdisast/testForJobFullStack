# testForJobFullStack
Test for full stack job

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