// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// linked list, iterative
// Time: O(4^n), where n is the number of digits

class Solution {
    private final String[] pad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
       
        if (digits.isEmpty()) {
            return res;
        }
        
        String w = "";
        res.add(w);
        
        while (res.peek().length() != digits.length()) {
            String top = res.remove();
            String symbols = pad[digits.charAt(top.length()) - '2'];
           
            for (char c : symbols.toCharArray()) {
                res.addLast(top + c);
            }
        }
        
        return res;
    }
}
