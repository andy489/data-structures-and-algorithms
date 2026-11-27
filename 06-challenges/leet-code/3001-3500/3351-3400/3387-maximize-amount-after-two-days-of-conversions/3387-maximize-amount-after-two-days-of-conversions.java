// https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/

// Solution: BFS Reachability with Rate Propagation — O((n+m)*C) time, O(C) space
class Solution {
    private java.util.Map<String, java.util.List<Object[]>> buildGraph(
            java.util.List<java.util.List<String>> pairs, double[] rates) {
        java.util.Map<String, java.util.List<Object[]>> graph = new java.util.HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String a = pairs.get(i).get(0), b = pairs.get(i).get(1);
            double r = rates[i];
            graph.computeIfAbsent(a, k -> new java.util.ArrayList<>()).add(new Object[]{b, r});
            graph.computeIfAbsent(b, k -> new java.util.ArrayList<>()).add(new Object[]{a, 1.0 / r});
        }
        return graph;
    }

    private java.util.Map<String, Double> bfs(
            java.util.Map<String, Double> initAmounts,
            java.util.Map<String, java.util.List<Object[]>> graph) {
        java.util.Map<String, Double> amounts = new java.util.HashMap<>(initAmounts);
        java.util.Queue<String> queue = new java.util.LinkedList<>(initAmounts.keySet());
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            double curAmt = amounts.get(cur);
            for (Object[] nr : graph.getOrDefault(cur, java.util.Collections.emptyList())) {
                String nb = (String) nr[0];
                double newAmt = curAmt * (double) nr[1];
                if (!amounts.containsKey(nb) || newAmt > amounts.get(nb)) {
                    amounts.put(nb, newAmt);
                    queue.offer(nb);
                }
            }
        }
        return amounts;
    }

    public double maxAmount(String initialCurrency,
                            java.util.List<java.util.List<String>> pairs1, double[] rates1,
                            java.util.List<java.util.List<String>> pairs2, double[] rates2) {
        java.util.Map<String, java.util.List<Object[]>> g1 = buildGraph(pairs1, rates1);
        java.util.Map<String, java.util.List<Object[]>> g2 = buildGraph(pairs2, rates2);

        // Day 1: BFS from initialCurrency with 1.0
        java.util.Map<String, Double> day1 = bfs(
            java.util.Collections.singletonMap(initialCurrency, 1.0), g1);

        // Day 2: BFS seeded with all day1 reachable amounts
        java.util.Map<String, Double> day2 = bfs(day1, g2);

        return day2.getOrDefault(initialCurrency, 1.0);
    }
}
