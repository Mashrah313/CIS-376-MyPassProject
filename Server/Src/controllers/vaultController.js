import { db } from "../config/db.js";
import MaskProxy from "../utils/proxyMask.js";
import { ExpirationNotifier } from "../utils/expirationObserver.js";

export const createItem = async (req, res) => {
    try {
        const { type, title, username, password, creditCard, cvv, notes, owner } = req.body;

        // Validate required fields
        if (!title || !owner) {
            return res.status(400).json({ error: 'Title and owner are required' });
        }

        // Store original values - don't mask on storage
        const result = await db.query(
            `INSERT INTO vaultitems (type, title, username, password, creditcard, cvv, notes, owner)
             VALUES ($1,$2,$3,$4,$5,$6,$7,$8)
             RETURNING id, title, username, password, creditcard, cvv, notes, owner`,
            [type, title, username, password, creditCard, cvv, notes, owner]
        );

        ExpirationNotifier.notify(type, creditCard);

        res.json({ success: true, message: "Item added to vault", item: result.rows[0] });

    } catch (err) {
        console.error('CREATE ITEM ERROR:', err);
        res.status(500).json({ error: err.message });
    }
};

export const getItems = async (req, res) => {
    try {
        const { owner } = req.params;
        const result = await db.query("SELECT * FROM vaultitems WHERE owner=$1", [owner]);
        res.json(result.rows);
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

export const deleteItem = async (req, res) => {
    try {
        const { id } = req.params;
        const result = await db.query("DELETE FROM vaultitems WHERE id=$1 RETURNING id", [id]);
        
        if (result.rows.length === 0) {
            return res.status(404).json({ error: "Item not found" });
        }
        
        res.json({ success: true, message: "Item deleted" });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};

export const updateItem = async (req, res) => {
    try {
        const { id } = req.params;
        const { title, username, password, creditCard, cvv, notes } = req.body;

        // Store original values - don't mask on storage
        const result = await db.query(
            `UPDATE vaultitems 
             SET title=$1, username=$2, password=$3, creditcard=$4, cvv=$5, notes=$6 
             WHERE id=$7 
             RETURNING *`,
            [title, username, password, creditCard, cvv, notes, id]
        );

        if (result.rows.length === 0) {
            return res.status(404).json({ error: "Item not found" });
        }

        res.json({ success: true, message: "Item updated", item: result.rows[0] });
    } catch (err) {
        res.status(500).json({ error: err.message });
    }
};
