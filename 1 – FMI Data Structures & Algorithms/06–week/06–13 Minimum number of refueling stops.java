// https://leetcode.com/problems/minimum-number-of-refueling-stops/

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int minRefuels = 0;

        final int N = stations.length;

        for (int[] station : stations) {
            while (startFuel < station[0]) {
                if (pq.isEmpty()) {
                    return -1;
                }

                startFuel += pq.poll();
                minRefuels++;
            }

            pq.offer(station[1]);
        }

        while (startFuel < target) {
            if (pq.isEmpty()) {
                return -1;
            }

            startFuel += pq.poll();
            minRefuels++;
        }

        return minRefuels;
    }
}
