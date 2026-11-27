// https://leetcode.com/problems/shopping-offers/

// Solution: DFS + Memoization — O(k·m·n) time, O(k·n) space
class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs(price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int cost = 0;
        for (int i = 0; i < needs.size(); i++) {
            cost += needs.get(i) * price.get(i);
        }
        for (List<Integer> offer : special) {
            List<Integer> remaining = new ArrayList<>(needs);
            boolean applicable = true;
            for (int i = 0; i < needs.size(); i++) {
                int diff = remaining.get(i) - offer.get(i);
                if (diff < 0) {
                    applicable = false;
                    break;
                }
                remaining.set(i, diff);
            }
            if (applicable) {
                cost = Math.min(cost, offer.get(offer.size() - 1) + dfs(price, special, remaining, memo));
            }
        }
        memo.put(needs, cost);
        return cost;
    }
}
