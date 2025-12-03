import pkg from "pg";
const { Pool } = pkg;

export const db = new Pool({
    user: "postgres",
    host: "localhost",
    database: "mypass",
    password: "admin",
    port: 5432
});
