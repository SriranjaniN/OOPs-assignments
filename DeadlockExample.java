package assignment3;
class SharedResource {
    public static final Object resource1 = "Resource1";
    public static final Object resource2 = "Resource2";
}

class Thread1 extends Thread {
    public void run() {
        synchronized (SharedResource.resource1) {
            System.out.println("Thread 1: Locked resource 1");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 1: Waiting for resource 2...");
            synchronized (SharedResource.resource2) {
                System.out.println("Thread 1: Locked resource 2");
            }
        }
    }
}

class Thread2 extends Thread {
    public void run() {
        synchronized (SharedResource.resource2) {
            System.out.println("Thread 2: Locked resource 2");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread 2: Waiting for resource 1...");
            synchronized (SharedResource.resource1) {
                System.out.println("Thread 2: Locked resource 1");
            }
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();
    }
}
