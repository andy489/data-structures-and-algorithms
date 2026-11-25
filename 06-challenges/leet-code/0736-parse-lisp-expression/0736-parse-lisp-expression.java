// https://leetcode.com/problems/parse-lisp-expression/

// Solution: Recursive Descent with Scope Stack — O(n²) time, O(n) space
class Solution {
    private String expr;
    private int idx;

    public int evaluate(String expression) {
        expr = expression;
        idx = 0;
        return parse(new HashMap<>());
    }

    private int parse(Map<String, Integer> scope) {
        if (expr.charAt(idx) == '(') {
            idx++; // skip '('
            int result;
            if (expr.startsWith("let", idx)) {
                idx += 3;
                Map<String, Integer> localScope = new HashMap<>(scope);
                while (true) {
                    idx++; // skip space
                    if (expr.charAt(idx) == '(' || Character.isDigit(expr.charAt(idx))
                            || expr.charAt(idx) == '-') {
                        result = parse(localScope);
                        break;
                    }
                    int start = idx;
                    while (idx < expr.length() && expr.charAt(idx) != ' ' && expr.charAt(idx) != ')') {
                        idx++;
                    }
                    String varName = expr.substring(start, idx);
                    if (expr.charAt(idx) == ')') {
                        result = localScope.getOrDefault(varName, scope.getOrDefault(varName, 0));
                        break;
                    }
                    idx++; // skip space
                    int val = parse(localScope);
                    localScope.put(varName, val);
                }
            } else if (expr.startsWith("add", idx)) {
                idx += 3;
                idx++; // skip space
                int a = parse(scope);
                idx++; // skip space
                int b = parse(scope);
                result = a + b;
            } else {
                idx += 4; // "mult"
                idx++; // skip space
                int a = parse(scope);
                idx++; // skip space
                int b = parse(scope);
                result = a * b;
            }
            idx++; // skip ')'
            return result;
        } else if (Character.isDigit(expr.charAt(idx)) || expr.charAt(idx) == '-') {
            int start = idx;
            if (expr.charAt(idx) == '-') {
                idx++;
            }
            while (idx < expr.length() && Character.isDigit(expr.charAt(idx))) {
                idx++;
            }
            return Integer.parseInt(expr.substring(start, idx));
        } else {
            int start = idx;
            while (idx < expr.length() && expr.charAt(idx) != ' ' && expr.charAt(idx) != ')') {
                idx++;
            }
            String varName = expr.substring(start, idx);
            return scope.getOrDefault(varName, 0);
        }
    }
}
