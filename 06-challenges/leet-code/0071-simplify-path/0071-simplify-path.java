// https://leetcode.com/problems/simplify-path/

// Solution: Stack — O(n) time, O(n) space
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String component : path.split("/")) {
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            if (component.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(component);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.insert(0, "/" + dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
