package temp;


import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Primenumber {
    public static void main(String[] args) {
       int nums= 2;
        List<Integer> numlist= Arrays.asList(2,3,5,8,4,6,13);
        boolean flag=false;
        getPrimenumber(nums, flag);
        //Prime NUmbers from 1 to 100
        getPrimenumberFromList();
    }

    private static void getPrimenumberFromList() {
        List<Integer> result=new ArrayList<>();
        for (int i=1;i<=100;i++){
            int count=0;
            for (int j=1;j<=i;j++){
                if (i%j==0){
                    count++;
                }
            }
            if(count==2){
                result.add(i);
            }else {
                continue;
            }
        }
            System.out.println("Prime numbers from list are: "+result);
    }

    private static void getPrimenumber(int nums, boolean flag) {
        if (nums==0 || nums==1){
            System.out.println(nums+" Is not a Prime number");
        }
        for (int i=2;i<=nums/2;++i){
                if (nums%i==0){
                    flag=true;
                    break;
                }
        }
        if(!flag){
            System.out.println(nums+" Is a Prime number");
        }else {
            System.out.println("Not prime");
        }
    }
}
