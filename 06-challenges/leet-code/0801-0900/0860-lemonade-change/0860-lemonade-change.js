// https://leetcode.com/problems/lemonade-change/

var lemonadeChange = function(bills) {
    let five = 0, ten = 0;
    for (const bill of bills) {
        if (bill === 5) {
            five++;
        } else if (bill === 10) {
            if (!five) return false;
            five--; ten++;
        } else {
            if (ten && five) { ten--; five--; }
            else if (five >= 3) { five -= 3; }
            else return false;
        }
    }
    return true;
};
