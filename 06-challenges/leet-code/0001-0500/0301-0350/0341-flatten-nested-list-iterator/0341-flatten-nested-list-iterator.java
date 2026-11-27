// https://leetcode.com/problems/flatten-nested-list-iterator/

// Solution 1: Eager Flattening — O(n) build, O(1) next/hasNext
class NestedIterator implements Iterator<Integer> {
    private final List<Integer> flat = new ArrayList<>();
    private int idx = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        flatten(nestedList);
    }

    private void flatten(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                flat.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return flat.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < flat.size();
    }
}
