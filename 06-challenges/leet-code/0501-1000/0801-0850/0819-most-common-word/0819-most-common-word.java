// https://leetcode.com/problems/most-common-word/

// Solution: HashMap — O(n) time, O(n) space
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }
        Map<String, Integer> freq = new HashMap<>();
        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                freq.merge(word, 1, Integer::sum);
            }
        }
        return freq.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}
