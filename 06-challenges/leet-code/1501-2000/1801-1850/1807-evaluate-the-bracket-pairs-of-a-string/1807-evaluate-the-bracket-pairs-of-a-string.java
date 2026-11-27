// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

// Solution: HashMap Lookup — O(n + k) time, O(n + k) space
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dict = new HashMap<>();
        for (List<String> pair : knowledge) {
            dict.put(pair.get(0), pair.get(1));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();
        while (i < n) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i);
                String key = s.substring(i + 1, j);
                sb.append(dict.getOrDefault(key, "?"));
                i = j + 1;
            } else {
                sb.append(s.charAt(i++));
            }
        }
        return sb.toString();
    }
}
