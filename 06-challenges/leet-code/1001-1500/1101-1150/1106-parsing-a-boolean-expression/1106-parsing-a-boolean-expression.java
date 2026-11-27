// https://leetcode.com/problems/parsing-a-boolean-expression/

// Solution: Stack-Based Parsing — O(n) time, O(n) space
class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') {
                continue;
            }
            if (c != ')') {
                stack.push(c);
            } else {
                List<Character> vals = new ArrayList<>();
                while (stack.peek() != '(') {
                    vals.add(stack.pop());
                }
                stack.pop(); // remove '('
                char op = stack.pop();
                char result;
                if (op == '!') {
                    result = vals.get(0) == 't' ? 'f' : 't';
                } else if (op == '&') {
                    result = vals.contains('f') ? 'f' : 't';
                } else { // '|'
                    result = vals.contains('t') ? 't' : 'f';
                }
                stack.push(result);
            }
        }
        return stack.pop() == 't';
    }
}


// Solution2: Recursive Parsing — O(n) time, O(n) space
class Solution2 {
    private int i = 0;

    public boolean parseBoolExpr(String expression) {
        i = 0;
        return parse(expression);
    }

    private boolean parse(String s) {
        char c = s.charAt(i++);
        if (c == 't') {
            return true;
        }
        if (c == 'f') {
            return false;
        }
        boolean result;
        i++; // skip '('
        if (c == '!') {
            result = !parse(s);
        } else if (c == '&') {
            result = true;
            do {
                result &= parse(s);
            } while (s.charAt(i++) == ',');
            return result; // already consumed ')'
        } else { // '|'
            result = false;
            do {
                result |= parse(s);
            } while (s.charAt(i++) == ',');
            return result; // already consumed ')'
        }
        i++; // skip ')'
        return result;
    }
}
