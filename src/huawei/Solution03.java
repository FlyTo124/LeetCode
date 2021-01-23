package huawei;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution03 {

    private int x = 0;

    private int y = 0;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void getCoordinate() {
        System.out.println(x + "," + y);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Solution03 solution03 = new Solution03();
        String[] moves = s.split(";");
        List<Character> commands = Arrays.asList('A', 'W', 'D', 'S');
        for (String move : moves) {
            if (move.isEmpty())
                continue;
            char command = move.charAt(0);
            if (!commands.contains(command))
                continue;
            try {
                int step = Integer.parseInt(move.substring(1));
                solution03.move(command, step);
            } catch (NumberFormatException e) {
                ;
            }
        }
        solution03.getCoordinate();
        in.close();
    }

    private void move(char command, int step) {
        switch (command) {
            case 'A':
                x -= step;
                break;
            case 'D':
                x += step;
                break;
            case 'W':
                y += step;
                break;
            case 'S':
                y -= step;
                break;
            default:
                break;
        }
    }
}
