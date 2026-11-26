// https://leetcode.com/problems/number-of-atoms/

// Solution: Stack-based Parsing — O(n log n) time, O(n) space
class Solution {
    public String countOfAtoms(String formula) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        stack.push(new TreeMap<>());
        int i = 0, n = formula.length();
        while (i < n) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new TreeMap<>());
                i++;
            } else if (c == ')') {
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int mult = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                Map<String, Integer> top = stack.pop();
                for (Map.Entry<String, Integer> entry : top.entrySet()) {
                    stack.peek().merge(entry.getKey(), entry.getValue() * mult, Integer::sum);
                }
            } else if (Character.isUpperCase(c)) {
                int start = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String elem = formula.substring(start, i);
                int numStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = i > numStart ? Integer.parseInt(formula.substring(numStart, i)) : 1;
                stack.peek().merge(elem, count, Integer::sum);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
