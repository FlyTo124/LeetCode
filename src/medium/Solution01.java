package medium;

import model.UnionFind;

import java.util.*;

// 账户合并
public class Solution01 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
        Map<String, String> emailToName = new HashMap<String, String>();
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                uf.union(firstIndex, nextIndex);
            }
        }
        Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
            account.add(email);
            indexToEmails.put(index, account);
        }
        List<List<String>> merged = new ArrayList<List<String>>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<String>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }
        return merged;
    }

    public static void main(String[] args) {
        List<String> list1 = new LinkedList<String>() {
            {
                add("John");
                add("johnsmith@mail.co");
                add("john_newyork@mail.com");
            }
        };
        List<String> list2 = new LinkedList<String>() {
            {
                add("John");
                add("john00@mail.com");
                add("johnsmith@mail.co");
                add("john02@mail.com");
            }
        };
        List<String> list3 = new LinkedList<String>() {
            {
                add("John");
                add("johnnybravo@mail.com");
            }
        };
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        Solution01 s = new Solution01();
        List<List<String>> result = s.accountsMerge(accounts);
        result.forEach(System.out::println);
    }


}