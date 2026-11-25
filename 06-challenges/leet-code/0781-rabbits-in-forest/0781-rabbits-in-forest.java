// https://leetcode.com/problems/rabbits-in-forest/

// Solution: Greedy Grouping — O(n) time, O(n) space
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : answers) {
            freq.put(a, freq.getOrDefault(a, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int k = entry.getKey();
            int cnt = entry.getValue();
            int groupSize = k + 1;
            int groups = (cnt + groupSize - 1) / groupSize;
            total += groups * groupSize;
        }
        return total;
    }
}
