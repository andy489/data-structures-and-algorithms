// https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int rem = s.length() % k;
        if (rem != 0) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < k - rem; i++) {
                sb.append(fill);
            }
            s = sb.toString();
        }
        int groups = s.length() / k;
        String[] result = new String[groups];
        for (int i = 0; i < groups; i++) {
            result[i] = s.substring(i * k, (i + 1) * k);
        }
        return result;
    }
}
