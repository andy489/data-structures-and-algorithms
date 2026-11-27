// https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startMasks = new HashSet<>();
        for (String w : startWords) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            startMasks.add(mask);
        }
        int count = 0;
        for (String w : targetWords) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            // Try removing each bit
            for (int i = 0; i < 26; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (startMasks.contains(mask ^ (1 << i))) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
}
