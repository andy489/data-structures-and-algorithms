// https://leetcode.com/problems/powerful-integers/

// Solution: Enumerate Powers — O(log(bound)²) time, O(log(bound)²) space
class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        for (int xi = 1; xi <= bound; xi = (x == 1) ? bound + 1 : xi * x) {
            for (int yj = 1; xi + yj <= bound; yj = (y == 1) ? bound + 1 : yj * y) {
                res.add(xi + yj);
            }
        }
        return new ArrayList<>(res);
    }
}
