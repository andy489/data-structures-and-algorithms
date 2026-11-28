// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

// Solution: Greedy — O(n² / factor_max) time, O(n) space
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // freeCount[i] = number of j != i where factor[i] divides factor[j]
        int[] freeCount = new int[n];
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % fi == 0) {
                    freeCount[i]++;
                }
            }
        }

        long minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // Sort by effective value of first copy (1 + freeCount[i]) / price descending
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> {
            long lhs = (long)(1 + freeCount[a]) * items[b][1];
            long rhs = (long)(1 + freeCount[b]) * items[a][1];
            return Long.compare(rhs, lhs);
        });

        long total = 0;
        long remaining = budget;

        for (int i : idx) {
            if (remaining <= 0) {
                break;
            }
            long price = items[i][1];
            if (price <= remaining) {
                remaining -= price;
                total += 1 + freeCount[i];
            }
        }
        total += remaining / minPrice;

        return (int) total;
    }
}
