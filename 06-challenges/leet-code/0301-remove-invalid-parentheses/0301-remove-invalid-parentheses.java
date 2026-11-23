// https://leetcode.com/problems/remove-invalid-parentheses/

// Solution 1: BFS — O(2^n) time, O(2^n) space
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q = 0; q < size; q++) {
                String cur = queue.poll();
                if (isValid(cur)) {
                    result.add(cur);
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int i = 0; i < cur.length(); i++) {
                    if (cur.charAt(i) != '(' && cur.charAt(i) != ')') {
                        continue;
                    }
                    String next = cur.substring(0, i) + cur.substring(i + 1);
                    if (visited.add(next)) {
                        queue.offer(next);
                    }
                }
            }
            if (found) {
                break;
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (--count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}

// Solution 2: DFS with Counting — O(2^n) time, O(n) space
class Solution2 {
    public List<String> removeInvalidParentheses(String s) {
        int leftRem = 0, rightRem = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftRem++;
            } else if (c == ')') {
                if (leftRem > 0) {
                    leftRem--;
                } else {
                    rightRem++;
                }
            }
        }
        Set<String> result = new HashSet<>();
        dfs(s, 0, leftRem, rightRem, 0, new StringBuilder(), result);
        return new ArrayList<>(result);
    }

    private void dfs(String s, int idx, int leftRem, int rightRem, int open, StringBuilder sb, Set<String> result) {
        if (idx == s.length()) {
            if (leftRem == 0 && rightRem == 0 && open == 0) {
                result.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(' && leftRem > 0) {
            dfs(s, idx + 1, leftRem - 1, rightRem, open, sb, result);
        }
        if (c == ')' && rightRem > 0) {
            dfs(s, idx + 1, leftRem, rightRem - 1, open, sb, result);
        }
        sb.append(c);
        if (c == '(') {
            dfs(s, idx + 1, leftRem, rightRem, open + 1, sb, result);
        } else if (c == ')') {
            if (open > 0) {
                dfs(s, idx + 1, leftRem, rightRem, open - 1, sb, result);
            }
        } else {
            dfs(s, idx + 1, leftRem, rightRem, open, sb, result);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}
