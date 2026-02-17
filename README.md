# Attendance-institute-level

🎓 Institute-Level Student Attendance System
Transparent Multi-Level Approval Workflow

📌 Project Overview

This project is a role-based Student Attendance Management System designed for institute-level usage. It enables secure attendance tracking and implements a transparent multi-level leave approval workflow.

The system supports four roles:
  
  ● STUDENT    
  ● FACULTY  
  ● HOD
  
  ● ADMIN

It ensures secure access using JWT-based authentication and maintains approval history for transparency.

🚀 Features

● Role-Based Authentication (JWT)
● Secure Password Encryption (BCrypt)
● Attendance Marking by Faculty
Attendance Percentage Calculation
Leave Application by Student
Multi-Level Leave Approval (Faculty → HOD → Admin)
Approval History Tracking (Audit System)
RESTful API Design
Layered Architecture (Controller, Service, Repository, DTO)

🛠️ Tech Stack

Java 17

Spring Boot

Spring Security

JWT (JSON Web Token)

Spring Data JPA

PostgreSQL

Lombok

Maven

🗄️ Database Design

Main Entities:

User

Student

Faculty

Attendance

LeaveRequest

ApprovalHistory

Relationships:

One-to-One (User ↔ Student / Faculty)

One-to-Many (LeaveRequest ↔ ApprovalHistory)

🔄 Multi-Level Approval Workflow

Student applies leave (Status: PENDING)

Faculty approves (Status: FACULTY_APPROVED)

HOD approves (Status: HOD_APPROVED)

Admin final approval (Status: FINAL_APPROVED)

Each approval action is recorded in ApprovalHistory for transparency.
