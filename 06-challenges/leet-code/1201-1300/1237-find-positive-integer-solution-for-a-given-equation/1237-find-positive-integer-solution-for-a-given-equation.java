// https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

// Solution: Two Pointers — O(x+y) time, O(1) space
// Solution: Two Pointers — O(x+y) time, O(1) space
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int x = 1, y = 1000;
        while (x <= 1000 && y >= 1) {
            int val = customfunction.f(x, y);
            if (val == z) { res.add(Arrays.asList(x++, y--)); }
            else if (val < z) { x++; }
            else { y--; }
        }
        return res;
    }
}
