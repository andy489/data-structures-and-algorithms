// https://leetcode.com/problems/finding-the-users-active-minutes/

// Solution: HashMap of Sets — O(n) time, O(n) space
class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> uam = new HashMap<>();
        for (int[] log : logs) {
            uam.computeIfAbsent(log[0], x -> new HashSet<>()).add(log[1]);
        }
        int[] ans = new int[k];
        for (Set<Integer> minutes : uam.values()) {
            int cnt = minutes.size();
            if (cnt <= k) {
                ans[cnt - 1]++;
            }
        }
        return ans;
    }
}
