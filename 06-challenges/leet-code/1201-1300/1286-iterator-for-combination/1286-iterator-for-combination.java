// https://leetcode.com/problems/iterator-for-combination/

// Solution: Precompute All Combinations — O(2^n * n) init, O(1) query time, O(C(n,k)) space
// Solution: Precompute All Combinations — O(2^n*n) init, O(1) query time, O(C(n,k)) space
class CombinationIterator {
    private List<String> combos = new ArrayList<>();
    private int idx = 0;
    public CombinationIterator(String characters, int combinationLength) {
        int n = characters.length();
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) == combinationLength) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) if ((mask >> (n-1-i) & 1) == 1) sb.append(characters.charAt(i));
                combos.add(sb.toString());
            }
        }
    }
    public String next() { return combos.get(idx++); }
    public boolean hasNext() { return idx < combos.size(); }
}
