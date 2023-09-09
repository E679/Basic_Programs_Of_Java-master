package ListOfClass;

import java.util.ArrayList;
import java.util.List;

public class ClassList {

    public ClassList(String str){
        System.out.println(str);
    }
    public static void main(String[] args) {
        List<ClassList> ls=new ArrayList<>();
    ClassList e1=new ClassList("Supreeth");
        ls.add(e1);

        int a=10;
        int b=20;
        int c=30;
        System.out.println(Math.min(a,b));
        System.out.println(Math.max(Math.max(a,b), c));
    }

}
