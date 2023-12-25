package homework9.homework9_1;

public class Main {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();

        GuessingThread thread1 = new GuessingThread(game, 1);
        GuessingThread thread2 = new GuessingThread(game, 2);
        GuessingThread thread3 = new GuessingThread(game, 3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}