// https://leetcode.com/problems/maximum-square-area-by-removing-fences-from-a-field/
class Solution {
    public long maximumArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;
        Set<Long> hGaps = computeGaps(m, hFences);
        Set<Long> vGaps = computeGaps(n, vFences);
        long best = -1;
        for (long gap : hGaps) {
            if (vGaps.contains(gap)) {
                best = Math.max(best, gap);
            }
        }
        if (best == -1) {
            return -1;
        }
        return (best % MOD) * (best % MOD) % MOD;
    }

    private Set<Long> computeGaps(int max, int[] fences) {
        int[] positions = new int[fences.length + 2];
        positions[0] = 1;
        for (int i = 0; i < fences.length; i++) {
            positions[i + 1] = fences[i];
        }
        positions[positions.length - 1] = max;
        Arrays.sort(positions);
        Set<Long> gaps = new HashSet<>();
        for (int i = 0; i < positions.length; i++) {
            for (int j = i + 1; j < positions.length; j++) {
                gaps.add((long)(positions[j] - positions[i]));
            }
        }
        return gaps;
    }
}
