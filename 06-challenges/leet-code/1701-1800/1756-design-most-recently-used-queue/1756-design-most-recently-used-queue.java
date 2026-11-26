// https://leetcode.com/problems/design-most-recently-used-queue/

// Solution: ArrayList — O(n) per fetch, O(n) space
class MRUQueue {
    private List<Integer> queue;

    public MRUQueue(int n) {
        queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }

    public int fetch(int k) {
        int val = queue.remove(k - 1);
        queue.add(val);
        return val;
    }
}
