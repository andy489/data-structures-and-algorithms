// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

// Solution: Sieve freeCount + greedy on sorted bonus units — O(n log n) time, O(n) space
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Count items per factor value (factor_i <= n)
        int[] factorCount = new int[n + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }

        // freeCount[i] = number of j != i where factor[i] | factor[j]
        // = (sum of factorCount[mult] for mult = factor[i], 2*factor[i], ...) - 1 (subtract self)
        int[] freeCount = new int[n];
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int total = 0;
            for (int mult = fi; mult <= n; mult += fi) {
                total += factorCount[mult];
            }
            freeCount[i] = total - 1; // subtract self
        }

        // Greedy: for item i, buying up to freeCount[i] copies is "2-for-1" at price[i].
        // Collect all bonus units (each gives +1 extra free item) sorted by price ascending.
        // Then fill remaining budget with cheapest item (1-for-1).

        // Flatten: each bonus unit is one entry with its price
        // Total bonus units = sum of freeCount[i], up to n*n in worst case — too large to sort directly.
        // Instead: sort items by price, then greedily take as many bonus units as budget allows.

        // Sort items by price ascending
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> items[a][1] - items[b][1]);

        long total = 0;
        long remaining = budget;

        for (int ii : idx) {
            if (remaining <= 0) {
                break;
            }
            long price = items[ii][1];
            int bonusUnits = freeCount[ii]; // each bonus unit costs price, yields 2

            if (bonusUnits > 0) {
                // Buy as many bonus units as possible (up to bonusUnits)
                long canBuy = Math.min(bonusUnits, remaining / price);
                total += 2 * canBuy;
                remaining -= canBuy * price;
            }
        }

        // Fill remaining budget with cheapest item (1-for-1)
        long minPrice = items[idx[0]][1];
        total += remaining / minPrice;

        return (int) total;
    }
}
