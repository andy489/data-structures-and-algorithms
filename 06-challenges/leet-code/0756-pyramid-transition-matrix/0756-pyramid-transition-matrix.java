// https://leetcode.com/problems/pyramid-transition-matrix/

// Solution: DFS with Memoization — O(7^n) time, O(7^n) space
class Solution {
    private Map<String, List<Character>> rules;
    private Set<String> memo;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        rules = new HashMap<>();
        for (String s : allowed) {
            rules.computeIfAbsent(s.substring(0, 2), k -> new ArrayList<>()).add(s.charAt(2));
        }
        memo = new HashSet<>();
        return dfs(bottom, new StringBuilder());
    }

    private boolean dfs(String cur, StringBuilder next) {
        if (cur.length() == 1) {
            return true;
        }
        if (next.length() + 1 == cur.length()) {
            return dfs(next.toString(), new StringBuilder());
        }
        int idx = next.length();
        String pair = cur.substring(idx, idx + 2);
        List<Character> options = rules.getOrDefault(pair, Collections.emptyList());
        for (char c : options) {
            next.append(c);
            String key = cur + "#" + next.toString();
            if (!memo.contains(key)) {
                if (dfs(cur, next)) {
                    return true;
                }
                memo.add(key);
            }
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
}
