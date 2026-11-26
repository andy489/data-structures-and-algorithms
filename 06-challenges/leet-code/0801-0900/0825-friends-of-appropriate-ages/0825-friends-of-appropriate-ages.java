// https://leetcode.com/problems/friends-of-appropriate-ages/

// Solution: Counting Array — O(n) time, O(1) space
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            count[age]++;
        }
        int requests = 0;
        for (int a = 1; a <= 120; a++) {
            if (count[a] == 0) {
                continue;
            }
            for (int b = 1; b <= 120; b++) {
                if (count[b] == 0) {
                    continue;
                }
                if (b <= 0.5 * a + 7 || b > a || (b > 100 && a < 100)) {
                    continue;
                }
                requests += count[a] * count[b];
                if (a == b) {
                    requests -= count[a];
                }
            }
        }
        return requests;
    }
}
