# DP: Memoization & Tabulation Game!

<img src="https://img.shields.io/badge/license-MIT-green.svg" />  <img src="https://img.shields.io/badge/version-1.0-red.svg" /> 

**Optimal Strategy** for a Game using **Dynamic Programming** in two Programming Languages: **Python & C++!**

These strategies can show their time too!

This project has been done by these contributors, be sure to **check them out!**:

- [Kevin David Rosales Santana](https://github.com/kevinrosalesdev)
- [Miguel Ángel Medina Ramírez](https://github.com/miguel-kjh)
- [Héctor Henríquez Cabrera](https://github.com/HectorHc2014)

***

## Problem Statement

Click [here](https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/) to see all Problem Statement.

>Consider a row of n coins of values v1 . . . vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.

>Note: The opponent is as clever as the user.

## Strategies

We used [Tabulation & Memoization Strategies](https://www.geeksforgeeks.org/tabulation-vs-memoization/) to solve this Problem.

**Tabulation Strategy** was included in [Problem Website](https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/).

## Input Files

Input Files use the following structure:

```bash
2 2 1 2				<= Row of Coins (Case 1)
8 15 3 7			<= Row of Coins (Case 2)
2 2 2 2				<= Row of Coins (Case 3)
20 30 2 2 2 10		<= Row of Coins (Case 4)
```

Input files are named as *fichero_X.txt*. 

*X* usually indicates **Row Size**.

## Requirements

All algorithms were tested using these versions:

- **Python 3**
- **C++14 & GCC version 8.1.0**

## Some Size Stats

| Strategy & Language     | Maximum Solved File  | Solution   | Time       |
| ----------------------- | -------------------- | ---------- | ---------- |
| Memoization [Python]    | fichero_10e3.txt     | 24642      | 0.46s      |
| **Memoization [C++]**   | **fichero_10e4.txt** | **250979** | **22.43s** |
| **Tabulation [Python]** | **fichero_10e4.txt** | **250979** | **84.74s** |
| Tabulation [C++]        | fichero_100.txt      | 2538       | 0.001s     |

## How to execute all Algorithms

Be sure to have `g++` and `python` in OS Path!

### Python

Go to /DP-Memoization-Tabulation/Python/ and execute in console:

~~~bash
python DP-PR3.py [-t/-T] input_file_1 [input_file_2][input_file_N]
~~~

### C++ (Compiled with GCC)

Go to /DP-Memoization-Tabulation/C++ and execute in console:

~~~bash
g++ DP-PR3.cpp -o "Executable Name"
"Executable Name" [-t/-T] input_file_1 [input_file_2][input_file_N]
~~~

Don't forget that:

1. *-t* option executes **Memoization** algorithm.
2. *-T* option executes **Tabulation** algorithm.
3. If you don't write any option, **both algorithms** will be executed.

## Outputs

- If you execute it **without any option** (*-t/-T*), Output will be something like:

```
------------------1Fichero------------------ 	<= File Number
Algoritmo por Memoization						<= Algorithm (Memoization)
################ 1 iteración ##############		<= Row Number
Para [1, 96, 55, 86, 61, 86, 76, 35, 56, 85, 26, 39, 86, 64, 96, 8, 33, 36, 77, 22, 21, 80, 19, 16, 70, 26, 51, 70, 49, 100, 92, 22, 11, 52, 81, 0, 55, 57, 89, 20, 10, 16, 38, 35, 90, 35, 17, 48, 36, 66, 25, 67, 24, 25, 74, 27, 14, 87, 29, 3, 54, 46, 62, 35, 39, 49, 92, 8, 4, 11, 90, 25, 3, 100, 9, 66, 4, 44, 14, 66, 20, 56, 52, 71, 28, 60, 82, 66, 13, 66, 68, 86, 27, 76, 62, 42, 30, 99, 25, 57] <= Row
2538											<= Solution

Algoritmo por Tabulation						<= Algorithm (Tabulation)
################ 1 iteración ##############		<= Row Number
Para [1, 96, 55, 86, 61, 86, 76, 35, 56, 85, 26, 39, 86, 64, 96, 8, 33, 36, 77, 22, 21, 80, 19, 16, 70, 26, 51, 70, 49, 100, 92, 22, 11, 52, 81, 0, 55, 57, 89, 20, 10, 16, 38, 35, 90, 35, 17, 48, 36, 66, 25, 67, 24, 25, 74, 27, 14, 87, 29, 3, 54, 46, 62, 35, 39, 49, 92, 8, 4, 11, 90, 25, 3, 100, 9, 66, 4, 44, 14, 66, 20, 56, 52, 71, 28, 60, 82, 66, 13, 66, 68, 86, 27, 76, 62, 42, 30, 99, 25, 57] <= Row
2538											<= Solution
------------------2Fichero------------------	<= File Number
[Etc.]
```

- If you execute it using *-t* option (**Memoization**), Output will be something like:

```bash
------------------1Fichero------------------	<= File Number
################ 1 iteración ##############		<= Row Number
2538											<= Solution
tiempo: 0.003996849060058594					<= Time (s)
```

A file named *tiempos_Memoization.txt* will be generated and **will show that time**:

```bash
##### TIEMPOS fichero_100.txt ####				<= File Name
100--0.003996849060058594						<= Size & Time (s)
```

- If you execute it using *-T* option (**Tabulation**), Output will be something like:

```bash
------------------1Fichero------------------	<= File Number
################ 1 iteración ##############		<= Row Number
2538											<= Solution
tiempo: 0.005932807922363281					<= Time (s)
```

A file named *tiempos_Tabulation.txt* will be generated and **will show that time**:

```bash
##### TIEMPOS fichero_100.txt ####				<= File Name
100--0.005932807922363281						<= Size & Time (s)
```

