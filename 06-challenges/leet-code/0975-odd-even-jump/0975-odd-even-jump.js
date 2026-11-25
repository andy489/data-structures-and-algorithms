// https://leetcode.com/problems/odd-even-jump/

var oddEvenJumps = function(arr) {
    const n = arr.length;
    const makeNext = (sortedIdx) => {
        const res = new Array(n).fill(-1);
        const stack = [];
        for (const i of sortedIdx) {
            while (stack.length && stack[stack.length-1] < i) res[stack.pop()] = i;
            stack.push(i);
        }
        return res;
    };
    const idx = Array.from({length: n}, (_, i) => i);
    const sortedOdd = [...idx].sort((a, b) => arr[a] !== arr[b] ? arr[a]-arr[b] : a-b);
    const sortedEven = [...idx].sort((a, b) => arr[a] !== arr[b] ? arr[b]-arr[a] : a-b);
    const nextOdd = makeNext(sortedOdd), nextEven = makeNext(sortedEven);
    const oddOk = new Array(n).fill(false), evenOk = new Array(n).fill(false);
    oddOk[n-1] = evenOk[n-1] = true;
    let ans = 1;
    for (let i = n-2; i >= 0; i--) {
        if (nextOdd[i] !== -1) oddOk[i] = evenOk[nextOdd[i]];
        if (nextEven[i] !== -1) evenOk[i] = oddOk[nextEven[i]];
        if (oddOk[i]) ans++;
    }
    return ans;
};
