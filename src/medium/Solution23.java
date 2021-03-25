package medium;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution23 {

    private String plusOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9')
            chars[j] = '0';
        else
            chars[j] += 1;
        return new String(chars);
    }

    private String minsOne(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0')
            chars[j] = '9';
        else
            chars[j] -= 1;
        return new String(chars);
    }

    //采用双向BFS进行优化
    // deads 和 visited 可以只使用一个
    // 双向BFS 在进行扩散时，可以判断size选择size小的集合进行扩散

    public int openLock(String[] deadends, String target){
        Set<String> deads = new HashSet<>();
        for (String s : deadends) deads.add(s);

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();

        q1.add("0000");
        q2.add(target);

        int step = 0;

        // 不会造成死循环吗 temp会为空
        while (!q1.isEmpty() && !q2.isEmpty()){
            Set<String> temp = new HashSet<>();

            for (String cur : q1){
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;

                visited.add(cur);

                for (int j = 0; j < 4; j++){
                    String up = plusOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minsOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                }
            }
            step++;
            q1 = q2;
            q2 = temp;
        }

        return -1;
    }

//    public int openLock(String[] deadends, String target) {
//        Set<String> deads = new HashSet<>();
//        for (String s : deadends) deads.add(s);
//        // 避免回头路
//        Set<String> visited = new HashSet<>();
//        Queue<String> q = new LinkedList<>();
//
//        int step = 0;
//        q.offer("0000");
//        visited.add("0000");
//
//        while (!q.isEmpty()) {
//            int sz = q.size();
//
//            for (int i = 0; i < sz; i++) {
//                String cur = q.poll();
//
//                if (deads.contains(cur))
//                    continue;
//                if (cur.equals(target))
//                    return step;
//
//                for (int j = 0; j < 4; j++) {
//                    String up = plusOne(cur, j);
//                    if (!visited.contains(up)) {
//                        q.offer(up);
//                        visited.add(up);
//                    }
//                    String down = minsOne(cur, j);
//                    if (!visited.contains(down)) {
//                        q.offer(down);
//                        visited.add(down);
//                    }
//                }
//            }
//            step++;
//        }
//        return -1;
//    }

    // 问题：
    // 1. 会走回头路 0000 至 1000, 然后1000会回到0000
    // 2. 终止条件
    // 3. 没有解决deadends
    private void BFS(String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");


        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // 判断是否到终点
                if (cur.equals(target))
                    System.out.println(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minsOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }

                // 计算步数
            }
        }
    }


    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        Solution23 solution23 = new Solution23();
        System.out.println(solution23.openLock(deadends, target));
    }
}
