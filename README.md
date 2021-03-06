# Obliteration Game
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/powered-by-coffee.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

## Introduction
This is a Obliteration game I wrote using Java. For more information about the game, have a look at [here](http://www.papg.com/show?2XMX). 

## Table of Content

- [Where](#where)
- [How to  play](#how-to-play)


## Where
To play the game, simply click on this [link](https://repl.it/@hannz88/ObliterationGameJava). It'll bring you to a repl page. Click on the `Not yet run` button or the play button and follow the prompts.

## How to play
### 1. Set the desired width
At the very beginning, you'll be prompted to enter the desired width of the board. The board here is a square so it will be *n*x*n*. Key in under promt and press enter.

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/Desired_width.png" alt="Desired width of board">
</p>

### 2. Set a character to represent player
Next, you'll be asked to set a SINGLE alpha-numerical character to represent you the player on the board.

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/represent.png" alt="Key in characters to represent players">
</p>

### 3. Announcing the details
Here, you'll be informed of the size of the board you chosen, the character that represents you and the character that represents the computer...along with "Link start-o!" (Anyone gets the reference to SAO?). Then, the state of the board will be printed. In the example below, the board was 10x10, the player's character is "e" and the computer's character is "x". In most IDEs, the player's character should show up as blue and the computer's as yellow. In the repl link, the colour looks a bit weird.

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/Announcing_details.png" alt="Announcing the details of the game">
</p>

### 4. Playing the game
Player will start first. The player will be asked to enter the row followed by the column they intend to dominate. The immediate neighbour surrounding the coordinate will be converted to the player's territory if they are still not dominated. In the example below, the player has chosen row 1, column 1. The choice is echoed, followed by a representation of the board.

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/Entering_coordinates.png" alt="Entering coordinates">
</p>

The computer will then take its turn and print out the board. The computer's territory will be in yellow and denoted by the computer's chosen character.

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/Computer_game.png" alt="The board after the computer make a decision">
</p>

### 5. How is the winner decided?
The aim of the game is to be the last person to dominate the board. So, whoever plays the last turn will be declared the winner. If the computer wins, you should see a version of the following picture printed out. And when the player wins? You get a cookie :laughing:

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/astalavista.jpg" alt="The T1000">
</p>

## Relationship diagram
If you're interested in how the classes are related to each other, here's a diagram that summarised the relationships!

<p align="center">
    <img src="https://github.com/hannz88/Obliteration_Game_Java/blob/main/Images/Obliteration_Game_Java.png" alt="Relationship diagram of the classes">
</p>

Have fun! And if you have any suggestion for improvements, I'm all ears!
