// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

// Solution: Sieve freeCount + greedy on bonus units — O(n log n) time, O(n) space
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Count items per factor value (factor_i <= n)
        int[] factorCount = new int[n + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }

        // freeCount[i] = number of j != i where factor[i] | factor[j]
        // Buying k <= freeCount[i] copies of item i yields 2k items (k purchased + k free).
        // Buying more than freeCount[i] copies yields freeCount[i] extra free items total.
        int[] freeCount = new int[n];
        for (int i = 0; i < n; i++) {
            int fi = items[i][0];
            int cnt = 0;
            for (int mult = fi; mult <= n; mult += fi) {
                cnt += factorCount[mult];
            }
            freeCount[i] = cnt - 1;
        }

        // Find cheapest item price (best 1-for-1 rate for extra copies)
        long minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // Greedy: bonus copies (2-for-1) are strictly better than regular copies (1-for-1)
        // when price[i] <= 2 * minPrice (since 2/price[i] >= 1/minPrice iff price[i] <= 2*minPrice).
        // Always true if price[i] <= 2*minPrice. When price[i] > 2*minPrice, skip bonus copies.
        // Sort by price ascending; take all bonus units cheaper than 2*minPrice greedily.

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(items[a][1], items[b][1]));

        long total = 0;
        long remaining = budget;

        for (int ii : idx) {
            long price = items[ii][1];
            // A bonus copy at price is worth taking only if 2/price >= 1/minPrice
            // i.e., price <= 2 * minPrice
            if (price > 2 * minPrice) {
                break; // sorted by price, no better bonus units remain
            }
            int bonus = freeCount[ii];
            if (bonus > 0 && remaining >= price) {
                long canBonus = Math.min(bonus, remaining / price);
                total += 2 * canBonus;
                remaining -= canBonus * price;
            }
        }

        // Fill remaining with cheapest item (1-for-1)
        total += remaining / minPrice;

        return (int) total;
    }
}
