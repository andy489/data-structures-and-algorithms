// https://leetcode.com/problems/repeated-dna-sequences/

// Solution 1: HashMap of substrings — O(n) time, O(n) space
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) return result;
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            seen.merge(sub, 1, Integer::sum);
            if (seen.get(sub) == 2) result.add(sub);
        }
        return result;
    }
}

// Solution 2: Bit-encoding rolling hash — O(n) time, O(n) space
class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        if (n <= 10) return result;
        int[] encode = new int[128];
        encode['A'] = 0; encode['C'] = 1; encode['G'] = 2; encode['T'] = 3;
        final int MASK = (1 << 20) - 1;
        int hash = 0;
        for (int i = 0; i < 10; i++) {
            hash = (hash << 2) | encode[s.charAt(i)];
        }
        Set<Integer> seen = new HashSet<>();
        Set<Integer> added = new HashSet<>();
        seen.add(hash);
        for (int i = 10; i < n; i++) {
            hash = ((hash << 2) | encode[s.charAt(i)]) & MASK;
            if (!seen.add(hash) && added.add(hash)) {
                result.add(s.substring(i - 9, i + 1));
            }
        }
        return result;
    }
}
