// https://leetcode.com/problems/count-number-of-teams/

// Solution: O(n^2) enumeration
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length, count = 0;
        for (int j = 1; j < n-1; j++) {
            int leftSmall=0, leftLarge=0, rightSmall=0, rightLarge=0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) leftSmall++;
                else if (rating[i] > rating[j]) leftLarge++;
            }
            for (int k = j+1; k < n; k++) {
                if (rating[k] < rating[j]) rightSmall++;
                else if (rating[k] > rating[j]) rightLarge++;
            }
            count += leftSmall * rightLarge + leftLarge * rightSmall;
        }
        return count;
    }
}
