package concepts_to_rememb;

class A{

    A(){
        System.out.print("A");
    }
}

class Rock extends A{
    Rock(String t){
        System.out.print(t);
    }
}

public class Main extends Rock{
    Main(){
        super("g");
        new Rock("g");
    }

    public static void main(String[] args) throws Exception{
        enum  s {RED,BLUE,GREEN};
        System.out.println(s.RED);
    }
}