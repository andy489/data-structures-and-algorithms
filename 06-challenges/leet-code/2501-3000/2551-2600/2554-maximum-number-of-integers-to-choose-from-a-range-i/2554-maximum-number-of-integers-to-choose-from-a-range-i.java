// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

// Solution: Greedy with HashSet — O(n + b) time, O(b) space
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        for (int b : banned) {
            bannedSet.add(b);
        }
        int count = 0;
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            count++;
        }
        return count;
    }
}
