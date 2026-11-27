// https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/

// Solution: LCS via LIS with Binary Search — O((n + m) log n) time, O(n) space
class Solution {
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> posInTarget = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            posInTarget.put(target[i], i);
        }
        List<Integer> indices = new ArrayList<>();
        for (int v : arr) {
            if (posInTarget.containsKey(v)) {
                indices.add(posInTarget.get(v));
            }
        }
        // Find LIS length using patience sorting
        List<Integer> tails = new ArrayList<>();
        for (int idx : indices) {
            int pos = Collections.binarySearch(tails, idx);
            if (pos < 0) {
                pos = -(pos + 1);
            }
            if (pos == tails.size()) {
                tails.add(idx);
            } else {
                tails.set(pos, idx);
            }
        }
        return target.length - tails.size();
    }
}
