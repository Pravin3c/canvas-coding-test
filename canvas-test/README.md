# Canvas Challenge
Unattended Coding Problem: Drawing Program

## The Problem
```
__Description__

Please implement a simple text (ASCII) based drawing program (something similar to a simplified version of Paint). The basic program should allow users to:
1. Create a new canvas
2. Draw on the canvas using text based commands
3. Quit the program


Command 		Description
C w h           Create a new canvas of width w and height h
L x1 y1 x2 y2   Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character
R x1 y1 x2 y2   Draw a new rectangle, with upper left corner at coordinate (x1, y1) and lower right coordinate at (x2, y2). Lines are
				made up of the x character
Q               Quit the program


__Examples__

A sample run of the program is show below. The user input is prefixed with enter command:

enter command: C 20 5
----------------------
|                    |
|                    |
|                    |
|                    |
|					 |
----------------------

enter command: L 1 3 7 3
----------------------
|                    |
|                    |
|xxxxxxx             |
|                    |
|					 |
----------------------

enter command: L 7 1 7 3
----------------------
|      x             |
|      x             |
|xxxxxxx             |
|                    |
|					 |
----------------------

enter command: R 15 2 20 5
----------------------
|      x             |
|      x       xxxxxx|
|xxxxxxx       x    x|
|              x    x|
			   xxxxxx|
----------------------

enter command: Q
```



# My solution

## Prerequisites
This project use maven as build tool.
JDK 17 is required to build and run the tool

## How to build

###run tests
mvn test

###build fat jar
mvn package
jar path - target/canvas-challenge-jar-with-dependencies.jar

## Running tool
unpack zip to any folder, execute the canvas-app.bat file
you can run fat jar directly, use `java -jar `target/canvas-challenge.jar` to run tool

### Logging
All logs are written to canvas.log. By default they are in debug mode. Apache log4j2 is used for logging 
log4j2.xml is located inside jar, to change log level specify standard `-Dlog4j.configurationFile=path/to/log4j2.xml`

## Implementation
* All commands are case-sensitive








