# monty-hall-problem
implementation of classic monty hall problem

This is some old code I made right before going off to college.

## The Monty Hall Problem explained
You are presented with three doors in front of you: only one has $$ behind it, the others has goats. You choose one of the doors (let's say door 1). After picking, the host will reveal one of the other doors (they reveal door 2). Now you are asked if you want to switch doors (switch between door 1 and door 3). Do you say yes or no?

## File structure 
It's a Java program so everything is contained in `/src`; simply put it in your own project directory, compile, and run.  
`Monty.java`: contains all variables and functions for the game
`MontyRunner.java`: runner class that puts functions in gameplay order
`MontySimulate.java`: simulates with a bot player and calculates win rate (set to yes switching)

## How I implemented it (rough explanation)
The program uses two arrays to represent the doors: the front side (what the players see) and the back side (what is actually behind the door). The $$ door is randomly generated. The player then chooses which door. When revealing doors, there are two conditions: 1) player selects $$ door and 2) player doesn't select $$ door. In condition 1, a random door is picked to be unrevealed, while the rest are revealed as goats. In condition 2, the $$ door is unrevealed, while the rest are revealed as goats. The player now chooses whether to switch. If switch, then a variable storing their choice door number is switched to the unrevealed door. At last if their choice matches with the $$ door, they win! Otherwise, they end up with a goat (bahhhhh).

