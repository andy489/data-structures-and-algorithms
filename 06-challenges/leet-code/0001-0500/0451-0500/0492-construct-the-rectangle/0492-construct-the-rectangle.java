// https://leetcode.com/problems/construct-the-rectangle/

// Solution: Square Root Search — O(sqrt(area)) time, O(1) space
class Solution {
    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        return new int[]{area / width, width};
    }
}
