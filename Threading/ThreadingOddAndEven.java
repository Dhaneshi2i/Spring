public class ThreadingOddAndEven {
    boolean odd = true;
    int count = 1;
    int MAX = 10;

    public void printOdd(){
        synchronized (this) {
            while (count < MAX) {
                while (!odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Odd number: " + count);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                odd = false;
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this) {
            while (count < MAX) {
                while (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Even number: " + count);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                count++;
                odd = true;
                notify();
            }
        }
    }

    public static void main(String args[]) {
        ThreadingOddAndEven oddAndEven = new ThreadingOddAndEven();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddAndEven.printEven();
            }
        }) ;
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddAndEven.printOdd();
            }
        });
        t1.start();
        t2.start();
    }
}
