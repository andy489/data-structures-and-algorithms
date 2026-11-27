// https://leetcode.com/problems/distribute-money-to-maximum-children/
/**
 * @param {number} money
 * @param {number} children
 * @return {number}
 */
var distMoney = function(money, children) {
    if (money < children) {
        return -1;
    }
    money -= children;
    let eights = Math.min(Math.floor(money / 7), children);
    money -= eights * 7;
    children -= eights;
    if (children === 0 && money > 0) {
        eights--;
    } else if (children === 1 && money === 3) {
        eights--;
    }
    return eights;
};
