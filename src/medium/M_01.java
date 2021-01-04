package medium;

// 最长重复子数组
// 输入:
//        A: [1,2,3,2,1]
//        B: [3,2,1,4,7]
//        输出: 3
//        解释:
//        长度最长的公共子数组是 [3, 2, 1]。
public class M_01 {

    // 暴力法
    public int findLength(int[] A, int[] B) {
        int maxLength = 0;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < B.length; j++){
                int k = 0;
                while (i + k < A.length && j + k < B.length && A[i + k] == B[j + k]){
                    k++;
                }
                maxLength = Math.max(maxLength, k);
            }
        }
        return maxLength;
    }
}
