// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/

var numSteps = function(s) {
    let steps = 0, carry = 0;
    for (let i = s.length - 1; i > 0; i--) {
        const bit = parseInt(s[i]) + carry;
        if (bit === 1) { steps += 2; carry = 1; }
        else { steps++; }
    }
    return steps + carry;
};
