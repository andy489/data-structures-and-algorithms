// https://leetcode.com/problems/lfu-cache/

// Solution: HashMap + LinkedHashSet per Frequency — O(1) time, O(capacity) space
class LFUCache {
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToVal;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        incrementFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            incrementFreq(key);
            return;
        }
        if (keyToVal.size() >= capacity) {
            evict();
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void incrementFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    private void evict() {
        LinkedHashSet<Integer> minFreqKeys = freqToKeys.get(minFreq);
        int evictKey = minFreqKeys.iterator().next();
        minFreqKeys.remove(evictKey);
        if (minFreqKeys.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToVal.remove(evictKey);
        keyToFreq.remove(evictKey);
    }
}
