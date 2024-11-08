package Pattern;

public class trainglePattern {
    public static void staircase(int n) {
        // Loop through each level of the staircase
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print '#'
            for (int k = 1; k <= i; k++) {
                System.out.print("#");
            }
            // Move to the next line
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6; // Sample input
        staircase(n);
    }
    /*
    Output:
     #
    ##
   ###
  ####
 #####
######
     */
}
