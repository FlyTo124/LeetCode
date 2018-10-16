package easy;

public class Solution04_Other {

    public int reverseInteger(int n) {
        // Write your code here
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }

}

