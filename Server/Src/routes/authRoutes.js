import express from "express";
import { register, login, recoverPassword, getSecurityQuestions } from "../controllers/authController.js";

const router = express.Router();

router.post("/register", register);
router.post("/login", login);
router.post("/questions", getSecurityQuestions);
router.post("/recover", recoverPassword);

export default router;
