// https://leetcode.com/problems/design-hashmap/

// Solution: Array of Linked Lists (Chaining) — O(n/b) avg per op, O(n+b) space
class MyHashMap {
    private static final int BUCKETS = 769;
    private final LinkedList<int[]>[] data;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        data = new LinkedList[BUCKETS];
        for (int i = 0; i < BUCKETS; i++) {
            data[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % BUCKETS;
    }

    public void put(int key, int value) {
        int h = hash(key);
        for (int[] pair : data[h]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        data[h].add(new int[]{key, value});
    }

    public int get(int key) {
        for (int[] pair : data[hash(key)]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        data[h].removeIf(pair -> pair[0] == key);
    }
}
