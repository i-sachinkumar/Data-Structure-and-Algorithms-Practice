package concepts_to_rememb;

public class ThreadDemo implements Runnable{
    static private String threadName;
    static private Thread t;

    ThreadDemo(String tName){
        threadName = tName;
        System.out.println(threadName);
    }
    @Override
    public void run() {
        System.out.println(threadName);
    }

    public void start(){
        if(t == null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class MainClass{
    public static void main(String... a){
        ThreadDemo t1 = new ThreadDemo("1");
        t1.start();
        ThreadDemo t2 = new ThreadDemo("2");
        t2.start();
        System.out.println("class");

        //new MainClass().Bar();
    }
    public void Bar(int x, String... y) {
        System.out.println("bg");
    }

    public void Bar(String... y) {
        System.out.println(y[0]);
    }
}