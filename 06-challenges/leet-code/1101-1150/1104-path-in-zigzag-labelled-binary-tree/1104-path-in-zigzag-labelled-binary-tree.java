// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

// Solution: Math (Work Upwards) — O(log n) time, O(log n) space
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> path = new ArrayList<>();
        while (label >= 1) {
            path.add(label);
            int row = (int) (Math.log(label) / Math.log(2));
            int rowMin = 1 << row;
            int rowMax = (1 << (row + 1)) - 1;
            int mirror = rowMin + rowMax - label;
            label = mirror / 2;
        }
        Collections.reverse(path);
        return path;
    }
}
