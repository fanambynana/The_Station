#!/bin/bash

echo "=== Drop and Create test DB ==="
find . -name "create-db-test.sql" -exec psql postgres://$DB_USERNAME_TEST:$DB_PASSWORD_TEST@localhost:5432 -f {} \;

echo "=== Create table and Run insert in test DB ==="
find . -name "i*.sql" -exec psql postgres://$DB_USERNAME_TEST:$DB_PASSWORD_TEST@localhost:5432/the_station_test -f {} \;