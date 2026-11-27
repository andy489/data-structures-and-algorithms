// https://leetcode.com/problems/finding-3-digit-even-numbers/

// Solution: Enumerate — O(1) time, O(1) space
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) { freq[d]++; }
        List<Integer> res = new ArrayList<>();
        for (int num = 100; num <= 998; num += 2) {
            int[] used = new int[10];
            int tmp = num;
            while (tmp > 0) { used[tmp % 10]++; tmp /= 10; }
            boolean ok = true;
            for (int i = 0; i < 10; i++) { if (used[i] > freq[i]) { ok = false; break; } }
            if (ok) { res.add(num); }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
