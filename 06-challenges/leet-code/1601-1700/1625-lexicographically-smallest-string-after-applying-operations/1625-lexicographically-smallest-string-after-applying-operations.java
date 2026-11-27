// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/

// Solution: BFS with Visited Set — O(states * n) time, O(states * n) space
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        visited.add(s);
        String ans = s;
        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(ans) < 0) {
                ans = cur;
            }
            String added = addOdd(cur, a);
            String rotated = rotate(cur, b);
            if (visited.add(added)) {
                q.offer(added);
            }
            if (visited.add(rotated)) {
                q.offer(rotated);
            }
        }
        return ans;
    }

    private String addOdd(String s, int a) {
        char[] ch = s.toCharArray();
        for (int i = 1; i < ch.length; i += 2) {
            ch[i] = (char) ('0' + (ch[i] - '0' + a) % 10);
        }
        return new String(ch);
    }

    private String rotate(String s, int b) {
        int n = s.length();
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
