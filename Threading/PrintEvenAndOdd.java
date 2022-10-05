public class PrintEvenAndOdd extends Thread {
    int threadNo;

    public PrintEvenAndOdd(int threadNo) {
        this.threadNo = threadNo;
    }

    int i = 1;

    @Override
    public void run() {
        //synchronized (PrintEvenAndOdd.class) {
            while (i <= 10) {
                if (i % 2 == 0 && threadNo == 1) {
                    System.out.println("Even thread: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else if (i % 2 != 0 && threadNo == 2) {
                    System.out.println("Odd thread: " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                i++;
            }
    }

    public static void main(String[] args){
        PrintEvenAndOdd evenThread = new PrintEvenAndOdd(1);
        PrintEvenAndOdd oddThread = new PrintEvenAndOdd(2);

        oddThread.start();
        evenThread.start();
    }
}
