// https://leetcode.com/problems/vowel-spellchecker/

// Solution: Three Maps — O(n+q) time, O(n) space
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>();
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        for (String w : wordlist) {
            exact.add(w);
            String lower = w.toLowerCase();
            lowerMap.putIfAbsent(lower, w);
            vowelMap.putIfAbsent(maskVowels(lower), w);
        }
        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                res[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (lowerMap.containsKey(lower)) {
                    res[i] = lowerMap.get(lower);
                } else {
                    res[i] = vowelMap.getOrDefault(maskVowels(lower), "");
                }
            }
        }
        return res;
    }

    private String maskVowels(String s) {
        return s.replaceAll("[aeiou]", "*");
    }
}
