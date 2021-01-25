package huawei;



import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Solution05 {

    private String path;

    private String fileName;

    private int rowNum;

    private int count = 1;

    public Solution05(String path, int rowNum) {
        this.path = path;
        String[] strings = path.split("\\\\");
        String fileName = strings[strings.length - 1];
        if (fileName.length() > 16)
            this.fileName = fileName.substring(fileName.length() - 16);
        else
            this.fileName = fileName;
        this.rowNum = rowNum;
    }

    public void increaseCount() {
        count++;
    }

    public String getResult() {
        return fileName + " " + rowNum + " " + count;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        int index = 0;
        List<Solution05> list = new LinkedList<>();
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (input.isEmpty())
                break;
            String[] data = input.split(" ");
            Solution05 main = new Solution05(data[0], Integer.parseInt(data[1]));
            String key = main.fileName + "\\\\" + main.rowNum;
            if (!map.containsKey(key)) {
                map.put(key, index);
                list.add(main);
                index++;
            } else {
                int i = map.get(key);
                Solution05 main1 = list.get(i);
                main1.increaseCount();
                list.set(i, main1);
            }
        }
        int length = list.size();
        if (length <= 8) {
            for (Solution05 main : list) {
                System.out.println(main.getResult());
            }
        } else {
            for (int i = length - 8; i < length; i++) {
                Solution05 main = list.get(i);
                System.out.println(main.getResult());
            }
        }
        in.close();
    }
}
