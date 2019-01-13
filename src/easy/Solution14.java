package easy;

public class Solution14 {

    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for (int dig : digits){
            if (dig != 9){
                flag =  false;
                break;
            }
        }
        if (flag){
            int[] result = new int[digits.length +1];
            result[0] = 1;
            for (int i = 1; i<result.length; i++){
                result[i] = 0;
            }
            return result;
        }
        digits  = this.deal(digits, digits.length);
        return digits;
    }

    private int[] deal(int[] digits, int length){
        digits[length - 1] += 1;
        if (digits[length - 1] == 10){
            digits[length - 1] = 0;
            this.deal(digits, length -1);
        }
        return digits;
    }

}
