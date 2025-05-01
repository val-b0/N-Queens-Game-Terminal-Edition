# N-Queens-Game-Terminal-Edition-

This Java project implements a console-based game for solving the classic n-Queens problem, where players attempt to
place n queens on an n×n chessboard without them threatening each other. The solution includes core game logic,
exception handling, JUnit testing, and a console interface.

## Features

1. **N-Queens Game Logic**: Core algorithm to check whether queens can be placed on the board without threatening each
   other.
2. **Interactive Console Game**: A user-friendly text-based interface for players to input moves and attempt to solve
   the puzzle.
3. **Customizable Board Size**: The game allows players to choose the size of the chessboard (n×n).
4. **Error Handling**: Input is validated with relevant feedback for incorrect moves or invalid actions.
5. **JUnit Test Coverage**: The project includes unit tests to ensure the correctness of the implementation.
6. **Performance Optimizations**: Efficient backtracking algorithm implemented for game validation.

## How to Play

1. Run the game from the terminal.
2. Choose the size of the chessboard (n).
3. Use the provided commands to place queens on the board.
4. Aim to place all n queens without violating the rules:
    - No two queens can be in the same row, column, or diagonal.
5. Receive immediate feedback on valid or invalid moves.
6. Solve the puzzle and see your completed board!

NOTE: You can remove the queens only when the game is in INVALID state. If you do so or do any other mistake in general,
the exception is raised. You need to start the game from the start.

## Code Structure

The project is structured into the following components:

- **Game Logic**: Handles the implementation of the n-Queens solution and board validity checks.
- **Console Interface**: Responsible for input/output and managing the game loop.
- **Exception Handling**: Manages safe interaction between game logic and the user.
- **JUnit Tests**: Verifies the correctness of the game logic and ensures edge cases are handled appropriately.

### Classes

| Class Name       | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| `NQueensGame`    | Contains the main game logic and methods for processing user input/actions. |
| `Board`          | Represents the chessboard, manages state, and performs validity checks.     |
| `QueenPlacement` | Helper class for managing queen placement and related rules.                |
| `GameRunner`     | Manages the game's flow and player interactions.                            |

### Testing

The project uses JUnit for testing. Tests include:

- Valid queen placement scenarios.
- Invalid moves and edge cases.
- Stress testing for larger board sizes.

### Technologies Used

- **Language**: Java
- **Testing Framework**: JUnit
- **Version Control**: Git

## How to Run

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate into the project directory:
   ```bash
   cd N-Queens-Game-Terminal-Edition-
   ```
3. Compile the project:
   ```bash
   javac -d bin src/*.java
   ```
4. Run the game:
   ```bash
   java -cp bin NQueensGame
   ```

## Example

Here is an example game session:

```plaintext
Welcome to the n-Queens Game!
Enter the size of the chessboard (n): 4

Here is your starting board:
• • • •
• • • •
• • • •
• • • •

Enter your move (row and column, e.g., "2 3"): 1 1
Queen placed at (1, 1).

Current board:
Q • • •
• • • •
• • • •
• • • •

...
```

## Future Scope

1. Add a graphical user interface (GUI) for a more interactive experience.
2. Implement performance optimizations for very large chessboards.
3. Allow players to save and load game sessions.
4. Include multiplayer features or leaderboards.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.
This Java project implements a console-based game for solving the classic n-Queens problem, where players attempt to place n queens on an n×n chessboard without them threatening each other. The solution includes core game logic, exception handling, JUnit testing, and a console interface.
