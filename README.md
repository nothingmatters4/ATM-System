# 🏦 ATM Management System (Java Swing GUI + MySQL + Email OTP + PAN/Aadhaar Validation)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)  
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)  
![MySQL](https://img.shields.io/badge/Database-MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)  
![Email OTP](https://img.shields.io/badge/Email-OTP-yellow?style=for-the-badge)  
![Validation](https://img.shields.io/badge/Input-Validation-green?style=for-the-badge)  
![Status](https://img.shields.io/badge/Project-Completed-brightgreen?style=for-the-badge)  

An **ATM Management System** built using **Java Swing GUI**, **MySQL Database**, and enhanced with **Email OTP Verification** and **Regex-based PAN/Aadhaar Validation**. This secure and user-friendly application replicates the flow of real-world ATMs, allowing users to register, verify their details, and perform essential banking operations.  

---

## ✨ Features

✅ **Multi-Step Registration Process**  
- 3-step registration form collecting all essential user details.  
- **Email OTP Verification**: Validates user email before account creation.  
- **Regex-Based PAN & Aadhaar Validation**: Ensures inputs are in valid formats (no fake/incorrect IDs).  
- Automatic generation of **Card Number** and **PIN** upon successful registration.  

✅ **Secure Login**  
- Login using **Card Number** and **Password** securely stored in the database.  

✅ **Dashboard / Home Page**  
A clean and interactive homepage offering:  
- 💵 **Withdraw**  
- 💰 **Deposit**  
- ⚡ **Fast Cash** (Quick withdrawals)  
- 🔑 **Change PIN**  
- 👤 **Profile View**  
- 🧾 **Mini Statement**  
- 📊 **Balance Enquiry**  

✅ **Transaction Management**  
- Real-time balance updates.  
- Transactions logged in **MySQL Database**.  

✅ **Modern GUI & Validation**  
- Designed with **Java Swing** for an intuitive user experience.  
- Client-side validation to avoid invalid data entry.  

---

## 📸 Screenshots

| **Registration Page 1**               
|----------------------------------------
| ![Registration Page 1](screenshots/registration1.png) 

| **Registration Page 2**               |
|----------------------------------------|
| ![Registration Page 2](screenshots/registration2.png) 

| **Registration Page 3**               | **Registration Success**                 |
|-----------------------------------------|------------------------------------------|
| ![Registration Page 3](screenshots/registration3.png) | ![Registration Success](screenshots/registration_success.png) |

| **Login Page**                         | **Home Page**                           |
|-----------------------------------------|------------------------------------------|
| ![Login Page](screenshots/login.png)    | ![Home Page](screenshots/home.png)      |

| **Withdraw Page**                      | **Deposit Page**                        |
|-----------------------------------------|------------------------------------------|
| ![Withdraw Page](screenshots/withdraw.png) | ![Deposit Page](screenshots/deposit.png) |

| **Fast Cash Page**                     | **Change PIN Page**                     |
|-----------------------------------------|------------------------------------------|
| ![Fast Cash Page](screenshots/fastcash.png) | ![Change PIN](screenshots/changepin.png) |

| **Profile Page**                        | **Mini Statement Page**                 |
|------------------------------------------|------------------------------------------|
| ![Profile Page](screenshots/profile.png) | ![Mini Statement](screenshots/ministatement.png) |

| **Balance Enquiry Page**               |             
|-----------------------------------------|
| ![Balance Enquiry](screenshots/balance.png) 


---

## 🛠️ Tech Stack

- **Java (JDK 8+)**
- **Swing GUI Framework**
- **MySQL Database** (with JDBC integration)
- **JavaMail API** (for Email OTP verification)
- **Regex Validation** (PAN & Aadhaar number formats)

---

## 📂 Folder Structure

!(screenshots/folder.png) 
