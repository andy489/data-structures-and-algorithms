// https://leetcode.com/problems/longest-subsequence-repeated-k-times/

// Solution: BFS on Candidates — O(n * L^2) time, O(L!) space
class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) { freq[c - 'a']++; }
        List<Character> cands = new ArrayList<>();
        for (int i = 0; i < 26; i++) { if (freq[i] >= k) { cands.add((char)('a' + i)); } }
        String res = "";
        Queue<String> q = new LinkedList<>();
        q.offer("");
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (char c : cands) {
                String next = cur + c;
                if (isSubseqRepeated(s, next, k)) {
                    if (next.length() > res.length() || (next.length() == res.length() && next.compareTo(res) > 0)) {
                        res = next;
                    }
                    q.offer(next);
                }
            }
        }
        return res;
    }
    private boolean isSubseqRepeated(String s, String t, int k) {
        int ti = 0, repeat = 0;
        for (char c : s.toCharArray()) {
            if (c == t.charAt(ti)) {
                ti++;
                if (ti == t.length()) { ti = 0; repeat++; if (repeat == k) { return true; } }
            }
        }
        return false;
    }
}
