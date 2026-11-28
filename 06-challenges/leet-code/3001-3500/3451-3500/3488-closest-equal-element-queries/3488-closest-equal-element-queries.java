// https://leetcode.com/problems/closest-equal-element-queries/

// Solution: HashMap + Binary Search — O((n + q) log n) time, O(n) space
class Solution {
    public int[] solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < n; i++) {
            positions.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }
        int[] answer = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int idx = queries[q];
            int v = nums[idx];
            List<Integer> pos = positions.get(v);
            if (pos.size() == 1) {
                answer[q] = -1;
                continue;
            }
            int p = Collections.binarySearch(pos, idx);
            int best = Integer.MAX_VALUE;
            // Check neighbors in circular sorted list
            int prev = (p - 1 + pos.size()) % pos.size();
            int next = (p + 1) % pos.size();
            int d1 = Math.abs(pos.get(prev) - idx);
            best = Math.min(best, Math.min(d1, n - d1));
            int d2 = Math.abs(pos.get(next) - idx);
            best = Math.min(best, Math.min(d2, n - d2));
            answer[q] = best;
        }
        return answer;
    }
}
