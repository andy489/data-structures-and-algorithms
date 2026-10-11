// https://leetcode.com/problems/valid-parentheses/

class Solution {
    bool pair(char l, char r) {
        if (l == '(' && r == ')') {
            return true;
        }

        if (l == '[' && r == ']') {
            return true;
        }

        if (l == '{' && r == '}') {
            return true;
        }

        return false;
    }

public:
    bool isValid(string s) {
        stack<char> stack;
        for (char c: s) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.empty() || !pair(stack.top(), c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }
};