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

![AdminLogin (2)](https://github.com/Dharakeswar07/console_applications/assets/161347017/9e3ec5ed-4296-4093-b7c1-d9a171b58dee)

### Main Menu
![MainMenu](https://github.com/Dharakeswar07/console_applications/assets/161347017/4d63451e-e336-4da3-9358-bf0c177948d1)

### Librarian Login
![LibrarianLogin](https://github.com/Dharakeswar07/console_applications/assets/161347017/39818b9f-8a53-4141-b0c0-f8bf45ef66fc)

### Library Creation
![LibrarianCreation](https://github.com/Dharakeswar07/console_applications/assets/161347017/2aa52a79-7709-45b1-91bf-6bf51cbf0a1a)

### Book Management

![BookCreation](https://github.com/Dharakeswar07/console_applications/assets/161347017/fe34d70c-6dfd-441a-9ca4-a6a2c2cbcf01)
### Customer Creation:

![CustomerManage](https://github.com/Dharakeswar07/console_applications/assets/161347017/09f127c0-c9b4-4147-bd70-0e65671a59b6)

### Issue Book Manage

![IssueBookManage](https://github.com/Dharakeswar07/console_applications/assets/161347017/cb895f75-fdf5-44f4-b478-e1ed0cbedf0e)








