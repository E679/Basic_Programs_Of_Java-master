package LambdaExp;

interface sumTwoNumbers{
    int sum(int a, int b);
}

public class AddTwoNumbers {
    public static void main(String[] args) {

        //General method
        sumTwoNumbers aww = new sumTwoNumbers() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        int resultold=aww.sum(8,8);
        System.out.println("resultold: "+resultold);


        //Using Lambda
        sumTwoNumbers add = (a, b) -> (a + b);
        int result=add.sum(8,8);
        System.out.println("result: "+result);
    }
}
