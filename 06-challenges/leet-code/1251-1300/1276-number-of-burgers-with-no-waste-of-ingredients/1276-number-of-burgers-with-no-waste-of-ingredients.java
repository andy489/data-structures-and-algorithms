// https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

// Solution: Linear Equations — O(1) time, O(1) space
// Solution: Linear Equations — O(1) time, O(1) space
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int diff = tomatoSlices - 2 * cheeseSlices;
        if (diff < 0 || diff % 2 != 0) return new ArrayList<>();
        int jumbo = diff / 2, small = cheeseSlices - jumbo;
        if (small < 0) return new ArrayList<>();
        return Arrays.asList(jumbo, small);
    }
}
