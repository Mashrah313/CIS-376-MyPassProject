import express from "express";
import cors from "cors";
import authRoutes from "./routes/authRoutes.js";
import vaultRoutes from "./routes/vaultRoutes.js";

const app = express();
app.use(cors());
app.use(express.json());

// Auth routes
app.use("/api/auth", authRoutes);

// Vault routes
app.use("/api/vault", vaultRoutes);

app.listen(5000, () => console.log("Server running on port 5000"));
