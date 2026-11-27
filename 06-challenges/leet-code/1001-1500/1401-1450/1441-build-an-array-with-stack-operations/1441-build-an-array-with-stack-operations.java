// https://leetcode.com/problems/build-an-array-with-stack-operations/

// Solution: Simulation — O(n) time, O(n) space
class Solution {
    public List<String> buildArray(int[] target, int n) {
        Set<Integer> tSet = new HashSet<>();
        for (int t : target) tSet.add(t);
        List<String> ops = new ArrayList<>();
        for (int i = 1; i <= target[target.length-1]; i++) {
            ops.add("Push");
            if (!tSet.contains(i)) ops.add("Pop");
        }
        return ops;
    }
}
