// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        int maxDef = 0, weak = 0;
        for (int[] p : properties) {
            if (p[1] < maxDef) {
                weak++;
            }
            maxDef = Math.max(maxDef, p[1]);
        }
        return weak;
    }
}
