// https://leetcode.com/problems/check-if-dfs-strings-are-palindromes/

/**
 * @param {number[]} parent
 * @param {string} s
 * @return {boolean[]}
 */
var findAnswer = function(parent, s) {
    const n = parent.length;
    const children = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) {
        children[parent[i]].push(i);
    }

    const start = new Int32Array(n);
    const end = new Int32Array(n);
    const dfsChars = [];
    const stack = [0];
    const childPtr = new Int32Array(n);
    const visited = new Uint8Array(n);
    let pos = 0;

    while (stack.length > 0) {
        const node = stack[stack.length - 1];
        if (!visited[node]) {
            visited[node] = 1;
            start[node] = pos;
        }
        const ch = children[node];
        if (childPtr[node] < ch.length) {
            stack.push(ch[childPtr[node]++]);
        } else {
            dfsChars.push(s.charCodeAt(node) - 97 + 1);
            pos++;
            end[node] = pos;
            stack.pop();
        }
    }

    const MOD1 = BigInt(1_000_000_007);
    const BASE1 = BigInt(31);
    const MOD2 = BigInt(998_244_353);
    const BASE2 = BigInt(37);

    const h1 = new Array(n + 1).fill(0n);
    const h2 = new Array(n + 1).fill(0n);
    const rh1 = new Array(n + 1).fill(0n);
    const rh2 = new Array(n + 1).fill(0n);
    const pw1 = new Array(n + 1).fill(1n);
    const pw2 = new Array(n + 1).fill(1n);

    for (let i = 0; i < n; i++) {
        const v = BigInt(dfsChars[i]);
        h1[i + 1] = (h1[i] * BASE1 + v) % MOD1;
        h2[i + 1] = (h2[i] * BASE2 + v) % MOD2;
        pw1[i + 1] = pw1[i] * BASE1 % MOD1;
        pw2[i + 1] = pw2[i] * BASE2 % MOD2;
    }
    for (let i = n - 1; i >= 0; i--) {
        const v = BigInt(dfsChars[i]);
        rh1[i] = (rh1[i + 1] * BASE1 + v) % MOD1;
        rh2[i] = (rh2[i + 1] * BASE2 + v) % MOD2;
    }

    const answer = new Array(n);
    for (let i = 0; i < n; i++) {
        const l = start[i], r = end[i];
        const len = BigInt(r - l);
        const fwd1 = ((h1[r] - h1[l] * pw1[r - l]) % MOD1 + MOD1) % MOD1;
        const fwd2 = ((h2[r] - h2[l] * pw2[r - l]) % MOD2 + MOD2) % MOD2;
        const rev1 = ((rh1[l] - rh1[r] * pw1[r - l]) % MOD1 + MOD1) % MOD1;
        const rev2 = ((rh2[l] - rh2[r] * pw2[r - l]) % MOD2 + MOD2) % MOD2;
        answer[i] = (fwd1 === rev1 && fwd2 === rev2);
    }
    return answer;
};
