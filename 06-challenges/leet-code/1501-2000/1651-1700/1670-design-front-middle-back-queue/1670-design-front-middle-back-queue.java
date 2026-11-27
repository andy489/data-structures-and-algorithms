// https://leetcode.com/problems/design-front-middle-back-queue/

// Solution: Two Deques — O(1) per operation, O(n) space
class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    private void balance() {
        if (left.size() > right.size()) {
            right.addFirst(left.pollLast());
        } else if (right.size() > left.size() + 1) {
            left.addLast(right.pollFirst());
        }
    }

    public void pushFront(int val) {
        left.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {
        if (left.size() == right.size()) {
            right.addFirst(val);
        } else {
            left.addLast(val);
        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        balance();
    }

    public int popFront() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        int val = left.isEmpty() ? right.pollFirst() : left.pollFirst();
        balance();
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty() && right.isEmpty()) {
            return -1;
        }
        int val = (left.size() == right.size()) ? left.pollLast() : right.pollFirst();
        return val;
    }

    public int popBack() {
        if (right.isEmpty()) {
            return -1;
        }
        int val = right.pollLast();
        balance();
        return val;
    }
}
