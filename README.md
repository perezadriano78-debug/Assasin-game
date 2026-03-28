# Assassin Manager

A Java implementation of the Assassin game where players stalk and eliminate
each other until one winner remains.

## Files

| File | Description |
|------|-------------|
| `AssassinMain.java` | Main driver program |
| `AssassinManager.java` | Game logic and kill ring management |
| `AssassinNode.java` | Node structure for linked lists |

## Requirements

- Java JDK 8 or higher
- A text file with one player name per line (e.g. `names.txt`)

## How to Run
```bash
javac AssassinMain.java
java AssassinMain
```

## How to Play

1. Enter the name of your players file when prompted
2. Choose whether to shuffle the player order
3. Each round shows the current kill ring and graveyard
4. Enter the name of the next victim to eliminate them
5. Last player standing wins!

## Example Names File (`names.txt`)
```
Alice
Bob
Carlos
Diana
```

## Example Session
```
Welcome to the Assassin Manager

What name file do you want to use this time? names.txt
Do you want the names shuffled? (y/n)? y

Current kill ring:
  Diana is stalking Carlos
  Carlos is stalking Bob
  Bob is stalking Alice
  Alice is stalking Diana

next victim? Bob

...

Game was won by Diana
Final graveyard is as follows:
    Alice was killed by Diana
    Carlos was killed by Alice
    Bob was killed by Carlos
```

## Author
Adriano Perez
