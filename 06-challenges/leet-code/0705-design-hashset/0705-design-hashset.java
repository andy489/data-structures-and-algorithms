// https://leetcode.com/problems/design-hashset/

// Solution: Array of Linked Lists (Chaining) — O(n/b) avg per op, O(n+b) space
class MyHashSet {
    private static final int BUCKETS = 769;
    private final LinkedList<Integer>[] data;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        data = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void add(int key) {
        int h = hash(key);
        if (!data[h].contains(key)) {
            data[h].add(key);
        }
    }

    public void remove(int key) {
        data[hash(key)].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        return data[hash(key)].contains(key);
    }
}
