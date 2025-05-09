DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE IF NOT EXISTS products (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    image_url VARCHAR(500),
    thumbnail_url VARCHAR(500),
    active BOOLEAN DEFAULT TRUE,
    stock INTEGER DEFAULT 0
    );
