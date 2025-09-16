# Wythoff's Game (Last Biscuit)

A Java implementation of **Wythoff’s Game**, also known as the **Last Biscuit Game**.  
This was my **first-year university coursework** and my introduction to programming in Java.
Basic programming skills are used as this is when I started learning java so no OOP demonstrated here.  

---

## 🎮 Game Rules
- Two barrels start with **6** and **8** biscuits.  
- On their turn, a player can:
  - Take biscuits from **one barrel**,
  - Take the same number of biscuits from **both barrels**, or
  - **Skip a turn** (allowed only once per player).  
- The player who takes the **last biscuit wins**.  

---

## 🛠 Features
- Constants for easier code maintenance.  
- Input validation for integers and legal moves.  
- Turn-based gameplay with clear prompts.  
- Tracks skip usage for each player.   

---

## 📚 What I Learned 
- Basic Java Syntax and program stucture.
- Using constants and string formatting for maintenance.
- Basic error handling and validating errors.
- Implementing a turn-based game loop.

---

## ✨ Future Improvements
- Add a computer player with simple AI.
- Allow variable starting biscuit counts.
- Improve user interface for clarity.
- Use OOP.
- Create exceptions for errors. 

---

## What are the different levels?
- The different levels show the stages of development of the game
- Level 1- Is a basic version of the game where only basic features are implemnted such as:
  - Starting the game with the default number of biscuits in each barrel
  -  Allowing the user to choose between barrel one or two
  -  Calculate the new number of biscuits after each of the players turn
  -  Keep track of the current player
    
- Level 2- Is the same as level 1 however additional validation features have been added by assuming some of the user input is correct for example:
  - Check that integer input is correct and will ask the user to re-enter data that is not an integer.
  - Assume that when the program expects specific strings only those strings are input and will ask the user to re-enter data if incorrect.
  

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/YOUR-USERNAME/REPO-NAME.git
   cd REPO-NAME
