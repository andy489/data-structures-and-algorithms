// https://leetcode.com/problems/candy/

// Solution 1: Two-Pass Greedy — O(n) time, O(n) space
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) candy[i] = candy[i - 1] + 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candy[i] = Math.max(candy[i], candy[i + 1] + 1);
        }
        int ans = 0;
        for (int c : candy) ans += c;
        return ans;
    }
}

// Solution 2: One-Pass Greedy — O(n) time, O(1) space
class Solution2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = 1, up = 0, down = 0, peak = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                down = 0;
                up++;
                peak = up;
                ans += up + 1;
            } else if (ratings[i] == ratings[i - 1]) {
                up = 0; down = 0; peak = 0;
                ans += 1;
            } else {
                up = 0;
                down++;
                ans += down + 1;
                if (down >= peak) ans++;
            }
        }
        return ans;
    }
}
