// https://leetcode.com/problems/palindrome-pairs/

// Solution: HashMap + All Splits — O(n * k²) time, O(n * k) space
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> wordIndex = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordIndex.put(words[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int len = w.length();
            for (int k = 0; k <= len; k++) {
                String prefix = w.substring(0, k);
                String suffix = w.substring(k);
                if (isPalin(prefix)) {
                    String revSuffix = new StringBuilder(suffix).reverse().toString();
                    Integer j = wordIndex.get(revSuffix);
                    if (j != null && j != i) {
                        result.add(List.of(j, i));
                    }
                }
                if (k != len && isPalin(suffix)) {
                    String revPrefix = new StringBuilder(prefix).reverse().toString();
                    Integer j = wordIndex.get(revPrefix);
                    if (j != null && j != i) {
                        result.add(List.of(i, j));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}
