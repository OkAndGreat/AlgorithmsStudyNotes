import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class PCModel {
    private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) {
        PCModel test = new PCModel();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (queue){
                    while(queue.size() == 0){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(queue.poll());
                queue.notify();
            }
        }
    }
}

