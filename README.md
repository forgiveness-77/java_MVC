# Pharmacy Management System
A beginner-friendly Java MVC web application for managing medicines in a pharmacy. Built using Servlets, JSP, JDBC, and MySQL, this project helps users add, update, view, and delete medicines while maintaining a simple authentication system.

## Features
✔️ User Registration & Login  
✔️ Add, View, Update, and Delete Medicines  
✔️ Session-Based Authentication  
✔️ Simple UI with JSP & CSS  

## Tech Stack
- **Backend**: Java Servlets, JDBC  
- **Frontend**: JSP, HTML, CSS  
- **Database**: MySQL  
- **Server**: Apache Tomcat  

## Installation & Setup

### Clone the Repository
```bash
git clone https://github.com/your-username/pharmacy-management.git
cd pharmacy-management
```
Set Up the Database

Create a MySQL database:
```bash
CREATE DATABASE pharmacy_db;
```
Create the medicines table:
```bash
CREATE TABLE medicines (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);
```
Update database credentials in DBConnection.java.
Run the Application

Open the project in IntelliJ IDEA / Eclipse / NetBeans.
Ensure Apache Tomcat is installed and configured.
Deploy and start the server.

##Usage
Register/Login as a user.
Add new medicines with details.
View, update, or delete medicines.
Logout after usage.

Future Improvements
🚀 Implement AJAX for real-time updates.
🚀 Role-based access (Admin, Pharmacist).
🚀 REST API for mobile app integration.


### Notes:
- Replace `your-username` in the `git clone` command with your actual GitHub username.
- This README follows standard GitHub Markdown formatting for readability and proper rendering.
- Copy this content into a `README.md` file in your GitHub repository.
