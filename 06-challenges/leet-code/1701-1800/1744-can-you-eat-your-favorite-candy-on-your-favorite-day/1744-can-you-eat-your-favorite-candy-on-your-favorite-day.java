// https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

// Solution: Prefix Sum + Range Check — O(n+q) time, O(n) space
class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + candiesCount[i];
        }
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long type = queries[i][0], day = queries[i][1], cap = queries[i][2];
            // Can reach type: at least one candy of earlier types must be eaten, so day >= prefix[type]
            // Can still eat type: by day+1 we eat at most (day+1)*cap, must exceed prefix[type]
            answer[i] = day >= prefix[(int) type] && (day + 1) * cap > prefix[(int) type];
        }
        return answer;
    }
}
