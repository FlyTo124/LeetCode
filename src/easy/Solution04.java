package easy;

// 反转整数
public class Solution04 {

    final static int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};

    static int intSize(int x) {
        for (int i = 0; ; i++)
            if (x <= sizeTable[i])
                return i + 1;
    }

    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }
        int value = Math.abs(x);
        int size = Solution04.intSize(value);
        int result = 0;
        int index = 0;
        while (size != 0) {
            int returnValue = this.getRemainder(size - 1, value);
            result += returnValue*((int) Math.pow(10, index));
            if (result/(int)Math.pow(10,index) != returnValue) return 0;
            value = value % ((int) Math.pow(10, size - 1));
            size--;
            index++;
        }
        return x > 0 ? result : (0 - result);
    }

    private int getRemainder(int index, int num) {
        int divisor = (int) Math.pow(10, index);
        if (num >= divisor) {
            return num / divisor;
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution04 t = new Solution04();
        System.out.println(t.reverse(123));
    }

}
