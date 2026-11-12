// https://leetcode.com/problems/group-anagrams/

// Solution: Sort-key hash map — O(n · k log k) time, O(n · k) space
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            grouped.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(grouped.values());
    }
}

// Solution2: Frequency-count key hash map — O(n · k) time, O(n · k) space
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> grouped = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int freq : count) {
                sb.append('#').append(freq);
            }
            String key = sb.toString();
            grouped.computeIfAbsent(key, x -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(grouped.values());
    }
}
