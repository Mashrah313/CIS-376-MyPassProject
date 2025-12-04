# 🔐 MyPass - Password Manager Application

A secure, modern password manager built with React, Node.js/Express, and PostgreSQL. MyPass allows users to securely store, manage, and retrieve their passwords and sensitive information with beautiful UI/UX and advanced security features.

**Course**: CIS 476 - Software Design Patterns  
**Term Project**: MyPass Password Manager

---

## 📋 Table of Contents

1. [Project Structure](#project-structure)
2. [Features](#features)
3. [Technologies](#technologies)
4. [Prerequisites](#prerequisites)
5. [Installation](#installation)
6. [Setup](#setup)
7. [Running the Application](#running-the-application)
8. [API Endpoints](#api-endpoints)
9. [Design Patterns Implemented](#design-patterns-implemented)
10. [Usage Guide](#usage-guide)
11. [Project Artifacts](#project-artifacts)

---

## 📁 Project Structure

```
MyPassProject/
├── Server/                          # Node.js/Express Backend
│   ├── Src/
│   │   ├── index.js                 # Express app initialization
│   │   ├── initDb.js                # Database initialization script
│   │   ├── config/
│   │   │   └── db.js                # PostgreSQL connection configuration
│   │   ├── controllers/
│   │   │   ├── authController.js    # Authentication logic (register, login, password recovery)
│   │   │   └── vaultController.js   # Vault CRUD operations
│   │   ├── routes/
│   │   │   ├── authRoutes.js        # Authentication endpoints
│   │   │   └── vaultRoutes.js       # Vault management endpoints
│   │   ├── utils/
│   │   │   ├── proxyMask.js         # Proxy pattern for data masking
│   │   │   ├── passwordBuilder.js   # Builder pattern for password generation
│   │   │   ├── sessionManager.js    # Singleton pattern for session management
│   │   │   ├── recoveryChain.js     # Chain of Responsibility pattern
│   │   │   └── expirationObserver.js # Observer pattern for credit card notifications
│   │   └── main/                    # Java implementation (reference)
│   │       ├── MyPassApp.java       # Main application
│   │       ├── builder/             # Builder pattern implementation
│   │       ├── cor/                 # Chain of Responsibility pattern
│   │       ├── db/                  # Database management
│   │       ├── mediator/            # Mediator pattern (UI component orchestration)
│   │       ├── model/               # Data models
│   │       ├── observer/            # Observer pattern (notifications)
│   │       ├── proxy/               # Proxy pattern (sensitive data protection)
│   │       └── singleton/           # Singleton pattern (session management)
│   ├── package.json                 # Node dependencies
│   └── .env                         # Environment variables
│
├── client/                          # React Frontend
│   ├── public/
│   ├── src/
│   │   ├── index.js                 # React entry point
│   │   ├── App.js                   # Main app component with routing
│   │   ├── pages/
│   │   │   ├── LoginPage.js         # Authentication UI (login/register)
│   │   │   ├── VaultPage.js         # Main vault interface
│   │   │   └── RecoveryPage.js      # Password recovery flow
│   │   ├── components/
│   │   │   └── PasswordGenerator.js # Password generation utility
│   │   └── styles/
│   │       ├── App.css              # Global styles
│   │       ├── LoginPage.css        # Login/Register page styles
│   │       ├── VaultPage.css        # Vault page styles
│   │       ├── RecoveryPage.css     # Recovery page styles
│   │       └── PasswordGenerator.css # Password generator styles
│   └── package.json                 # React dependencies
│
└── README.md                        # This file
```

---

## ✨ Features

### Authentication & Security
- ✅ **User Registration** - Create account with email, password, and 3 security questions
- ✅ **Secure Login** - JWT token-based authentication (2-hour expiration)
- ✅ **Password Hashing** - bcrypt with salt for secure password storage
- ✅ **Password Recovery** - Multi-step security question verification process
- ✅ **Session Management** - Secure token-based sessions

### Vault Management
- ✅ **Add Items** - Store logins, credit cards, identity info, and secure notes
- ✅ **View Details** - Display stored items with proper formatting
- ✅ **Edit Items** - Update item information (Backend: PUT endpoint available)
- ✅ **Delete Items** - Remove items with confirmation dialog
- ✅ **Filter by Category** - Organize items by type (Logins, Credit Cards, Identity, Notes)

### Password Security
- ✅ **Password Masking** - Passwords displayed as `••••••••` by default
- ✅ **Show/Hide Toggle** - 👁️ Show / 🙈 Hide buttons to reveal/mask passwords
- ✅ **Password Generator** - Create secure random passwords with customizable options
  - Adjustable length (4-32 characters)
  - Character type selection (uppercase, lowercase, numbers, symbols)
  - Copy to clipboard functionality

### User Experience
- ✅ **Copy to Clipboard** - One-click copying of sensitive data
- ✅ **Beautiful UI** - Purple gradient design with smooth animations
- ✅ **Responsive Design** - Works on desktop browsers
- ✅ **Modal Interface** - Clean, intuitive modal dialogs for actions
- ✅ **Real-time Updates** - Vault refreshes immediately after changes

---

## 🛠 Technologies

### Backend
- **Runtime**: Node.js (v16+)
- **Framework**: Express.js (v4.18+)
- **Authentication**: JWT (jsonwebtoken)
- **Password Hashing**: bcrypt
- **CORS**: Enabled for cross-origin requests
- **Database Client**: pg (PostgreSQL)

### Frontend
- **Library**: React (v19)
- **Styling**: Custom CSS with gradient design
- **HTTP Client**: Fetch API
- **State Management**: React Hooks (useState, useEffect)
- **Storage**: localStorage for JWT tokens and user email

### Database
- **System**: PostgreSQL (v12+)
- **Connection**: Pool-based connections
- **Tables**: 
  - `users` - User accounts and security questions
  - `vaultitems` - Encrypted vault items

### Design Patterns (Java Reference Implementation)
- **Singleton**: SessionManager (single session instance)
- **Builder**: PasswordBuilder (flexible password creation)
- **Observer**: NotificationCenter (credit card expiration notifications)
- **Mediator**: UIMediator (coordinate UI components)
- **Proxy**: SensitiveDataProxy (mask/unmask sensitive data)
- **Chain of Responsibility**: Question handlers (password recovery verification)

---

## 📋 Prerequisites

### Required Software
1. **Node.js** (v16 or higher)
   - Download from: https://nodejs.org/
   - Verify: `node --version`

2. **PostgreSQL** (v12 or higher)
   - Download from: https://www.postgresql.org/download/
   - Verify: `postgres --version`

3. **Git** (optional, for version control)
   - Download from: https://git-scm.com/

### System Requirements
- Windows/Mac/Linux
- At least 2GB RAM
- 500MB free disk space
- Port 5000 (Backend) and 3000 (Frontend) available

---

## 🔧 Installation

### Step 1: Clone or Extract Project
```bash
# If using git
git clone <repository-url>
cd MyPassProject

# Or manually extract the project folder
cd C:\Users\<YourUsername>\OneDrive\Desktop\MyPassProject
```

### Step 2: Install Backend Dependencies
```bash
cd Server
npm install
```

This installs:
- express
- cors
- bcrypt
- jsonwebtoken
- pg

### Step 3: Install Frontend Dependencies
```bash
cd ../client
npm install
```

This installs React 19 and its dependencies.

### Step 4: Set Up Environment Variables

**Backend** - Create `Server/.env` file:
```
DB_USER=postgres
DB_PASSWORD=admin
DB_HOST=localhost
DB_PORT=5432
DB_NAME=mypass
JWT_SECRET=your-secret-key-here
PORT=5000
```

**Note**: Adjust `DB_PASSWORD` if your PostgreSQL password is different.

---

## 🚀 Setup

### Step 1: Start PostgreSQL
```bash
# Windows - PostgreSQL should start automatically as a service
# Verify it's running: Check Services or use:
psql -U postgres -d postgres -c "SELECT version();"

# Mac
brew services start postgresql

# Linux
sudo systemctl start postgresql
```

### Step 2: Initialize Database
```bash
cd Server
node Src/initDb.js
```

You should see:
```
Initializing database...
✓ Users table created/verified
✓ Vault items table created/verified
✓ Database initialization complete!
```

### Step 3: Verify Database Connection
```bash
psql -U postgres -h localhost -c "SELECT * FROM pg_database WHERE datname='mypass';"
```

You should see the `mypass` database listed.

---

## 🎮 Running the Application

### Option 1: Run Both Servers in Separate Terminals

**Terminal 1 - Backend:**
```bash
cd C:\Users\<YourUsername>\OneDrive\Desktop\MyPassProject\Server
npm start
```
Expected output:
```
> mypass-server@1.0.0 start
> node Src/index.js

Server running on port 5000
```

**Terminal 2 - Frontend:**
```bash
cd C:\Users\<YourUsername>\OneDrive\Desktop\MyPassProject\client
npm start
```
Expected output:
```
Compiled successfully!

You can now view client in the browser.

  Local:            http://localhost:3000
```

### Option 2: Quick Start Script (PowerShell)
```powershell
# Run from project root
cd C:\Users\<YourUsername>\OneDrive\Desktop\MyPassProject

# Start backend (background)
Start-Process powershell -ArgumentList "cd Server; npm start"
Start-Sleep -Seconds 3

# Start frontend (background)
Start-Process powershell -ArgumentList "cd client; npm start"
```

### Step 3: Access the Application
Open your browser and navigate to:
```
http://localhost:3000
```

---

## 📡 API Endpoints

### Base URL
```
http://localhost:5000/api
```

### Authentication Endpoints

#### Register User
```
POST /api/auth/register
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePass123!",
  "securityQ1": "Your answer 1",
  "securityQ2": "Your answer 2",
  "securityQ3": "Your answer 3"
}

Response: 200 OK
{
  "success": true,
  "message": "User registered successfully"
}
```

#### Login
```
POST /api/auth/login
Content-Type: application/json

{
  "email": "user@example.com",
  "password": "SecurePass123!"
}

Response: 200 OK
{
  "success": true,
  "message": "Login successful",
  "token": "eyJhbGciOiJIUzI1NiIs...",
  "user": {
    "id": 1,
    "email": "user@example.com"
  }
}
```

#### Recover Password
```
POST /api/auth/recover
Content-Type: application/json

{
  "email": "user@example.com",
  "ans1": "Answer to security question 1",
  "ans2": "Answer to security question 2",
  "ans3": "Answer to security question 3"
}

Response: 200 OK
{
  "success": true,
  "message": "Verification complete. Reset allowed."
}
```

### Vault Endpoints

#### Create Vault Item
```
POST /api/vault/create
Content-Type: application/json
Authorization: Bearer <token>

{
  "type": "Login",
  "title": "Gmail",
  "username": "user@gmail.com",
  "password": "secure_password",
  "creditCard": "",
  "cvv": "",
  "notes": "Personal email account",
  "owner": "user@example.com"
}

Response: 200 OK
{
  "success": true,
  "message": "Item added to vault",
  "item": { ... }
}
```

#### Get Vault Items
```
GET /api/vault/:owner
Authorization: Bearer <token>

Response: 200 OK
[
  {
    "id": 1,
    "type": "Login",
    "title": "Gmail",
    "username": "user@gmail.com",
    "password": "secure_password",
    "creditcard": null,
    "cvv": null,
    "notes": "Personal email account",
    "owner": "user@example.com"
  },
  ...
]
```

#### Delete Vault Item
```
DELETE /api/vault/:id
Authorization: Bearer <token>

Response: 200 OK
{
  "success": true,
  "message": "Item deleted"
}
```

#### Update Vault Item
```
PUT /api/vault/:id
Content-Type: application/json
Authorization: Bearer <token>

{
  "title": "Gmail Updated",
  "username": "newemail@gmail.com",
  "password": "new_password",
  "creditCard": "",
  "cvv": "",
  "notes": "Updated notes"
}

Response: 200 OK
{
  "success": true,
  "message": "Item updated",
  "item": { ... }
}
```

---

## 🏗️ Design Patterns Implemented

### 1. **Singleton Pattern** - Session Management
**Location**: `Server/Src/utils/sessionManager.js` & `Server/Src/main/singleton/SessionManager.java`

- Ensures only one session manager instance exists application-wide
- Manages user sessions and JWT tokens
- Prevents multiple concurrent sessions for the same user

```javascript
// Usage
const session = SessionManager.getInstance();
session.createSession(userId, token);
```

### 2. **Builder Pattern** - Password Generation
**Location**: `Server/Src/utils/passwordBuilder.js` & `Server/Src/main/builder/PasswordBuilder.java`

- Constructs complex password objects with various configurations
- Allows flexible password creation with customizable options
- Supports character type selection and length configuration

```javascript
// Frontend usage
const password = new PasswordBuilder()
  .setLength(16)
  .useUppercase(true)
  .useLowercase(true)
  .useNumbers(true)
  .useSymbols(true)
  .build();
```

### 3. **Observer Pattern** - Notifications
**Location**: `Server/Src/utils/expirationObserver.js` & `Server/Src/main/observer/`

- Notifies users of credit card expiration
- Implements Subject-Observer relationship
- UserNotificationObserver listens for expiration events

```javascript
// Backend usage
ExpirationNotifier.notify(type, creditCard);
// Triggers notification if credit card is expiring soon
```

### 4. **Mediator Pattern** - UI Component Coordination
**Location**: `Server/Src/main/mediator/UIMediator.java`

- Coordinates communication between UI components
- LoginScreen, VaultScreen, PasswordGeneratorScreen communicate through mediator
- Reduces coupling between components

Components coordinated:
- LoginScreen → Authentication
- VaultScreen → Vault management
- PasswordGeneratorScreen → Password generation

### 5. **Proxy Pattern** - Data Masking
**Location**: `Server/Src/utils/proxyMask.js` & `Server/Src/main/proxy/`

- Controls access to sensitive data
- Provides masking/unmasking functionality
- Frontend displays masked passwords; backend stores actual values

```javascript
// Usage
const maskedPassword = MaskProxy.displayMask('actual_password');
// Returns: '••••••••'
```

**Key Implementation Detail**: 
- Backend stores actual passwords (not masked) in database
- Frontend handles display masking for security UI
- Show/Hide toggle controls visibility on client-side

### 6. **Chain of Responsibility Pattern** - Password Recovery
**Location**: `Server/Src/utils/recoveryChain.js` & `Server/Src/main/cor/`

- Verifies security questions in sequence
- Each handler checks one security question
- Passes request through chain: Q1Handler → Q2Handler → Q3Handler → ResetHandler

Chain flow:
```
Question1Handler
    ↓
Question2Handler
    ↓
Question3Handler
    ↓
RecoveryHandler (resets password)
```

---

## 👤 Usage Guide

### First-Time Setup
1. Open http://localhost:3000
2. Click **"Sign Up"** (if not already showing signup form)
3. Enter email, password, and answer the 3 security questions
4. Click **Register**

### Add Your First Item
1. Click **"Login"** with your credentials
2. Click **"+ Add New"** button in sidebar
3. Fill in the fields:
   - **Title**: Name of the item (e.g., "Gmail", "Bank Account")
   - **Username/Email**: The username or email for the account
   - **Password**: Enter manually or click 🔐 to generate
4. Click **Save Item**

### Using Password Generator
1. Click **🔐 Generate Password** in sidebar
2. Adjust the slider for password length (4-32 characters)
3. Check/uncheck character types you want to include
4. Click **Generate Password**
5. Click **✓ Use This Password** to auto-fill in form, or **📋 Copy** to copy to clipboard

### View Item Details
1. Click **View Details** on any vault item
2. Password and CVV are masked by default
3. Click **👁️ Show** to reveal password/CVV
4. Click **🙈 Hide** to mask again
5. Click **📋** next to any field to copy to clipboard
6. Click **Delete** to remove the item (with confirmation)

### Organize Items
- Use sidebar buttons to filter by category:
  - 🔑 **Logins** - Email/password combinations
  - 💳 **Credit Cards** - Payment card information
  - 👤 **Identity** - Personal identification
  - 📝 **Notes** - Secure notes

### Logout
1. Click **Logout** button in top-right corner
2. You'll be returned to the login screen

---

## 🔒 Security Features

- **Password Hashing**: bcrypt with 10 salt rounds
- **JWT Tokens**: 2-hour expiration for session security
- **HTTPS-Ready**: Can be deployed with SSL/TLS
- **CORS Protection**: Only accepts requests from configured origins
- **SQL Injection Prevention**: Parameterized queries via pg library
- **Secure Password Display**: Frontend masking, never logged to console

---

## 🐛 Troubleshooting

### Backend won't start
```bash
# Check if port 5000 is in use
netstat -ano | findstr :5000

# Kill process using port 5000
taskkill /PID <PID> /F

# Restart backend
npm start
```

### PostgreSQL connection error
```bash
# Verify PostgreSQL is running
pg_isready -h localhost -p 5432

# Check database exists
psql -U postgres -l | grep mypass

# Reinitialize database
node Src/initDb.js
```

### React app not updating
```bash
# Clear node_modules and reinstall
cd client
rm -r node_modules package-lock.json
npm install
npm start
```

### Items not saving
1. Check browser console (F12) for error messages
2. Check backend console for API errors
3. Verify token is in localStorage: `localStorage.getItem('token')`
4. Verify all required fields (title, owner) are filled

---

## 📝 Database Schema

### Users Table
```sql
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  email TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL,
  security_q1 TEXT,
  security_q2 TEXT,
  security_q3 TEXT,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)
```

### Vault Items Table
```sql
CREATE TABLE vaultitems (
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
```

---

## 📚 Project Statistics

- **Backend Files**: ~5 main controllers/utilities
- **Frontend Files**: ~4 pages + 1 component + 5 CSS files
- **Design Patterns**: 6 different patterns implemented
- **API Endpoints**: 7 total (4 auth + 4 vault)
- **Database Tables**: 2
- **Total Lines of Code**: ~2000+

---

## 👨‍💻 Author

**Student**: CIS 476 - Software Design Patterns  
**Project**: MyPass Password Manager  
**Date**: December 2025

---

## 📄 License

This project is created for educational purposes as part of CIS 476 coursework.

---

## 🤝 Support

For issues or questions:
1. Check the **Troubleshooting** section
2. Review API endpoint documentation
3. Check browser console (F12) and backend console for errors
4. Verify all prerequisites are installed correctly

---

**Last Updated**: December 2, 2025  
**Version**: 1.0.0

---

## 📎 Project Artifacts

- [University of Michigan Dearborn.pdf](./University%20of%20Michigan%20Dearborn.pdf)
- [MyPassProject Secure Password & Vault Manager Presented by_ Nagi Mashrah.pdf](./MyPassProject%20Secure%20Password%20%26%20Vault%20Manager%20Presented%20by_%20Nagi%20Mashrah.pdf)
- Demo video: https://www.youtube.com/watch?v=oc0k5aC3vDg

These PDFs are stored in the repository root and the video link provides a quick overview/demo of the project.
