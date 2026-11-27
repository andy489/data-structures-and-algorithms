// https://leetcode.com/problems/maximum-manhattan-distance-after-k-changes/
class Solution {
    public int maxDistance(String s, int k) {
        int res = 0;
        char[][] targets = {{'N', 'E'}, {'N', 'W'}, {'S', 'E'}, {'S', 'W'}};
        for (char[] target : targets) {
            int axis1 = 0, axis2 = 0, changes = 0;
            for (char c : s.toCharArray()) {
                if (c == target[0]) {
                    axis1++;
                } else if (c == target[1]) {
                    axis2++;
                } else if (changes < k) {
                    changes++;
                    if (c == opposite(target[0])) {
                        axis1++;
                    } else {
                        axis2++;
                    }
                } else {
                    if (c == opposite(target[0])) {
                        axis1--;
                    } else {
                        axis2--;
                    }
                }
                res = Math.max(res, axis1 + axis2);
            }
        }
        return res;
    }

    private char opposite(char c) {
        if (c == 'N') {
            return 'S';
        }
        if (c == 'S') {
            return 'N';
        }
        if (c == 'E') {
            return 'W';
        }
        return 'E';
    }
}
