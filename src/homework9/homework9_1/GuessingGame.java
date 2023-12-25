package homework9.homework9_1;

import java.util.Random;

class GuessingGame {
    private static final int MAX_NUMBER = 10;
    private int targetNumber;
    private boolean isGuessed;

    public GuessingGame() {
        Random random = new Random();
        targetNumber = random.nextInt(MAX_NUMBER) + 1;
        isGuessed = false;
    }

    public synchronized boolean makeGuess(int guess, int threadId) {
        if (!isGuessed) {
            if (guess == targetNumber) {
                isGuessed = true;
                System.out.println("Thread " + threadId + ": " + guess + " guessed in");
                return true;
            } else {
                System.out.println("Thread " + threadId + ": " + guess + " not guessed");
                return false;
            }
        } else {
            return true;
        }
    }
}
