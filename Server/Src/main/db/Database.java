package db;

import java.sql.*;

public class Database {
    private static Connection conn;

    // Connect to database
    public static void connect() {
        try {
            // SQLite example: for MySQL, change URL, username, password accordingly
            String url = "jdbc:sqlite:mypass.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Database connected.");

            initializeTables();
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }

    private static void initializeTables() throws SQLException {
        Statement stmt = conn.createStatement();

        // Users table
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                email TEXT UNIQUE NOT NULL,
                master_password TEXT NOT NULL,
                question1 TEXT,
                question2 TEXT,
                question3 TEXT
            );
        """);

        // Vault items table
        stmt.execute("""
            CREATE TABLE IF NOT EXISTS vault_items (
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
        """);

        System.out.println("Tables initialized.");
    }

    // Simple query executor
    public static ResultSet executeQuery(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql);
    }

    public static int executeUpdate(String sql) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(sql);
    }

    public static Connection getConnection() {
        return conn;
    }

    public static void close() {
        try {
            if (conn != null) conn.close();
            System.out.println("Database closed.");
        } catch (SQLException e) {
            System.out.println("Error closing DB: " + e.getMessage());
        }
    }
}
