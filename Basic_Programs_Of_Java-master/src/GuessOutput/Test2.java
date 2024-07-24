package GuessOutput;

class Test2 {
    private int data=5;
    public int getData(){
        return this.data;
    }
    public int getData(int value){
        return data+1;
    }
    public int getData(int... value){
        return data+2;
    }

    public static void main(String[] args) {
        Test2 t= new Test2();
        System.out.println(t.getData(7,8,12));//Output : 7
        System.out.println(t.getData());//Output : 5
        System.out.println(t.getData(1));//Output : 6
        System.out.println(t.getData(7,8));//Output : 7
    }
}
