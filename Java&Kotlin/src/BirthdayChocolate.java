import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
URL: https://www.hackerrank.com/challenges/the-birthday-bar/problem

Lily has a chocolate bar that she wants to share it with Ron for his birthday. Each of the squares has an integer on it. She decides to share a contiguous segment of the bar selected such that the length of the segment mathches Ron's birth month and the sum of the integers on the squares is equal to his birth day. You must determine how many ways she can divide the chocolate.

Consider the chocolate bar as an array of squares, . She wants to find segments summing to Ron's birth day, with a length equalling his birth month, . In this case, there are two segments meeting her criteria: .

Input Format

The first line contains an integer , the number of squares in the chocolate bar.
The second line contains  space-separated integers , the numbers on the chocolate squares where .
The third line contains two space-separated integers,  and , Ron's birth day and his birth month.

Constraints

, where ()
Output Format

Print an integer denoting the total number of ways that Lily can portion her chocolate bar to share with Ron.

Sample Input 0

5
1 2 1 3 2
3 2
Sample Output 0

2
Explanation 0

Lily wants to give Ron  squares summing to . The following two segments meet the criteria:

image

Sample Input 1

6
1 1 1 1 1 1
3 2
Sample Output 1

0
Explanation 1

Lily only wants to give Ron  consecutive squares of chocolate whose integers sum to . There are no possible pieces satisfying these constraints:

image

Thus, we print  as our answer.

Sample Input 2

1
4
4 1
Sample Output 2

1
Explanation 2

Lily only wants to give Ron  square of chocolate with an integer value of . Because the only square of chocolate in the bar satisfies this constraint, we print  as our answer.

 */

public class BirthdayChocolate {

    static int solve(int length, int[] bar, int day, int month){

        // if the month is larger than the length, then the required length condition cannot be met
        if (month > length) {
            return 0;
        }

        int currentSum = 0;
        // get the sum for the first m elements (the required length)
        for (int i = 0; i < month; i++) {
            currentSum += bar[i];
        }

        int validBreakCount = 0;
        // check if the first m elements is a valid break
        if (currentSum == day) {
            validBreakCount++;
        }

        // check the rest of the chocolate bar
        for (int j = month; j < length; j++) {
            currentSum -= bar[j - month];
            currentSum += bar[j];

            if (currentSum == day) {
                validBreakCount++;
            }
        }

        return validBreakCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int d = in.nextInt();
        int m = in.nextInt();
        int result = solve(n, s, d, m);
        System.out.println(result);
    }
}
