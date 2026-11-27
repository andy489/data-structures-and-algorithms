// https://leetcode.com/problems/pass-the-pillow/

class Solution {
    public int passThePillow(int n, int time) {
        int cycle = 2 * (n - 1);
        time = time % cycle;
        if (time < n) {
            return time + 1;
        } else {
            return cycle - time + 1;
        }
    }
}
