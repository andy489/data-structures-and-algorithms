// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

// Solution: HashMap<val, Set<idx>> + List — O(1) average time, O(n) space
class RandomizedCollection {
    private final Map<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
    private final List<Integer> list = new ArrayList<>();
    private final Random rand = new Random();

    public boolean insert(int val) {
        boolean absent = !map.containsKey(val) || map.get(val).isEmpty();
        map.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size());
        list.add(val);
        return absent;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) {
            return false;
        }
        int idx = map.get(val).iterator().next();
        map.get(val).remove(idx);

        int last = list.get(list.size() - 1);
        if (idx < list.size() - 1) {
            list.set(idx, last);
            map.get(last).remove(list.size() - 1);
            map.get(last).add(idx);
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
