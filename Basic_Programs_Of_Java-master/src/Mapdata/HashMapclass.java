package Mapdata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapclass {
    public static void main(String[] args) {
        HashMap<Integer,String> mp=new HashMap<Integer,String>();
        mp.put(1,"firstName");
        mp.put(2,"lastName");
        mp.put(3,"email");

        System.out.println("Map Records "+mp.entrySet());

        System.out.println("Iteration through While: ");
        Iterator<Integer> it=mp.keySet().iterator();
       while(it.hasNext()){
           int key=(int)it.next();
           System.out.println("Key "+key+" Name :"+mp.get(key));
        }

        //Works for map iteration
        System.out.println("\nIteration through for loop: ");
        for(Map.Entry<Integer,String> entry: mp.entrySet() ){
            System.out.println("Key: "+entry.getKey()+" name: "+entry.getValue());
        }
        //for getting only keys
        System.out.println("\nOnly Keys: ");
        for(Integer in:mp.keySet()){
            System.out.println("Keys "+in);
        }
        //for getting only values
        System.out.println("\nOnly values: ");
        for(String st:mp.values()){
            System.out.println("Values "+st);
        }



    }
}
