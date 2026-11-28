// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

// Solution: Sieve freeCount (grouped by factor) + greedy on bonus units — O(n log n) time, O(n) space
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        // Count items per factor value (factor_i <= n)
        int[] factorCount = new int[n + 1];
        for (int[] item : items) {
            factorCount[item[0]]++;
        }

        // For each distinct factor value f, compute freePerFactor[f] =
        // (total items with factor divisible by f) - (items with factor exactly f)
        // = number of j where f | factor[j] and factor[j] != f
        // Then freeCount[i] = freePerFactor[factor[i]] + (factorCount[factor[i]] - 1)
        // which simplifies to: sum of factorCount[mult] for mult=f,2f,... minus 1 (self)
        // But we compute this once per distinct f, not per item.
        int[] sumDivisibleBy = new int[n + 1]; // sumDivisibleBy[f] = sum factorCount[f*k] for k=1,2,...
        for (int f = 1; f <= n; f++) {
            if (factorCount[f] == 0) {
                continue;
            }
            for (int mult = f; mult <= n; mult += f) {
                sumDivisibleBy[f] += factorCount[mult];
            }
        }
        // freeCount[i] = sumDivisibleBy[factor[i]] - 1 (subtract self)
        int[] freeCount = new int[n];
        for (int i = 0; i < n; i++) {
            freeCount[i] = sumDivisibleBy[items[i][0]] - 1;
        }

        // Find cheapest item price
        long minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            if (item[1] < minPrice) {
                minPrice = item[1];
            }
        }

        // Sort by price ascending; take bonus copies (2-for-1) greedily while price <= 2*minPrice
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(items[a][1], items[b][1]));

        long total = 0;
        long remaining = budget;

        for (int ii : idx) {
            long price = items[ii][1];
            if (price > 2 * minPrice) {
                break;
            }
            int bonus = freeCount[ii];
            if (bonus > 0 && remaining >= price) {
                long canBonus = Math.min(bonus, remaining / price);
                total += 2 * canBonus;
                remaining -= canBonus * price;
            }
        }

        total += remaining / minPrice;

        return (int) total;
    }
}
