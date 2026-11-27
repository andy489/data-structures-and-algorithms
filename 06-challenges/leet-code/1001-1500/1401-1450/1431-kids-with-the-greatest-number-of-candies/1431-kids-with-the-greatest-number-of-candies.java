// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

// Solution: Linear Scan — O(n) time, O(n) space
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) max = Math.max(max, c);
        List<Boolean> res = new ArrayList<>();
        for (int c : candies) res.add(c + extraCandies >= max);
        return res;
    }
}
