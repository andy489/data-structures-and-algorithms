// https://leetcode.com/problems/insert-delete-getrandom-o1/

// Solution: HashMap + ArrayList — O(1) average time, O(n) space
class RandomizedSet {
    private final Map<Integer, Integer> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random rand = new Random();

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idx = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        map.put(last, idx);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
