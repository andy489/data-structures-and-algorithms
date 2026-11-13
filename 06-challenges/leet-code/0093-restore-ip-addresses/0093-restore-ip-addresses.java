// https://leetcode.com/problems/restore-ip-addresses/

// Solution: Backtracking — O(1) time, O(1) space
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> parts, List<String> result) {
        if (parts.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }
        int remaining = s.length() - start;
        int segmentsLeft = 4 - parts.size();
        if (remaining < segmentsLeft || remaining > segmentsLeft * 3) {
            return;
        }
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String seg = s.substring(start, start + len);
            if (seg.length() > 1 && seg.charAt(0) == '0') break;
            if (Integer.parseInt(seg) > 255) break;
            parts.add(seg);
            backtrack(s, start + len, parts, result);
            parts.remove(parts.size() - 1);
        }
    }
}
