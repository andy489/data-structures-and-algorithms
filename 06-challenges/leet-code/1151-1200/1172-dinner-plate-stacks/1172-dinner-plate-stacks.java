// https://leetcode.com/problems/dinner-plate-stacks/

// Solution: Min-Heap for Available + Right Pointer — O(log n) per operation amortized
class DinnerPlates {
    private List<Deque<Integer>> stacks;
    private PriorityQueue<Integer> available; // min-heap of indices with space
    private int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        available = new PriorityQueue<>();
    }

    public void push(int val) {
        // Remove stale indices from heap
        while (!available.isEmpty() && available.peek() < stacks.size()
                && stacks.get(available.peek()).size() >= capacity) {
            available.poll();
        }
        int idx;
        if (available.isEmpty()) {
            idx = stacks.size();
            stacks.add(new ArrayDeque<>());
        } else {
            idx = available.peek();
            if (stacks.get(idx).size() + 1 == capacity) {
                available.poll(); // now full after this push
            }
        }
        stacks.get(idx).push(val);
        if (idx == stacks.size() - 1 && stacks.get(idx).isEmpty()) {
            // shouldn't happen but guard
        }
    }

    public int pop() {
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        if (stacks.isEmpty()) {
            return -1;
        }
        int idx = stacks.size() - 1;
        int val = stacks.get(idx).pop();
        available.offer(idx);
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }

    public int popAtStack(int index) {
        if (index >= stacks.size() || stacks.get(index).isEmpty()) {
            return -1;
        }
        int val = stacks.get(index).pop();
        available.offer(index);
        while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return val;
    }
}
