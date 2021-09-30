# Week 4 (27 - 31/09/2021): Introduction to TotalCross

This week we will make a school management system at the same time we will implement a GUI using TotalCross.

## Summary

The table below summarizes this week:

|Goal|Tasks|Delivery|
|--|--|--|
|Understand TotalCross SDK|Build an interface using the framework|Code|
|Code architecture|Meet requirements with the simplest possible architecture|Code|
|Article creation|Write guide on how to build this application|Article|
|Quality of commits and use of git|All code must be committed and follow good git usage practices|Git files|

## Requirements

We have some __hard__ requirements:

- The system has 3 types of people:
  - Student;
  - Teacher;
  - Manager.
- Each type of person has a unique registration code:
  - Student: 8 numbers, ex: 12345678;
  - Teacher: 9 numbers, ex: 123456789;
  - Manager: 4 numbers and 1 letter, ex: 1234A. 
- Each student can be enrolled in X subjects;
- Each teacher can teach 1 subject;
- Each manager is responsible for X number of students and Y number of teachers;
- Each student can receive assessments for each subject they participate;
- If the subject runs out of a teacher, we will not be able to add new students
- If the teacher or students are left without a manager, we will not be able to add new students or teachers
- Subjects have descriptions and information about people, ex: how many students;
- We need to see a summary of the assessments for each subject, eg average, fashion, highest grade and lowest grade
- In the visual interface we will be able to add, move and delete all people or subjects;
- We will be able to see the summary of each discipline with the grouped information;