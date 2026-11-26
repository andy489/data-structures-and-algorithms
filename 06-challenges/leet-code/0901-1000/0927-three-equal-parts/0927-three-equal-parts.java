// https://leetcode.com/problems/three-equal-parts/

// Solution: Find Positions of Ones — O(n) time, O(n) space
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int n = arr.length;
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        if (total % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (total == 0) {
            return new int[]{0, 2};
        }
        int each = total / 3;
        int i1 = -1, i2 = -1, i3 = -1, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                if (cnt == 1) { i1 = i; }
                if (cnt == each + 1) { i2 = i; }
                if (cnt == 2 * each + 1) { i3 = i; }
            }
        }
        while (i3 < n && arr[i1] == arr[i2] && arr[i2] == arr[i3]) {
            i1++;
            i2++;
            i3++;
        }
        if (i3 == n) {
            return new int[]{i1 - 1, i2};
        }
        return new int[]{-1, -1};
    }
}
