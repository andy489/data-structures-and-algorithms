// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

// Solution: Slot Counting — O(n) time, O(1) space
class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;
        for (String token : preorder.split(",")) {
            slots--;
            if (slots < 0) {
                return false;
            }
            if (!token.equals("#")) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}
