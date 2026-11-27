// https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

// Solution: Bitmask + Subset Enumeration — O(w × L + p × 2^7) time, O(w) space
class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }
            freq.merge(mask, 1, Integer::sum);
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int puzzleMask = 0;
            for (char c : puzzle.toCharArray()) {
                puzzleMask |= (1 << (c - 'a'));
            }
            int firstBit = 1 << (puzzle.charAt(0) - 'a');
            int count = 0;
            for (int sub = puzzleMask; sub > 0; sub = (sub - 1) & puzzleMask) {
                if ((sub & firstBit) != 0) {
                    count += freq.getOrDefault(sub, 0);
                }
            }
            result.add(count);
        }
        return result;
    }
}
