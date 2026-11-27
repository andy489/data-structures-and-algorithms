// https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
class Solution {
    public int[] assignElements(int[] groups, int[] elements) {
        int maxG = 0;
        for (int g : groups) {
            maxG = Math.max(maxG, g);
        }
        int[] lookup = new int[maxG + 1];
        java.util.Arrays.fill(lookup, -1);
        for (int j = elements.length - 1; j >= 0; j--) {
            int e = elements[j];
            if (e > maxG) {
                continue;
            }
            for (int multiple = e; multiple <= maxG; multiple += e) {
                lookup[multiple] = j;
            }
        }
        int[] assigned = new int[groups.length];
        for (int i = 0; i < groups.length; i++) {
            assigned[i] = lookup[groups[i]];
        }
        return assigned;
    }
}
