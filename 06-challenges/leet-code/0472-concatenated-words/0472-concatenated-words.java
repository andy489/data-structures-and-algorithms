// https://leetcode.com/problems/concatenated-words/

// Solution: DP with WordSet — O(N * L^2) time, O(N * L) space
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>();
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            if (canForm(word, wordSet)) {
                result.add(word);
            }
            wordSet.add(word);
        }
        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        if (wordSet.isEmpty()) {
            return false;
        }
        int len = word.length();
        boolean[] reachable = new boolean[len + 1];
        reachable[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (reachable[j] && wordSet.contains(word.substring(j, i))) {
                    reachable[i] = true;
                    break;
                }
            }
        }
        return reachable[len];
    }
}
