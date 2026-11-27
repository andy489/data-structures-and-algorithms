// https://leetcode.com/problems/find-and-replace-in-string/

// Solution: Index Mapping + Build — O(n·k) time, O(n+k) space
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> ops = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                ops.put(indices[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (ops.containsKey(i)) {
                int op = ops.get(i);
                sb.append(targets[op]);
                i += sources[op].length();
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
