// https://leetcode.com/problems/smallest-sufficient-team/

// Solution: Bitmask DP — O(people * 2^n) time, O(2^n) space
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillIndex.put(req_skills[i], i);
        }

        int full = (1 << n) - 1;
        // dp[mask] = list of person indices forming the smallest team covering mask
        List<Integer>[] dp = new List[full + 1];
        dp[0] = new ArrayList<>();

        for (int i = 0; i < people.size(); i++) {
            int pmask = 0;
            for (String skill : people.get(i)) {
                pmask |= (1 << skillIndex.get(skill));
            }
            // Iterate over all currently reachable states
            for (int mask = full; mask >= 0; mask--) {
                if (dp[mask] == null) {
                    continue;
                }
                int next = mask | pmask;
                if (dp[next] == null || dp[next].size() > dp[mask].size() + 1) {
                    dp[next] = new ArrayList<>(dp[mask]);
                    dp[next].add(i);
                }
            }
        }

        List<Integer> result = dp[full];
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
