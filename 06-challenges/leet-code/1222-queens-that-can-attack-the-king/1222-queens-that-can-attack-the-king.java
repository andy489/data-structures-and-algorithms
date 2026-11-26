// https://leetcode.com/problems/queens-that-can-attack-the-king/

// Solution: 8-Direction Search — O(1) — 8*8 max time, O(1) space
// Solution: 8-Direction Search — O(1) time, O(1) space
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        Set<Long> set = new HashSet<>();
        for (int[] q : queens) set.add((long)q[0]*8+q[1]);
        List<List<Integer>> res = new ArrayList<>();
        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for (int[] d : dirs) {
            int r = king[0]+d[0], c = king[1]+d[1];
            while (r>=0&&r<8&&c>=0&&c<8) {
                if (set.contains((long)r*8+c)) { res.add(Arrays.asList(r,c)); break; }
                r+=d[0]; c+=d[1];
            }
        }
        return res;
    }
}
