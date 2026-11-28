// https://leetcode.com/problems/eat-pizzas/

// Solution: Greedy with Sorting — O(n log n) time, O(1) space
class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int days = n / 4;
        int odd = (days + 1) / 2;
        int even = days / 2;
        long total = 0;
        // Odd days: take maximum (Z) = pizzas[n-1], pizzas[n-3], ...
        for (int i = 0; i < odd; i++) {
            total += pizzas[n - 1 - 2 * i];
        }
        // Even days: take 2nd maximum (Y) = pizzas[n-2], pizzas[n-4], ...
        for (int i = 0; i < even; i++) {
            total += pizzas[n - 2 - 2 * i];
        }
        return total;
    }
}
