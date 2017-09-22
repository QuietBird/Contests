package hobbit;

import java.util.*;

/**
 * TODO : JavaDoc
 *
 * @author Irina Sokolova
 */
public class RuleOfRings {

    private static final Comparator<GameState> COMPARATOR = new Comparator<GameState>() {
            @Override
        public int compare(GameState o1, GameState o2) {
            return o1.command.length() == o2.command.length() ? Integer.compare(o1.moves, o2.moves) : Integer.compare(o1.command.length(), o2.command.length());
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] magicPhrase = in.nextLine().toCharArray();
        char[] initialStones = new char[LENGTH];
        Arrays.fill(initialStones, ' ');
        GameState initialGameState = new GameState("", 0, initialStones, 0);
        List<GameState> states = new ArrayList<>();
        states.add(initialGameState);
        for (char c : magicPhrase) {
            PriorityQueue<GameState> nextStates = new PriorityQueue<>(states.size() * LENGTH, COMPARATOR);
            for (GameState state : states) {
                StringBuilder newCommand = new StringBuilder(state.command);
                if (state.getCharAtCurrentPosition() == c) {
                    GameState newGameState = new GameState(state);
                    nextStates.add(newGameState);
                    continue;
                }
                for (int j = 0; j < LENGTH; j++) {
                    StringBuilder addTo = new StringBuilder();
                    int newMoves = state.moves;
                    int curPos = state.currentPosition;
                    if (j != curPos) {
                        int rightSteps = j > curPos ? j - curPos : (LENGTH - curPos) + j;
                        int leftSteps = curPos > j ? curPos - j : LENGTH - j + curPos;
                        if (rightSteps < leftSteps) {
                            addInstruction(addTo, rightSteps, '>');
                            newMoves += rightSteps;
                        } else {
                            addInstruction(addTo, leftSteps, '<');
                            newMoves += leftSteps;
                        }
                    }
                    if (newMoves > 4000)
                        continue;
                    char[] newStones = Arrays.copyOf(state.stones, LENGTH);
                    char oldStone = newStones[j];
                    if (c != oldStone) {
                        newStones[j] = c;
                        int increment = c == ' ' ? 'Z' - oldStone + 1 : oldStone == ' ' ? c - 'A' + 1 : c > oldStone ? c - oldStone : (27 - oldStone) + c;
                        int decrement = c == ' ' ? oldStone - 'A' + 1 : oldStone == ' ' ? 'Z' - c + 1 : oldStone > c ? oldStone - c : 27 - (c - 'A') + (oldStone - 'A');
                        if (increment < decrement) {
                            addInstruction(addTo, increment, '+');
                        } else {
                            addInstruction(addTo, decrement, '-');
                        }
                    }
                    addTo.append('.');
                    GameState newGameState = new GameState(newCommand.toString() + addTo.toString(), j, newStones, newMoves);
                    nextStates.add(newGameState);

                }
            }
            states.clear();
            for (int j = 0; j < LENGTH; j++) {
                states.add(nextStates.poll());
            }
        }
        System.out.println(states.get(0).command);

    }

    private static void addInstruction(StringBuilder addTo, int steps, char c) {
        for (int k = 0; k < steps; k++)
            addTo.append(c);
    }


    private static final int LENGTH = 30;

    private static class GameState {
        private final String command;
        private final char[] stones = new char[LENGTH];
        private final int currentPosition;
        private final int moves;

        public GameState(String command, int currentPosition, char[] stones, int moves) {
            this.command = command;
            this.currentPosition = currentPosition;
            System.arraycopy(stones, 0, this.stones, 0, LENGTH);
            this.moves = moves;
        }

        public GameState(GameState copy) {
            this.command = copy.command + '.';
            this.currentPosition = copy.currentPosition;
            System.arraycopy(copy.stones, 0, stones, 0, LENGTH);
            this.moves = copy.moves;
        }

        public char getCharAtCurrentPosition() {
            return stones[currentPosition];
        }
    }
}
