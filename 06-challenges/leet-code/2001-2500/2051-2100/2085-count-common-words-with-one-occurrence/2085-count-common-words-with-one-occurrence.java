// https://leetcode.com/problems/count-common-words-with-one-occurrence/

// Solution: Frequency Count — O(n + m) time, O(n + m) space
class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> freq1 = new HashMap<>(), freq2 = new HashMap<>();
        for (String w : words1) { freq1.merge(w, 1, Integer::sum); }
        for (String w : words2) { freq2.merge(w, 1, Integer::sum); }
        int count = 0;
        for (String w : freq1.keySet()) {
            if (freq1.get(w) == 1 && freq2.getOrDefault(w, 0) == 1) { count++; }
        }
        return count;
    }
}
