# Wordle Copy

A recreation of the New York Times' *Wordle* in Java. Guess the hidden five-letter word in six tries, with coloured tiles telling you how close each guess was.

## How to play

- 🟩 **Green**: right letter, right spot
- 🟨 **Yellow**: the letter is in the word but in a different spot
- ⬜ **Grey**: the letter isn't in the word

After each round you can play again with a new random word.

## Highlights

- Full graphical game board, plus start, rules, win/lose and play-again screens
- **Handles repeated letters**: a letter-frequency count limits how many times a letter can be marked yellow, based on how often it appears in the answer
- Input validation that rejects guesses that aren't exactly five letters

## Tech

Java · [HSA Console](src/main/hsa_new.jar) graphics library (included)

## Running it

From the repo root:

```bash
javac -cp src/main/hsa_new.jar -d bin src/main/Wordle.java
java  -cp "bin;src/main/hsa_new.jar" culminating.Wordle
```

> On macOS/Linux, use `bin:src/main/hsa_new.jar` instead.

Type each guess into the small **Input** window that appears next to the game board.

## Author

Kaleena Kanagarajan · January 2025
