// https://leetcode.com/problems/find-center-of-star-graph/

// Solution: Check First Two Edges — O(1) time, O(1) space
class Solution {
    public int findCenter(int[][] edges) {
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }
        return edges[0][1];
    }
}
