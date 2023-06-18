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
    }

}
