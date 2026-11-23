// https://leetcode.com/problems/peeking-iterator/

// Solution: Cache Next Element — O(1) per operation, O(1) space
class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iter;
    private Integer peeked;

    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        peeked = iter.hasNext() ? iter.next() : null;
    }

    public Integer peek() {
        return peeked;
    }

    @Override
    public Integer next() {
        Integer val = peeked;
        peeked = iter.hasNext() ? iter.next() : null;
        return val;
    }

    @Override
    public boolean hasNext() {
        return peeked != null;
    }
}
