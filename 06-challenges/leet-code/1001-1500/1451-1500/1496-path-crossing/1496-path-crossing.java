// https://leetcode.com/problems/path-crossing/

// Solution: HashSet Tracking — O(n) time, O(n) space
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Long> seen = new HashSet<>();
        int x = 0, y = 0;
        seen.add(0L);
        for (char c : path.toCharArray()) {
            if (c == 'N') y++;
            else if (c == 'S') y--;
            else if (c == 'E') x++;
            else x--;
            long key = (long)(x + 20001) * 40003 + (y + 20001);
            if (!seen.add(key)) return true;
        }
        return false;
    }
}
