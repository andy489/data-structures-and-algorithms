// https://leetcode.com/problems/sort-characters-by-frequency/

// Solution: Frequency Map + Bucket Sort — O(n) time, O(n) space
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        @SuppressWarnings("unchecked")
        List<Character>[] buckets = new List[s.length() + 1];
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                if (buckets[freq[i]] == null) {
                    buckets[freq[i]] = new ArrayList<>();
                }
                buckets[freq[i]].add((char) i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int f = s.length(); f >= 1; f--) {
            if (buckets[f] != null) {
                for (char c : buckets[f]) {
                    for (int k = 0; k < f; k++) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
