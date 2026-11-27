// https://leetcode.com/problems/unique-morse-code-words/

// Solution: Hash Set — O(n·L) time, O(n·L) space
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(morse[c - 'a']);
            }
            seen.add(sb.toString());
        }
        return seen.size();
    }
}
