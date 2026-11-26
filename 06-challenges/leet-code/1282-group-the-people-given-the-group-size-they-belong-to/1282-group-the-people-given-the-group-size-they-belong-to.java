// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

// Solution: HashMap Grouping — O(n) time, O(n) space
// Solution: HashMap Grouping — O(n) time, O(n) space
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> pending = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int sz = groupSizes[i];
            pending.computeIfAbsent(sz, k -> new ArrayList<>()).add(i);
            if (pending.get(sz).size() == sz) {
                res.add(new ArrayList<>(pending.get(sz)));
                pending.get(sz).clear();
            }
        }
        return res;
    }
}
