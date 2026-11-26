// https://leetcode.com/problems/ambiguous-coordinates/

// Solution: Enumeration — O(n³) time, O(n³) space
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String digits = s.substring(1, s.length() - 1);
        List<String> result = new ArrayList<>();
        for (int i = 1; i < digits.length(); i++) {
            List<String> left = generate(digits.substring(0, i));
            List<String> right = generate(digits.substring(i));
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        return result;
    }

    private List<String> generate(String s) {
        List<String> res = new ArrayList<>();
        if (!s.startsWith("0") || s.equals("0")) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String decimal = s.substring(0, i) + "." + s.substring(i);
            if (!decimal.startsWith("0") || decimal.startsWith("0.")) {
                if (!decimal.endsWith("0")) {
                    res.add(decimal);
                }
            }
        }
        return res;
    }
}
