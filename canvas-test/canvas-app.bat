cd

ECHO This is the Canvas Coding Challenge
CALL mvn clean install
pause

java -jar target/canvas-challenge-jar-with-dependencies.jar

pause