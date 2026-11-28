// https://leetcode.com/problems/find-words-containing-character/

// Solution: Linear Scan — O(n*m) time, O(1) extra space
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) >= 0) {
                result.add(i);
            }
        }
        return result;
    }
}
