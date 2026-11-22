// https://leetcode.com/problems/implement-queue-using-stacks/

// Solution: Two Stacks, Lazy Transfer — Amortized O(1) per operation
class MyQueue {
    private final Deque<Integer> inbox = new ArrayDeque<>();
    private final Deque<Integer> outbox = new ArrayDeque<>();

    public void push(int x) {
        inbox.push(x);
    }

    public int pop() {
        transfer();
        return outbox.pop();
    }

    public int peek() {
        transfer();
        return outbox.peek();
    }

    public boolean empty() {
        return inbox.isEmpty() && outbox.isEmpty();
    }

    private void transfer() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
    }
}
