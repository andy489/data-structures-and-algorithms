// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

class Solution {
    public int largestInteger(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;

        int[] odds = new int[n];
        int[] evens = new int[n];
        int oi = 0, ei = 0;

        for (char c : digits) {
            int d = c - '0';
            if (d % 2 == 1) {
                odds[oi++] = d;
            } else {
                evens[ei++] = d;
            }
        }

        // Sort descending
        for (int i = 0; i < oi - 1; i++) {
            for (int j = i + 1; j < oi; j++) {
                if (odds[j] > odds[i]) {
                    int tmp = odds[i];
                    odds[i] = odds[j];
                    odds[j] = tmp;
                }
            }
        }
        for (int i = 0; i < ei - 1; i++) {
            for (int j = i + 1; j < ei; j++) {
                if (evens[j] > evens[i]) {
                    int tmp = evens[i];
                    evens[i] = evens[j];
                    evens[j] = tmp;
                }
            }
        }

        oi = 0;
        ei = 0;
        int result = 0;
        for (char c : digits) {
            int d = c - '0';
            result *= 10;
            if (d % 2 == 1) {
                result += odds[oi++];
            } else {
                result += evens[ei++];
            }
        }
        return result;
    }
}
