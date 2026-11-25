// https://leetcode.com/problems/reorganize-string/

var reorganizeString = function(s) {
    const freq = new Array(26).fill(0);
    for (const c of s) freq[c.charCodeAt(0) - 97]++;
    const heap = [];
    for (let i = 0; i < 26; i++) {
        if (freq[i] > 0) heap.push([freq[i], i]);
    }
    heap.sort((a, b) => b[0] - a[0]);
    const result = [];
    while (heap.length >= 2) {
        heap.sort((a, b) => b[0] - a[0]);
        const [c1, i1] = [heap[0][0], heap[0][1]];
        const [c2, i2] = [heap[1][0], heap[1][1]];
        result.push(String.fromCharCode(97 + i1));
        result.push(String.fromCharCode(97 + i2));
        heap[0][0]--;
        heap[1][0]--;
        if (heap[0][0] === 0) heap.shift();
        else { heap.splice(1, 1); if (heap[1] && heap[1][0] === 0) heap.splice(1, 1); }
    }
    if (heap.length) {
        if (heap[0][0] > 1) return '';
        result.push(String.fromCharCode(97 + heap[0][1]));
    }
    return result.join('');
};
