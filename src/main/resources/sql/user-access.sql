-- 1. Create the user with a password
CREATE USER site_admin WITH PASSWORD 'Gunitha@2906';

-- 2. Grant connection privileges to the database
GRANT CONNECT ON DATABASE postgres TO site_admin;

-- 2. Create the new schema owned directly by the new user
CREATE SCHEMA site AUTHORIZATION site_admin;

-- 4. Grant all privileges on the public schema
GRANT ALL PRIVILEGES ON SCHEMA public TO site_admin;
GRANT ALL PRIVILEGES ON SCHEMA site TO site_admin;

-- 5. Grant all privileges on existing tables, sequences, and functions
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO site_admin;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO site_admin;
GRANT ALL PRIVILEGES ON ALL FUNCTIONS IN SCHEMA public TO site_admin;

-- 6. Ensure the user automatically gets access to FUTURE tables
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON TABLES TO site_admin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON SEQUENCES TO site_admin;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON FUNCTIONS TO site_admin;
