// https://leetcode.com/problems/double-modular-exponentiation/
var getGoodIndices = function(variables, target) {
    function modPow(base, exp, mod) {
        let result = 1n;
        base = BigInt(base) % BigInt(mod);
        exp = BigInt(exp);
        const bigMod = BigInt(mod);
        while (exp > 0n) {
            if (exp & 1n) {
                result = result * base % bigMod;
            }
            base = base * base % bigMod;
            exp >>= 1n;
        }
        return Number(result);
    }

    const result = [];
    for (let i = 0; i < variables.length; i++) {
        const [a, b, c, m] = variables[i];
        const inner = modPow(a, b, 10);
        const val = modPow(inner, c, m);
        if (val === target) {
            result.push(i);
        }
    }
    return result;
};
