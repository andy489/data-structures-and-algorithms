// https://leetcode.com/problems/count-the-repetitions/

// Solution: Cycle Detection — O(|s1| · |s2|) time, O(|s2|) space
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int s2Index = 0;
        int s2Count = 0;
        // For each copy of s1 we finish, record (s2Index, s2Count so far)
        Map<Integer, int[]> stateToRound = new HashMap<>();
        int[] s2CountAtRound = new int[n1 + 1];

        for (int round = 0; round < n1; round++) {
            for (int i = 0; i < len1; i++) {
                if (s1.charAt(i) == s2.charAt(s2Index)) {
                    s2Index++;
                    if (s2Index == len2) {
                        s2Index = 0;
                        s2Count++;
                    }
                }
            }
            s2CountAtRound[round + 1] = s2Count;
            if (stateToRound.containsKey(s2Index)) {
                int prevRound = stateToRound.get(s2Index)[0];
                int prevCount = stateToRound.get(s2Index)[1];
                int cycleLen = round + 1 - prevRound;
                int cycleCount = s2Count - prevCount;
                int totalInCycles = ((n1 - prevRound) / cycleLen) * cycleCount;
                int remainder = (n1 - prevRound) % cycleLen;
                int totalS2 = prevCount + totalInCycles + (s2CountAtRound[prevRound + remainder] - prevCount);
                return totalS2 / n2;
            }
            stateToRound.put(s2Index, new int[]{round + 1, s2Count});
        }
        return s2Count / n2;
    }
}
