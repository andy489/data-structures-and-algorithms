// https://leetcode.com/problems/can-i-win/

var canIWin = function(maxChoosableInteger, desiredTotal) {
    if (desiredTotal <= 0) {
        return true;
    }
    const totalSum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
    if (totalSum < desiredTotal) {
        return false;
    }
    const memo = new Map();

    function canWin(usedMask, remaining) {
        if (memo.has(usedMask)) {
            return memo.get(usedMask);
        }
        for (let i = 1; i <= maxChoosableInteger; i++) {
            if (usedMask & (1 << i)) {
                continue;
            }
            if (i >= remaining || !canWin(usedMask | (1 << i), remaining - i)) {
                memo.set(usedMask, true);
                return true;
            }
        }
        memo.set(usedMask, false);
        return false;
    }

    return canWin(0, desiredTotal);
};
