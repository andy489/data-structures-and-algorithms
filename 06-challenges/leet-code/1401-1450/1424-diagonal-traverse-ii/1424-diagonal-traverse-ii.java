// https://leetcode.com/problems/diagonal-traverse-ii/

// Solution: HashMap by Diagonal — O(n) time, O(n) space
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diag = new HashMap<>();
        int total = 0, maxD = 0;
        for (int i = nums.size()-1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                diag.computeIfAbsent(i+j, x -> new ArrayList<>()).add(nums.get(i).get(j));
                maxD = Math.max(maxD, i+j);
                total++;
            }
        }
        int[] res = new int[total];
        int idx = 0;
        for (int d = 0; d <= maxD; d++)
            for (int v : diag.getOrDefault(d, Collections.emptyList()))
                res[idx++] = v;
        return res;
    }
}
