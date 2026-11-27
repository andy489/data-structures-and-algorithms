// https://leetcode.com/problems/statistics-from-a-large-sample/

// Solution: Direct Computation — O(256) = O(1) time, O(1) space
class Solution {
    public double[] sampleStats(int[] count) {
        double min = -1, max = -1, mean, median;
        int mode = 0;
        long total = 0, sum = 0;
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                if (min == -1) min = i;
                max = i;
                if (count[i] > count[mode]) mode = i;
                total += count[i];
                sum += (long) i * count[i];
            }
        }
        mean = (double) sum / total;
        long mid1 = (total + 1) / 2, mid2 = (total + 2) / 2;
        double m1 = -1, m2 = -1;
        long cumulative = 0;
        for (int i = 0; i < 256; i++) {
            cumulative += count[i];
            if (m1 == -1 && cumulative >= mid1) m1 = i;
            if (m2 == -1 && cumulative >= mid2) m2 = i;
        }
        median = (m1 + m2) / 2.0;
        return new double[]{min, max, mean, median, mode};
    }
}
