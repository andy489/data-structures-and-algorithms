// https://leetcode.com/problems/queue-reconstruction-by-height/

// Solution: Sort then Insert — O(n²) time, O(n) space
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) {
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][]);
    }
}
