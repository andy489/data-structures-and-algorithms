// https://leetcode.com/problems/longest-happy-string/

// Solution: Greedy Max-Heap — O(n log 3) = O(n) time, O(1) space
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0) pq.offer(new int[]{a, 'a'});
        if (b > 0) pq.offer(new int[]{b, 'b'});
        if (c > 0) pq.offer(new int[]{c, 'c'});
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n-1) == top[1] && sb.charAt(n-2) == top[1]) {
                if (pq.isEmpty()) break;
                int[] sec = pq.poll();
                sb.append((char) sec[1]);
                if (--sec[0] > 0) pq.offer(sec);
                pq.offer(top);
            } else {
                sb.append((char) top[1]);
                if (--top[0] > 0) pq.offer(top);
            }
        }
        return sb.toString();
    }
}
