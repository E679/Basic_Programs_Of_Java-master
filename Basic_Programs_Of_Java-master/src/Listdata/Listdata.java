package Listdata;

public class Listdata {
    int id;
    String name;
    String email;

    public Listdata(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "id= "+id+" name= "+name+" email= "+email+"";
    }
}
