package homework9.homework9_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class GuessingThread extends Thread {
    private static final int MAX_ATTEMPTS = 10;
    private final GuessingGame game;
    private final int threadId;
    private static final int MAX_NUMBER = 10;

    public GuessingThread(GuessingGame game, int threadId) {
        this.game = game;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        List<Integer> guesses = new ArrayList<>();

        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            int guess = new Random().nextInt(MAX_NUMBER) + 1;
            guesses.add(guess);

            if (game.makeGuess(guess, threadId)) {
                System.out.println("guessed, " + (i + 1) + " attempts");
                return;
            } else {
                System.out.print(i == MAX_ATTEMPTS - 1 ? guesses.get(i) + " not guessed and " + (i + 1) + " attempts" : guesses.get(i) + " ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}