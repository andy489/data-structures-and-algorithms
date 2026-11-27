// https://leetcode.com/problems/distribute-money-to-maximum-children/
class Solution {
    public int distMoney(int money, int children) {
        if (money < children) {
            return -1;
        }
        money -= children;
        int eights = Math.min(money / 7, children);
        money -= eights * 7;
        children -= eights;
        if (children == 0 && money > 0) {
            eights--;
        } else if (children == 1 && money == 3) {
            eights--;
        }
        return eights;
    }
}
