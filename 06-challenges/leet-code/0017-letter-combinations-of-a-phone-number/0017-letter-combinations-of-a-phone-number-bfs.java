// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// bfs
// Time: O(4^n), where n is the number of digits

class Solution {
    private final String[] pad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        Queue<String> q = new LinkedList<>();
        q.add("");

        for (char d : digits.toCharArray()) {
            int size = q.size();

            while (size-- > 0) {
                String cur = q.remove();

                for (char c : pad[d - '2'].toCharArray()) {
                    q.add(cur + c);
                }
            }
        }

        res.addAll(q);
        
        return res;
    }
}
