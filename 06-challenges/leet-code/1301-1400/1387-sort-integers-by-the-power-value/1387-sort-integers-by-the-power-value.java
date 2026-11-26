// https://leetcode.com/problems/sort-integers-by-the-power-value/

// Solution: Memoization + Sort — O(n * steps) time, O(n) space
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) list.add(new int[]{power(i), i});
        list.sort((a, b) -> a[0] != b[0] ? a[0]-b[0] : a[1]-b[1]);
        return list.get(k-1)[1];
    }
    private int power(int x) {
        if (x == 1) return 0;
        if (memo.containsKey(x)) return memo.get(x);
        int p = 1 + power(x % 2 == 0 ? x/2 : 3*x+1);
        memo.put(x, p);
        return p;
    }
}
