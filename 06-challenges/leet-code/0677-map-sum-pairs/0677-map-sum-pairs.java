// https://leetcode.com/problems/map-sum-pairs/

// Solution: HashMap — O(n·L) sum time, O(n·L) space
class MapSum {
    private Map<String, Integer> store = new HashMap<>();

    public void insert(String key, int val) {
        store.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : store.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                total += entry.getValue();
            }
        }
        return total;
    }
}
