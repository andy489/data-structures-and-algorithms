// https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Set<Integer> excavated = new HashSet<>();
        for (int[] d : dig) {
            excavated.add(d[0] * n + d[1]);
        }
        int count = 0;
        for (int[] a : artifacts) {
            boolean canExtract = true;
            outer:
            for (int r = a[0]; r <= a[2]; r++) {
                for (int c = a[1]; c <= a[3]; c++) {
                    if (!excavated.contains(r * n + c)) {
                        canExtract = false;
                        break outer;
                    }
                }
            }
            if (canExtract) {
                count++;
            }
        }
        return count;
    }
}
