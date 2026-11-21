// https://leetcode.com/problems/compare-version-numbers/

// Solution 1: Split — O(n+m) time, O(n+m) space
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int r1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int r2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (r1 < r2) return -1;
            if (r1 > r2) return 1;
        }
        return 0;
    }
}

// Solution 2: Two-pointer without split — O(n+m) time, O(1) space
class Solution2 {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0, n = version1.length(), m = version2.length();
        while (i < n || j < m) {
            int r1 = 0, r2 = 0;
            while (i < n && version1.charAt(i) != '.') r1 = r1 * 10 + (version1.charAt(i++) - '0');
            while (j < m && version2.charAt(j) != '.') r2 = r2 * 10 + (version2.charAt(j++) - '0');
            if (r1 < r2) return -1;
            if (r1 > r2) return 1;
            i++; j++;
        }
        return 0;
    }
}
