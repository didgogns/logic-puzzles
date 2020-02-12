# Goal

The goal is to search every possible solutions to puzzle shown in https://www.youtube.com/watch?v=fPWQZ-goz8M

# Approach

There are many, MANY ways to fill 7×12 rectangle with 12 pentomino, 5 tetromino, 2 trimino and a domino. I didn't find any complete list, and my estimate is between 1 billion and 1 quadrillion.

Therefore, it is unlikely to find every combination and check them one by one. It is necesssary to cut branch and restrict search area.

# Existing approach

https://www.jaapsch.net/puzzles/polysolver.htm by Jaap Scherphuis

And many other polynomino puzzle solver

# Plan

Use File system to save and load progressions and distribute work (possibly?)
Use BFS for first 7 pieces
