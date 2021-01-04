package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 给出一个非空的字符串，判断这个字符串是否由它的用一个子串进行多次首次拼接构成的。
// 例如，"adcabcabc"满足条件，因为它是由"abc"首位拼接而成的，而"abcab"则不满足条件。
public class T_01 {


    private static  void printHelper(int left, int right, String out, List<String> result){
        if (left < 0 || right < 0 || left > right ) return;
        if (left == 0  && right == 0){
            result.add(out);
            return;
        }
        printHelper(left - 1, right, out + "(", result);
        printHelper(left, right - 1, out + ")", result);
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new ArrayList<>();
        printHelper(n, n,"", result);

        Collections.sort(result);
        for (String re : result){
            System.out.println(re);
        }

    }
}
