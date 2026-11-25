// https://leetcode.com/problems/split-array-with-same-average/

// Solution: Meet in the Middle — O(2^(n/2)) time, O(2^(n/2)) space
class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, total = 0;
        for (int x : nums) {
            total += x;
        }
        boolean possible = false;
        for (int k = 1; k <= n / 2; k++) {
            if ((total * k) % n == 0) {
                possible = true;
                break;
            }
        }
        if (!possible) {
            return false;
        }
        int half = n / 2;
        List<Set<Integer>> left = new ArrayList<>();
        for (int i = 0; i <= half; i++) {
            left.add(new HashSet<>());
        }
        left.get(0).add(0);
        for (int i = 0; i < half; i++) {
            for (int k = i; k >= 0; k--) {
                for (int s : left.get(k)) {
                    left.get(k + 1).add(s + nums[i]);
                }
            }
        }
        for (int k = 1; k <= half; k++) {
            if ((total * k) % n == 0) {
                if (left.get(k).contains(total * k / n)) {
                    return true;
                }
            }
        }
        List<Set<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= n - half; i++) {
            right.add(new HashSet<>());
        }
        right.get(0).add(0);
        for (int i = half; i < n; i++) {
            for (int k = i - half; k >= 0; k--) {
                for (int s : right.get(k)) {
                    right.get(k + 1).add(s + nums[i]);
                }
            }
        }
        for (int k = 1; k < n - half; k++) {
            if ((total * k) % n == 0) {
                int need = total * k / n;
                if (right.get(k).contains(need)) {
                    return true;
                }
            }
        }
        for (int lk = 1; lk <= half; lk++) {
            for (int rk = 1; rk <= n - half; rk++) {
                int tk = lk + rk;
                if (tk > n / 2 || (total * tk) % n != 0) {
                    continue;
                }
                int need = total * tk / n;
                for (int ls : left.get(lk)) {
                    if (right.get(rk).contains(need - ls)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
