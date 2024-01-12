package temp;

public class FindAllSubsetsOfString {
    public static void main(String[] args) {
        String str = "Hello";
        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(str.substring(i, j));
            }
        }
    }
/*
Output:

H
He
Hel
Hell
Hello
e
el
ell
ello
l
ll
llo
l
lo
o

*/
}
