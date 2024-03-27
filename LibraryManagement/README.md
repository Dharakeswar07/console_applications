# Library Management System

## Overview

This Library Management System is a B2C (Business-to-Consumer) application developed for admin users. It was developed using Java and completed within a development time of 3 days.

## Features

### Admin

- Admin user login/logout (session maintenance)
- Library setup with basic details
- Add new books to the library
- New Account Creation For Librarians
- Every Customer has their own id and every detail about that customer is stored with their id
- Search and display a list of books to the user
- Assign books to users with return dates
- Return process and overdue handling
- Manage books
- Manage Librarian accounts

### Model Classes

#### Library

- **name:** String
- **id:** String
- **phoneNo:** String
- **emailId:** String
- **address:** String
- **bookCount:** int

#### Admin

- **name:** String
- **id:** int
- **phoneNo:** String
- **emailId:** String
- **address:** String

#### Credentials

- **userId:** int
- **userName:** String
- **password:** String
- **role:** String
- **libraryId:** int

#### Book

- **name:** String
- **author:** String
- **publication:** String
- **id:** int
- **libraryId** int
- **edition:** String
- **availableCount:** int
- **journey:** String
- **volume:** int

#### Customer

- **customerId:** int
- **customerName:** String
- **phoneNo:** String
- **emailId:** String
- **location:** String
- **issueBookCount:** int

## Screenshots
### Admin Login

![MainMenu]
### Main Menu

![MainMenu](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\MainMenu.png)
### Librarian Login

![LibrarianLogin](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\LibrarianLogin.png)
### Library Creation

![LibrarianCreation](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\LibrarianCreation.png)
### Book Management

![BookCreation](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\BookCreation.png)
### Customer Creation:

![CustomerManage](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\CustomerManage.png)
### Issue Book Manage

![IssueBookManage](E:\Java\FirstProject\LibraryManagement\src\com\librarymanagement\ScreenShot\IssueBookManage.png)


