// https://leetcode.com/problems/implement-magic-dictionary/

// Solution: HashMap by Length + Compare — O(n·L) time, O(n·L) space
class MagicDictionary {
    private Map<Integer, List<String>> byLen = new HashMap<>();

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            byLen.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word);
        }
    }

    public boolean search(String searchWord) {
        List<String> candidates = byLen.getOrDefault(searchWord.length(), new ArrayList<>());
        for (String word : candidates) {
            int diff = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    diff++;
                }
                if (diff > 1) {
                    break;
                }
            }
            if (diff == 1) {
                return true;
            }
        }
        return false;
    }
}
