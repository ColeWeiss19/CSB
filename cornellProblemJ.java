import java.util.*;

public class TrainTracks {
    static class Segment {
        int x1, y1, x2, y2;

        Segment(int x1, int y1, int x2, int y2) {
            if (x1 > x2 || y1 > y2) {
                int tempX = x1, tempY = y1;
                x1 = x2;
                y1 = y2;
                x2 = tempX;
                y2 = tempY;
            }
            this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
        }

        List<String> getPoints() {
            List<String> points = new ArrayList<>();
            if (x1 == x2) {
                for (int y = y1; y <= y2; y++) {
                    points.add(x1 + "," + y);
                }
            } else {
                for (int x = x1; x <= x2; x++) {
                    points.add(x + "," + y1);
                }
            }
            return points;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<String> trackPoints = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Segment s = new Segment(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            trackPoints.addAll(s.getPoints());
        }

        System.out.println(trackPoints.size());

        sc.close();
    }
}
