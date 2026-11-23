// https://leetcode.com/problems/random-flip-matrix/

class Solution {
    private int m, n, remaining;
    private Map<Integer, Integer> remapped;
    private Random rand;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.remaining = m * n;
        this.remapped = new HashMap<>();
        this.rand = new Random();
    }

    public int[] flip() {
        int r = rand.nextInt(remaining--);
        int actual = remapped.getOrDefault(r, r);
        remapped.put(r, remapped.getOrDefault(remaining, remaining));
        return new int[]{actual / n, actual % n};
    }

    public void reset() {
        remaining = m * n;
        remapped.clear();
    }
}
