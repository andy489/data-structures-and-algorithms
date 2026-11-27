// https://leetcode.com/problems/sequentially-ordinal-rank-tracker/

// Solution: Two Heaps — O(log n) per operation
class SORTracker {
    // left: max-heap of the best `queryCount` elements
    // Comparator: higher score is better; on tie, lexicographically smaller name is better
    // For max-heap we invert: score ascending (worse first), on tie name descending
    private PriorityQueue<int[]> left;   // stores [score, nameHash] — not ideal, use String[]
    private PriorityQueue<String[]> leftHeap;
    private PriorityQueue<String[]> rightHeap;

    // Better approach: use String[] {name, score_str} with custom comparators
    // left is a max-heap by "best": higher score, then lex-smaller name
    // right is a min-heap by "best": higher score, then lex-smaller name

    public SORTracker() {
        // right: min-heap — worst of the best half on top → easiest to move to left
        // We want the best location at the top of right, so we can move it to left on get()
        // right is ordered: best on top (max-heap semantics, but we implement as min-heap with inverted comparator)
        // Actually: right is a min-heap with natural "worse" ordering so right.peek() = best of right side
        rightHeap = new PriorityQueue<>((a, b) -> {
            int sa = Integer.parseInt(a[1]), sb = Integer.parseInt(b[1]);
            if (sa != sb) {
                return sb - sa; // higher score is better → put at top of min-heap inverted = max-heap
            }
            return a[0].compareTo(b[0]); // lex smaller is better
        });
        // left: max-heap storing the top queryCount elements
        // left.peek() = the queryCount-th best (worst of the best)
        leftHeap = new PriorityQueue<>((a, b) -> {
            int sa = Integer.parseInt(a[1]), sb = Integer.parseInt(b[1]);
            if (sa != sb) {
                return sa - sb; // lower score on top (worst of the best)
            }
            return b[0].compareTo(a[0]); // lex larger on top (worst of the best)
        });
    }

    public void add(String name, int score) {
        rightHeap.offer(new String[]{name, String.valueOf(score)});
        // balance: if right's best is better than left's worst, swap
        if (!leftHeap.isEmpty()) {
            String[] leftTop = leftHeap.peek();
            String[] rightTop = rightHeap.peek();
            int sl = Integer.parseInt(leftTop[1]), sr = Integer.parseInt(rightTop[1]);
            boolean rightBetter = sr > sl || (sr == sl && rightTop[0].compareTo(leftTop[0]) < 0);
            if (rightBetter) {
                leftHeap.poll();
                rightHeap.poll();
                leftHeap.offer(rightTop);
                rightHeap.offer(leftTop);
            }
        }
    }

    public String get() {
        // Move the best from right to left
        leftHeap.offer(rightHeap.poll());
        return leftHeap.peek()[0];
    }
}
