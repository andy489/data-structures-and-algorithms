// https://leetcode.com/problems/magical-string/

// Solution: Self-Generation — O(N) time, O(N) space
class Solution {
    public int magicalString(int n) {
        if (n <= 3) {
            return 1;
        }
        int[] magic = new int[n];
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;
        int head = 2;
        int tail = 3;
        int nextDigit = 1;
        int onesCount = 1;

        while (tail < n) {
            int copies = magic[head];
            for (int i = 0; i < copies && tail < n; i++) {
                magic[tail] = nextDigit;
                if (nextDigit == 1) {
                    onesCount++;
                }
                tail++;
            }
            nextDigit = 3 - nextDigit;
            head++;
        }
        return onesCount;
    }
}
