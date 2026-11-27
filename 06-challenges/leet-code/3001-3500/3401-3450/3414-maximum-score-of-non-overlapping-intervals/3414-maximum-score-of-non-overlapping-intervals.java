// https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        // Store [left, right, weight, originalIndex]
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        // Sort by right endpoint, then left, then original index for lex smallest
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[3] - b[3];
        });

        // dp[k][i] = best sum using k intervals, last being arr[i]
        // We track 4 layers
        int K = 4;
        long[][] dp = new long[K + 1][n];
        int[][][] parent = new int[K + 1][n][2]; // [prev_k][prev_i]

        for (int k = 1; k <= K; k++) {
            long bestPrev = 0;
            int bestPrevIdx = -1;
            int ptr = 0;  // pointer for binary search
            for (int i = 0; i < n; i++) {
                // Find last j where arr[j].right < arr[i].left
                int left = arr[i][0];
                int lo = 0, hi = i;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[mid][1] < left) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                int j = lo - 1;  // last valid previous

                long prevBest = j >= 0 ? dp[k - 1][j] : (k == 1 ? 0 : Long.MIN_VALUE / 2);
                long withI = (k == 1 ? 0 : (j >= 0 ? dp[k - 1][j] : Long.MIN_VALUE / 2)) + arr[i][2];
                // For k=1 there's no previous needed
                if (k == 1) {
                    dp[k][i] = arr[i][2];
                } else {
                    dp[k][i] = j >= 0 ? dp[k - 1][j] + arr[i][2] : Long.MIN_VALUE / 2;
                }

                // Also consider dp[k][i-1] (not picking i)
                if (i > 0 && dp[k][i - 1] > dp[k][i]) {
                    dp[k][i] = dp[k][i - 1];
                    parent[k][i][0] = k;
                    parent[k][i][1] = i - 1;
                } else {
                    parent[k][i][0] = k - 1;
                    parent[k][i][1] = j;
                }
            }
        }

        // Find the best answer
        // Reconstruct: try each count from 1 to 4
        // This reconstruction is complex; use a cleaner approach below
        return reconstructAnswer(arr, intervals.size());
    }

    private int[] reconstructAnswer(int[][] arr, int n) {
        int K = 4;
        // dp2[k][i] = max total weight using exactly k intervals, last being arr[i]
        // For "at most 4", we track best over all k in [1..4]
        long[][] dp2 = new long[K + 1][n];
        int[][] prevIdx = new int[K + 1][n];
        for (int[] row : prevIdx) {
            Arrays.fill(row, -1);
        }

        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                int left = arr[i][0];
                int lo = 0, hi = i;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (arr[mid][1] < left) lo = mid + 1;
                    else hi = mid;
                }
                int j = lo - 1;
                if (k == 1) {
                    dp2[k][i] = arr[i][2];
                    prevIdx[k][i] = -1;
                } else if (j >= 0) {
                    dp2[k][i] = dp2[k - 1][j] + arr[i][2];
                    prevIdx[k][i] = j;
                } else {
                    dp2[k][i] = Long.MIN_VALUE / 2;
                }
            }
        }

        // Find best
        long bestVal = Long.MIN_VALUE;
        int bestK = -1, bestI = -1;
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < n; i++) {
                if (dp2[k][i] > bestVal) {
                    bestVal = dp2[k][i];
                    bestK = k;
                    bestI = i;
                }
            }
        }

        // Reconstruct
        List<Integer> indices = new ArrayList<>();
        int curK = bestK, curI = bestI;
        while (curI >= 0 && curK >= 1) {
            indices.add(arr[curI][3]);
            int nextI = prevIdx[curK][curI];
            curK--;
            curI = nextI;
        }
        Collections.sort(indices);
        return indices.stream().mapToInt(x -> x).toArray();
    }
}
