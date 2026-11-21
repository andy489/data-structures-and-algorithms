// https://leetcode.com/problems/word-ladder-ii/

// Solution: BFS DAG + DFS Backtrack — O(n·L·26 + P) time, O(n·L) space
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();
        if (!wordSet.contains(endWord)) return ans;

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(beginWord);
        boolean found = false;

        while (!currentLevel.isEmpty() && !found) {
            wordSet.removeAll(currentLevel);
            Set<String> nextLevel = new HashSet<>();
            for (String word : currentLevel) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        chars[i] = c;
                        String next = new String(chars);
                        if (wordSet.contains(next)) {
                            nextLevel.add(next);
                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            if (next.equals(endWord)) found = true;
                        }
                        chars[i] = original;
                    }
                }
            }
            currentLevel = nextLevel;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parents, path, ans);
        }
        return ans;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> parents,
                     List<String> path, List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            ans.add(copy);
            return;
        }
        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
