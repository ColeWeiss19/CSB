import java.util.*;

public class SpiralAnts {
    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static Point getCoordinates(int n) {
        if (n == 1) return new Point(0, 0);
        int layer = 0;
        while ((2 * layer + 1) * (2 * layer + 1) < n) layer++;

        int maxInLayer = (2 * layer + 1) * (2 * layer + 1);
        int sideLength = 2 * layer;
        int stepsBack = maxInLayer - n;
        int side = stepsBack / sideLength;
        int offset = stepsBack % sideLength;

        int x = 0, y = 0;
        switch (side) {
            case 0: x = layer - offset; y = -layer; break;
            case 1: x = -layer; y = -layer + offset; break;
            case 2: x = -layer + offset; y = layer; break;
            case 3: x = layer; y = layer - offset; break;
        }
        return new Point(x, y);
    }

    public static int shortestPath(int n) {
        Point p = getCoordinates(n);
        return Math.abs(p.x) + Math.abs(p.y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int n = sc.nextInt();
            System.out.println(shortestPath(n));
        }
        sc.close();
    }
}
