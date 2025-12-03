// Server/Src/controllers/authController.js

import bcrypt from "bcrypt";
import jwt from "jsonwebtoken";
import { db } from "../config/db.js";

// =============== REGISTER ==================
export const register = async (req, res) => {
  try {
    const { email, password, securityQ1, securityQ2, securityQ3 } = req.body;

    const hashedPassword = await bcrypt.hash(password, 10);

    await db.query(
      `INSERT INTO users (email, password, security_q1, security_q2, security_q3)
       VALUES ($1, $2, $3, $4, $5)`,
      [email, hashedPassword, securityQ1, securityQ2, securityQ3]
    );

    res.json({ success: true, message: "User registered successfully" });
  } catch (err) {
    console.error("REGISTER ERROR:", err);
    res.status(500).json({ error: err.message });
  }
};

// =============== LOGIN ==================
export const login = async (req, res) => {
  try {
    const { email, password } = req.body;

    // 1) Find user
    const result = await db.query(
      "SELECT * FROM users WHERE email = $1",
      [email]
    );

    if (result.rows.length === 0) {
      return res.status(404).json({ error: "Email not found" });
    }

    const user = result.rows[0];

    // 2) Check password
    const match = await bcrypt.compare(password, user.password);
    if (!match) {
      return res.status(401).json({ error: "Invalid password" });
    }

    // 3) Create JWT
    const token = jwt.sign(
      { userId: user.id },
      "SECRET",          // you can move this to config/env later
      { expiresIn: "2h" }
    );

    return res.json({
      success: true,
      message: "Login successful",
      token,
      user: {
        id: user.id,
        email: user.email,
      },
    });
  } catch (err) {
    console.error("LOGIN ERROR:", err);
    return res.status(500).json({ error: err.message });
  }
};

// =============== RECOVER PASSWORD ==================
export const recoverPassword = async (req, res) => {
  try {
    const { email, ans1, ans2, ans3 } = req.body;

    // Find user
    const result = await db.query(
      "SELECT * FROM users WHERE email = $1",
      [email]
    );

    if (result.rows.length === 0) {
      return res.status(404).json({ error: "User not found" });
    }

    const user = result.rows[0];

    // Compare answers directly with stored security questions
    const ok =
      ans1 === user.security_q1 &&
      ans2 === user.security_q2 &&
      ans3 === user.security_q3;

    if (!ok) {
      return res.status(401).json({ error: "Recovery failed" });
    }

    return res.json({
      success: true,
      message: "Verification complete. Reset allowed.",
    });
  } catch (err) {
    console.error("RECOVER ERROR:", err);
    return res.status(500).json({ error: err.message });
  }
};
