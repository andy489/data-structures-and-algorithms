// https://leetcode.com/problems/reconstruct-original-digits-from-english/

var originalDigits = function(s) {
    const freq = new Array(26).fill(0);
    for (const c of s) {
        freq[c.charCodeAt(0) - 97]++;
    }

    const count = new Array(10).fill(0);
    count[0] = freq['z'.charCodeAt(0) - 97];
    count[2] = freq['w'.charCodeAt(0) - 97];
    count[4] = freq['u'.charCodeAt(0) - 97];
    count[6] = freq['x'.charCodeAt(0) - 97];
    count[8] = freq['g'.charCodeAt(0) - 97];
    count[1] = freq['o'.charCodeAt(0) - 97] - count[0] - count[2] - count[4];
    count[3] = freq['h'.charCodeAt(0) - 97] - count[8];
    count[5] = freq['f'.charCodeAt(0) - 97] - count[4];
    count[7] = freq['s'.charCodeAt(0) - 97] - count[6];
    count[9] = freq['i'.charCodeAt(0) - 97] - count[5] - count[6] - count[8];

    let result = '';
    for (let d = 0; d <= 9; d++) {
        result += String(d).repeat(count[d]);
    }
    return result;
};
