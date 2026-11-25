// https://leetcode.com/problems/self-dividing-numbers/

var selfDividingNumbers = function(left, right) {
    function isSelfDividing(n) {
        let temp = n;
        while (temp > 0) {
            const d = temp % 10;
            if (d === 0 || n % d !== 0) return false;
            temp = Math.floor(temp / 10);
        }
        return true;
    }
    const result = [];
    for (let n = left; n <= right; n++) {
        if (isSelfDividing(n)) result.push(n);
    }
    return result;
};
