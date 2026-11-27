// https://leetcode.com/problems/find-palindrome-with-fixed-length/
class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int halfLen = (intLength + 1) / 2;
        long start = (long) Math.pow(10, halfLen - 1);
        long end = (long) Math.pow(10, halfLen);
        long[] answer = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long half = start + queries[i] - 1;
            if (half >= end) {
                answer[i] = -1;
                continue;
            }
            String halfStr = Long.toString(half);
            StringBuilder sb = new StringBuilder(halfStr);
            int skip = intLength % 2 == 1 ? 1 : 0;
            for (int j = halfStr.length() - 1 - skip; j >= 0; j--) {
                sb.append(halfStr.charAt(j));
            }
            answer[i] = Long.parseLong(sb.toString());
        }
        return answer;
    }
}
