import org.example.data.structure.linkedlist.LinkedList;
import org.example.data.structure.linkedlist.Queue;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello There!");
        LinkedList<Number> list = new LinkedList<Number>();
        LinkedList<Number> list1 = new LinkedList<Number>();

        list = LinkedList.insert(list, 1);
        list = LinkedList.insert(list, 2);
        list = LinkedList.insert(list, 3);
        list = LinkedList.insert(list, 4);
        list1 = LinkedList.insert(list1, 5);
        list1 = LinkedList.insert(list1, 6);
        list1 = LinkedList.insert(list1, 7);
        list1 = LinkedList.insert(list1, 8);

        //LinkedList.printList(list);

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

//        ExecutorService threadPool = Executors.newFixedThreadPool(2);
//        threadPool.submit(() -> {
//
//        });
//
//        Future<?> future = threadPool.submit(() -> {
//
//        });
//        future.cancel(true);
//
//        Thread t1 = new Thread(() -> {
//            while(Thread.currentThread().isInterrupted()) {
//
//            }
//        });
//
//        t1.interrupt();
//
//        threadPool.shutdown();
//        threadPool.shutdownNow();

        Queue.queue();

        //System.out.println(this);

    }
}
