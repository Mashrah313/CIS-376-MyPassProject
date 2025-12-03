-- Users table
CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    email TEXT UNIQUE NOT NULL,
    master_password TEXT NOT NULL,
    question1 TEXT,
    question2 TEXT,
    question3 TEXT
);

-- Vault items
CREATE TABLE vault_items (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    user_id INTEGER NOT NULL,
    type TEXT NOT NULL,
    title TEXT NOT NULL,
    username TEXT,
    password TEXT,
    url TEXT,
    card_number TEXT,
    cvv TEXT,
    expiry_date TEXT,
    full_name TEXT,
    passport_number TEXT,
    license_number TEXT,
    ssn TEXT,
    note_text TEXT,
    created_at TEXT,
    updated_at TEXT,
    FOREIGN KEY(user_id) REFERENCES users(id)
);
