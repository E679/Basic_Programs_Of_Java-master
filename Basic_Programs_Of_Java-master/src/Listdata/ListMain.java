package Listdata;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListMain {
    public static void main(String[] args) {
        List<Listdata> ld=new LinkedList<Listdata>();
        Listdata s1=new Listdata(1,"Supreeth","sai@gmail.com");
        Listdata s2=new Listdata(2,"Vijay","vijay@gmail.com");
        Listdata s3=new Listdata(3,"Ajay","ajay@gmail.com");
        ld.add(s1);
        ld.add(s2);
        ld.add(s3);
        ld.add(new Listdata(4,"Vicky","vicky@gmail.com"));
        System.out.println("Number of Elements in list: "+ld.size());

        System.out.println("'Before for each loop'"+ld);
        System.out.println("'After for each loop'");
        for(Listdata m: ld){
            System.out.println(m);
        }
        System.out.println("'Iterating through loop with Index'");
        ListIterator<Listdata> listIterator=ld.listIterator();
        while (listIterator.hasNext()){
            System.out.println(" \nIndex "+listIterator.nextIndex()+" "+listIterator.next());
        }
        System.out.println("\n'Iterating through loop with Index in reverse'");
        while (listIterator.hasPrevious()){
            System.out.println(" \nIndex "+listIterator.previousIndex()+" "+listIterator.previous());
        }


    }
}
