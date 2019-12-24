package easy;

import java.util.ArrayList;
import java.util.List;

// 杨辉三角
public class Solution23 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> yhTriangles = new ArrayList<>();
        List<Integer> preNumLine = new ArrayList<>();
        if (numRows == 0) return yhTriangles;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> numLine = new ArrayList<>();
            numLine.add(1);
            int num = 2;
            while (num < i) {
                numLine.add(preNumLine.get(num - 2) + preNumLine.get(num - 1));
                num++;
            }
            if (num == i)
                numLine.add(1);
            preNumLine = numLine;
            yhTriangles.add(numLine);
        }
        return yhTriangles;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        System.out.println("result:" + solution23.generate(5));
    }

}
