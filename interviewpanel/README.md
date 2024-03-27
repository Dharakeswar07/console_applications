# Interview Panel

## Application Overview

- **Type of Application**: B2B (Business-to-Business)
- **Target Users**: Administrators
- **Development Time**: 3 days
- **Tech Stack**: Java

## Features Visible to Admin (Phase 1)

- Login --> Admin,Recipnist,Interviewer
- Add interviewer(s) and create a new interview session
- Add candidate to queue
- Remove candidate from queue
- Mark a candidate that has already been interviewed
- Remove Interviewer
- Terminate all interview sessions
- Log out

## Features

- If there are multiple interviewers, add a new candidate to the interview panel with fewer candidates in the queue

## Assignments of ID

### Classes

#### Candidate class:

- `candidateId`: int or UUID
- `candidateName`: String
- `location`: String
- `appliedPosition`: String
- `skill`: String
- `phoneNo`: String
- `emailId`: String
- `education`: String
- `createdBy`: int

#### Admin class:

- `id`: int or UUID
- `phoneNo`:String
- `name`: String
- `emailId`: String
- `address`:String

#### InterviewPanel class:

- `id`: int or UUID
- `employeeId`:int
- `candidateId`: int
- `status`: String
- `result`: String

#### Employee class:

- `id`: int or UUID
- `name`: String
- `phoneNo`: String
- `emailId`: String
- `location`: String
- `position`: String

#### Creditantials:

- `id`: int or UUID
- `userName`: String
- `password`: String
- `empId`: int

## Screenshot

### Admin Login

![InterviewAdLogin](https://github.com/Dharakeswar07/console_applications/assets/161347017/7ba503a0-b31c-46d7-8afa-d7f554520749)

### Main Menu
![interviewMainmenu](https://github.com/Dharakeswar07/console_applications/assets/161347017/fb462610-a6c0-4008-9055-8551032831f6)

### Employee's Login
![interviewerLogin](https://github.com/Dharakeswar07/console_applications/assets/161347017/bf0b8e5f-da6a-4a9d-9e4a-eb3b4c580cf5)
### Employee Menu
![interviewEmpmenu](https://github.com/Dharakeswar07/console_applications/assets/161347017/7fc2c223-8def-4a63-90a9-091292a4a155)
### Candidate Menu
![interviewCandidateMenu](https://github.com/Dharakeswar07/console_applications/assets/161347017/1997eb9a-6d79-4950-bc47-15303eb61748)
### InterviewPanel Menu
![interviewmenu](https://github.com/Dharakeswar07/console_applications/assets/161347017/dd95cb38-a51d-40c3-8c1f-f3deb37497d5)






