// https://leetcode.com/problems/word-break-ii/

// Solution 1: Memoized DFS (Top-Down) — O(n·2ⁿ) time, O(n·2ⁿ) space
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Map<Integer, List<String>> memo = new HashMap<>();
        return dfs(s, 0, words, memo);
    }

    private List<String> dfs(String s, int start, Set<String> words, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            res.add("");
            return res;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (words.contains(word)) {
                for (String rest : dfs(s, end, words, memo)) {
                    res.add(rest.isEmpty() ? word : word + " " + rest);
                }
            }
        }
        memo.put(start, res);
        return res;
    }
}

// Solution 2: Bottom-Up DP — O(n·2ⁿ) time, O(n·2ⁿ) space
class Solution2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) dp.add(new ArrayList<>());
        dp.get(0).add("");
        for (int i = 1; i <= n; i++) {
            for (String w : wordDict) {
                int len = w.length();
                if (i >= len && s.substring(i - len, i).equals(w)) {
                    for (String prev : dp.get(i - len)) {
                        dp.get(i).add(prev.isEmpty() ? w : prev + " " + w);
                    }
                }
            }
        }
        return dp.get(n);
    }
}
