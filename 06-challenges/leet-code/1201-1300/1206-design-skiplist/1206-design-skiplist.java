// https://leetcode.com/problems/design-skiplist/

// Solution: Skiplist with Random Levels — O(log n) expected time, O(n log n) space
// Solution: Skiplist with Random Levels — O(log n) expected time, O(n log n) space
class Skiplist {
    private static final int MAX_LEVEL = 16;
    private static final double P = 0.5;
    private final int[] forward;
    private final Node head;
    private final Random rand = new Random();

    static class Node {
        int val;
        Node[] next;
        Node(int val, int level) { this.val = val; next = new Node[level]; }
    }

    public Skiplist() { head = new Node(-1, MAX_LEVEL); forward = new int[MAX_LEVEL]; }

    private int randomLevel() {
        int level = 1;
        while (rand.nextDouble() < P && level < MAX_LEVEL) level++;
        return level;
    }

    public boolean search(int target) {
        Node cur = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < target) cur = cur.next[i];
        }
        return cur.next[0] != null && cur.next[0].val == target;
    }

    public void add(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) cur = cur.next[i];
            update[i] = cur;
        }
        int level = randomLevel();
        Node node = new Node(num, level);
        for (int i = 0; i < level; i++) { node.next[i] = update[i].next[i]; update[i].next[i] = node; }
    }

    public boolean erase(int num) {
        Node[] update = new Node[MAX_LEVEL];
        Node cur = head;
        for (int i = MAX_LEVEL - 1; i >= 0; i--) {
            while (cur.next[i] != null && cur.next[i].val < num) cur = cur.next[i];
            update[i] = cur;
        }
        if (cur.next[0] == null || cur.next[0].val != num) return false;
        Node target = cur.next[0];
        for (int i = 0; i < MAX_LEVEL && update[i].next[i] == target; i++) update[i].next[i] = target.next[i];
        return true;
    }
}
