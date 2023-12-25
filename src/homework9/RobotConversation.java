package homework9;

class RobotConversation {
    private static final Object lock = new Object();
    private static boolean robot1Turn = true;

    public static void main(String[] args) {
        Thread robot1Thread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        if (!robot1Turn) {
                            lock.wait();
                        }

                        System.out.println("Робот 1: Сайн уу?");
                        Thread.sleep(1000); // Simulate some work
                        System.out.println("Робот 1: Таны ажил сайн биз дээ?");
                        Thread.sleep(1000);

                        robot1Turn = false;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread robot2Thread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    try {
                        if (robot1Turn) {
                            lock.wait();
                        }

                        System.out.println("Робот 2: Сайн.");
                        Thread.sleep(1000);
                        System.out.println("Робот 2: Харин таны ажил сайн уу?");
                        Thread.sleep(1000);

                        robot1Turn = true;
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        robot1Thread.start();
        robot2Thread.start();
    }
}
