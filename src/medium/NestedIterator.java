package medium;

import java.util.LinkedList;
import java.util.List;

public class NestedIterator {

    private LinkedList<NestedInteger> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }


    public Integer next() {
        return list.remove(0).getInteger();
    }

    public boolean hasNext() {
        while (!list.isEmpty() && !list.get(0).isInteger()) {
            List<NestedInteger> first = list.remove(0).getList();
            for (int i = first.size() - 1; i > 0; i--) {
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
}
