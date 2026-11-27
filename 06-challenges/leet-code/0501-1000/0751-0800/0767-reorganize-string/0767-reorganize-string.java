// https://leetcode.com/problems/reorganize-string/

// Solution: Max-Heap Greedy — O(n log k) time, O(k) space
class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{freq[i], i});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] first = pq.poll();
            int[] second = pq.poll();
            sb.append((char) ('a' + first[1]));
            sb.append((char) ('a' + second[1]));
            if (--first[0] > 0) {
                pq.offer(first);
            }
            if (--second[0] > 0) {
                pq.offer(second);
            }
        }
        if (!pq.isEmpty()) {
            if (pq.peek()[0] > 1) {
                return "";
            }
            sb.append((char) ('a' + pq.poll()[1]));
        }
        return sb.toString();
    }
}
