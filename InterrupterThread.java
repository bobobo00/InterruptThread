package Thread;

/**
 * @ClassName InterrupterThread
 * @Description TODO
 * @Auther danni
 * @Date 2019/11/5 11:35]
 * @Version 1.0
 **/

public class InterrupterThread {
   private static class InterrupterMethod1 implements Runnable{
       @Override
       //通过中断异常来中断线程
       public void run() {
           while(true){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   System.out.println("interruptmethod1：通过异常来中断线程");
                   System.out.println(Thread.currentThread().interrupted());
                   break;
               }
               System.out.println("退出");
           }

       }
   }

    private static class InterrupterMethod2 implements Runnable{
        @Override
        //通过中断标识来中断线程：清除中断标识
        public void run() {
            while(!Thread.currentThread().isInterrupted()){

            }
            System.out.println("interruptmethod2：通过中断标识来中断线程，清除中断标识");
            System.out.println(Thread.currentThread().interrupted());
        }
    }

    private static class InterrupterMethod3 implements Runnable {
        @Override
        //通过中断标识来中断线程：不清除中断标识
        public void run() {
            while (!Thread.interrupted()) {
            }
            System.out.println("interruptmethod1：通过异常来中断线程,不清除中断标识");
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }

    public static void main(String[] args) {
        Thread method1=new Thread(new InterrupterMethod1());
        Thread method2=new Thread(new InterrupterMethod2());
        Thread method3=new Thread(new InterrupterMethod3());

        method1.start();
        method2.start();
        method3.start();
        method1.interrupt();
        method2.interrupt();
        method3.interrupt();
    }


}
