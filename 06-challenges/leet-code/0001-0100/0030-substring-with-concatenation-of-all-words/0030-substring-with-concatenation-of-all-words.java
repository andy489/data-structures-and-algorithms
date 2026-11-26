// https://leetcode.com/problems/substring-with-concatenation-of-all-words/

// Solution: Sliding Window with Frequency Maps — O(n · k) time, O(k) space
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), k = words.length, w = words[0].length();

        Map<String, Integer> need = new HashMap<>();
        for (String word : words) {
            need.merge(word, 1, Integer::sum);
        }

        for (int i = 0; i < w; i++) {
            Map<String, Integer> have = new HashMap<>();
            int left = i, matched = 0;

            for (int right = i; right + w <= n; right += w) {
                String cur = s.substring(right, right + w);

                if (!need.containsKey(cur)) {
                    have.clear();
                    matched = 0;
                    left = right + w;
                    continue;
                }

                have.merge(cur, 1, Integer::sum);
                if (have.get(cur).equals(need.get(cur))) matched++;

                while (have.get(cur) > need.get(cur)) {
                    String leftWord = s.substring(left, left + w);
                    if (have.get(leftWord).equals(need.get(leftWord))) matched--;
                    have.merge(leftWord, -1, Integer::sum);
                    left += w;
                }

                if (matched == need.size()) result.add(left);
            }
        }
        return result;
    }
}
