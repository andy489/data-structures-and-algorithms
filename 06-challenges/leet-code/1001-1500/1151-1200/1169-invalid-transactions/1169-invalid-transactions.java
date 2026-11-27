// https://leetcode.com/problems/invalid-transactions/

// Solution: HashMap by Name + Pairwise Check — O(n²) time, O(n) space
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n = transactions.length;
        // Parse each transaction
        String[] names = new String[n];
        int[] times = new int[n];
        int[] amounts = new int[n];
        String[] cities = new String[n];
        Map<String, List<Integer>> byName = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = transactions[i].split(",");
            names[i] = parts[0];
            times[i] = Integer.parseInt(parts[1]);
            amounts[i] = Integer.parseInt(parts[2]);
            cities[i] = parts[3];
            byName.computeIfAbsent(names[i], k -> new ArrayList<>()).add(i);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (amounts[i] > 1000) {
                result.add(transactions[i]);
                continue;
            }
            boolean invalid = false;
            for (int j : byName.get(names[i])) {
                if (j != i && Math.abs(times[i] - times[j]) <= 60 && !cities[i].equals(cities[j])) {
                    invalid = true;
                    break;
                }
            }
            if (invalid) {
                result.add(transactions[i]);
            }
        }
        return result;
    }
}
