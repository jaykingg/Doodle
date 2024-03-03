package java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TRSolve3 {
    public int[][] solution(int N, int[][] bus_stop) {
        int[][] answer = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE);
        }

        Queue<Position> queue = new LinkedList<>();
        for (int[] stop : bus_stop) {
            queue.offer(new Position(stop[0] - 1, stop[1] - 1, 0));
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            Position now = queue.poll();
            int x = now.x;
            int y = now.y;
            int distance = now.distance;

            if (visited[x][y]) continue;
            visited[x][y] = true;
            answer[x][y] = distance;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    queue.offer(new Position(nx, ny, distance + 1));
                }
            }
        }

        return answer;
    }

    static class Position {
        int x;
        int y;
        int distance;

        public Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

//    public int[][] solution(int N, int[][] bus_stop) {
//        int[][] answer = new int[N][N];
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                answer[i][j] = calculateDistance(i, j, bus_stop);
//            }
//        }
//
//        return answer;
//    }
//
//    // 주어진 위치에서 가장 가까운 정류장과의 거리 계산하는 함수
//    private int calculateDistance(int x, int y, int[][] bus_stop) {
//        int minDistance = Integer.MAX_VALUE;
//
//        for (int[] stop : bus_stop) {
//            int distance = Math.abs(x - stop[0]) + Math.abs(y - stop[1]);
//            minDistance = Math.min(minDistance, distance);
//        }
//
//        return minDistance;
//    }
}
