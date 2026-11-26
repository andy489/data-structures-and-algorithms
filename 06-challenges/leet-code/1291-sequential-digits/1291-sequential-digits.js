// https://leetcode.com/problems/sequential-digits/

var sequentialDigits = function(low, high) {
    const digits = "123456789", res = [];
    for (let len=2; len<=9; len++) for (let s=0; s+len<=9; s++) {
        const num = +digits.slice(s, s+len);
        if (num >= low && num <= high) res.push(num);
    }
    return res.sort((a,b)=>a-b);
};
