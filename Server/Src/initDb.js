import { db } from "./config/db.js";

const initializeDatabase = async () => {
  try {
    console.log("Initializing database...");

    // Create users table
    await db.query(`
      CREATE TABLE IF NOT EXISTS users (
        id SERIAL PRIMARY KEY,
        email TEXT UNIQUE NOT NULL,
        password TEXT NOT NULL,
        security_q1 TEXT,
        security_q2 TEXT,
        security_q3 TEXT,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      )
    `);
    console.log("✓ Users table created/verified");

    // Create vaultitems table
    await db.query(`
      CREATE TABLE IF NOT EXISTS vaultitems (
        id SERIAL PRIMARY KEY,
        type TEXT NOT NULL,
        title TEXT NOT NULL,
        username TEXT,
        password TEXT,
        creditcard TEXT,
        cvv TEXT,
        notes TEXT,
        owner TEXT NOT NULL,
        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
      )
    `);
    console.log("✓ Vault items table created/verified");

    console.log("✓ Database initialization complete!");
    process.exit(0);
  } catch (err) {
    console.error("✗ Database initialization failed:", err.message);
    process.exit(1);
  }
};

initializeDatabase();
