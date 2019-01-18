package easy;

public class Solution16 {

    public int mySqrt(int x) {
        int result = 0;
        for (int i = 0; i <= 46340; i++) {
            if (i == 46340) return 46340;
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                result = i;
                break;
            }
        }
        return result;
    }

}
