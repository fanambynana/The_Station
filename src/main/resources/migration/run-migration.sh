#!/bin/bash

echo "=== Drop and Create main DB ==="
find . -name "create-db.sql" -exec psql postgres://$DB_USERNAME:$DB_PASSWORD@localhost:5432 -f {} \;

echo "=== Create table and Run insert in main DB ==="
find . -name "i*.sql" -exec psql postgres://$DB_USERNAME:$DB_PASSWORD@localhost:5432/the_station -f {} \;
