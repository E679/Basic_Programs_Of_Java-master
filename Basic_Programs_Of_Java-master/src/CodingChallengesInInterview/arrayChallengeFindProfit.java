package CodingChallengesInInterview;
/*
Write Java code for below scenario
Array challenge(arr) take the array of numbers stored in are which will contain integers that represent the amount in dollars that a single stock is worth, and return the maximum profit that could have been made by buying stock on day x and selling stock on day y where yx. For example: if az is [44, 30, 24, 32, 35, 30, 40, 38, 15] then your program should return 16 because at Index 2 the stock was worth $24 and at index 6 the stock was then worth $40, so if you bought the stock at 24 and sold it at 40, you would have made a profit of $16, which is the maximum profit that could have been made with this list of stock prices.

If there is not profit that could have been made with the stock prices, then your program should return -1. For example: arr is [10, 9, 8, 2] then your program should return -1.

Examples

Input: new int[] (10,12,4,5,9)

Output: 5

Input: new int[] (14,20,4,12,5,11)

Output: 8
 */
/*
To solve the problem of finding the maximum profit that could be made by buying and selling stocks from a given array of stock prices, we can use a straightforward approach with a single pass through the array to track the minimum price encountered so far and calculate potential profits based on subsequent prices.
 */

/*
Explanation:
1. arrayChallenge Method:

(i) It takes an array arr representing the stock prices over days.
(ii) Initializes minPrice with the first element of arr and maxProfit with -1 (indicating no profit).
(iii) Iterates through the array starting from the second element.
(iv) For each day's price (currentPrice), calculates the potential profit if bought at minPrice and sold at currentPrice.
(v) Updates maxProfit if the current potential profit is greater.
(vi) Updates minPrice if the current price is lower than the previously recorded minPrice.

2) Main Method:

(i) Contains test cases arr1 and arr2 to demonstrate the arrayChallenge method.
(ii) Prints the maximum profit for each test case.
Example:
For arr1 = {10, 12, 4, 5, 9}, the maximum profit would be $5 (buy at $4 and sell at $9).
For arr2 = {14, 20, 4, 12, 5, 11}, the maximum profit would be $8 (buy at $4 and sell at $12).
This solution efficiently finds the maximum profit with a time complexity of O(n), where n is the number of elements in the array, by iterating through the array only once.
 */
public class arrayChallengeFindProfit {
    public static int arrayChallenge(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1; // Not enough data to make a profit
        }

        int minPrice = arr[0]; // Initialize the minimum price to the first element
        int maxProfit = -1; // Initialize max profit to -1 indicating no profit

        for (int i = 1; i < arr.length; i++) {
            int currentPrice = arr[i];
            int potentialProfit = currentPrice - minPrice;

            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {10, 12, 4, 5, 9};
        int[] arr2 = {14, 20, 4, 12, 5, 11};

        System.out.println("Maximum profit for arr1: " + arrayChallenge(arr1)); // Output: 5
        System.out.println("Maximum profit for arr2: " + arrayChallenge(arr2)); // Output: 8
    }
}
