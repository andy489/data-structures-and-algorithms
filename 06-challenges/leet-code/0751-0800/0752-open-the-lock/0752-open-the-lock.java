// https://leetcode.com/problems/open-the-lock/

// Solution: BFS — O(10^4) time, O(10^4) space
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if (dead.contains("0000")) {
            return -1;
        }
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int d = 0; d < 4; d++) {
                    for (int delta : new int[]{1, -1}) {
                        char orig = chars[d];
                        chars[d] = (char) ((orig - '0' + delta + 10) % 10 + '0');
                        String next = new String(chars);
                        if (next.equals(target)) {
                            return steps;
                        }
                        if (!visited.contains(next) && !dead.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                        chars[d] = orig;
                    }
                }
            }
        }
        return -1;
    }
}
