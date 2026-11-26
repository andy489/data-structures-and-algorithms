// https://leetcode.com/problems/decode-xored-permutation/

var decode = function(encoded) {
    const n = encoded.length + 1;
    let total = 0;
    for (let i = 1; i <= n; i++) {
        total ^= i;
    }
    let rest = 0;
    for (let i = 1; i < encoded.length; i += 2) {
        rest ^= encoded[i];
    }
    const perm = [total ^ rest];
    for (const x of encoded) {
        perm.push(perm[perm.length - 1] ^ x);
    }
    return perm;
};
