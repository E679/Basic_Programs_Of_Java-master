package DesignPatterns;

public class Singleton {
    private static volatile Singleton instance;

    public Singleton(){
    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton=getInstance();
        Singleton singleton1=getInstance();
        System.out.println("singleton==singleton1 :"+(singleton==singleton1));
    }
}
