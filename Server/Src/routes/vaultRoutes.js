import express from "express";
import { createItem, getItems, deleteItem, updateItem } from "../controllers/vaultController.js";

const router = express.Router();

router.post("/create", createItem);
router.get("/:owner", getItems);
router.delete("/:id", deleteItem);
router.put("/:id", updateItem);

export default router;
