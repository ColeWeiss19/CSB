import java.util.*;

public class BeehiveWalk {
    public static int[] move(String dir) {
        switch (dir) {
            case "n":  return new int[]{ 0, 1, -1 };
            case "ne": return new int[]{ 1, 0, -1 };
            case "se": return new int[]{ 1, -1, 0 };
            case "s":  return new int[]{ 0, -1, 1 };
            case "sw": return new int[]{ -1, 0, 1 };
            case "nw": return new int[]{ -1, 1, 0 };
            default: throw new IllegalArgumentException("Invalid direction: " + dir);
        }
    }

    public static int cubeDistance(int[] cube) {
        return Math.max(Math.abs(cube[0]), Math.max(Math.abs(cube[1]), Math.abs(cube[2])));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        while (cases-- > 0) {
            int steps = sc.nextInt();
            int[] pos = new int[]{0, 0, 0};

            for (int i = 0; i < steps; i++) {
                String dir = sc.next();
                int[] delta = move(dir);
                for (int j = 0; j < 3; j++) {
                    pos[j] += delta[j];
                }
            }
            System.out.println(cubeDistance(pos));
        }

        sc.close();
    }
}
