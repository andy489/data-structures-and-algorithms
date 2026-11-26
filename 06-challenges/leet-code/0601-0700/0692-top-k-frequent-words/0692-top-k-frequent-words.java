// https://leetcode.com/problems/top-k-frequent-words/

// Solution: HashMap + Sort — O(n log n) time, O(n) space
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }
        List<String> candidates = new ArrayList<>(freq.keySet());
        candidates.sort((a, b) -> {
            int diff = freq.get(b) - freq.get(a);
            return diff != 0 ? diff : a.compareTo(b);
        });
        return candidates.subList(0, k);
    }
}
