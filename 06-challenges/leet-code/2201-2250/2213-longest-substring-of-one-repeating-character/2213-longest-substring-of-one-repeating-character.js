// https://leetcode.com/problems/longest-substring-of-one-repeating-character/
var longestRepeating = function(s, queryCharacters, queryIndices) {
    const n = s.length;
    const arr = s.split('');
    const maxLen = new Array(4 * n).fill(0);
    const prefLen = new Array(4 * n).fill(0);
    const sufLen = new Array(4 * n).fill(0);
    const prefChar = new Array(4 * n).fill('');
    const sufChar = new Array(4 * n).fill('');

    function setLeaf(node, pos) {
        maxLen[node] = prefLen[node] = sufLen[node] = 1;
        prefChar[node] = sufChar[node] = arr[pos];
    }

    function merge(node, left, mid, right) {
        prefChar[node] = prefChar[2 * node];
        sufChar[node] = sufChar[2 * node + 1];
        const leftSize = mid - left + 1;
        const rightSize = right - mid;
        prefLen[node] = prefLen[2 * node];
        if (prefLen[2 * node] === leftSize && prefChar[2 * node] === prefChar[2 * node + 1]) {
            prefLen[node] = leftSize + prefLen[2 * node + 1];
        }
        sufLen[node] = sufLen[2 * node + 1];
        if (sufLen[2 * node + 1] === rightSize && sufChar[2 * node + 1] === sufChar[2 * node]) {
            sufLen[node] = rightSize + sufLen[2 * node];
        }
        maxLen[node] = Math.max(maxLen[2 * node], maxLen[2 * node + 1]);
        if (sufChar[2 * node] === prefChar[2 * node + 1]) {
            maxLen[node] = Math.max(maxLen[node], sufLen[2 * node] + prefLen[2 * node + 1]);
        }
    }

    function build(node, left, right) {
        if (left === right) {
            setLeaf(node, left);
            return;
        }
        const mid = Math.floor((left + right) / 2);
        build(2 * node, left, mid);
        build(2 * node + 1, mid + 1, right);
        merge(node, left, mid, right);
    }

    function update(node, left, right, pos) {
        if (left === right) {
            setLeaf(node, pos);
            return;
        }
        const mid = Math.floor((left + right) / 2);
        if (pos <= mid) {
            update(2 * node, left, mid, pos);
        } else {
            update(2 * node + 1, mid + 1, right, pos);
        }
        merge(node, left, mid, right);
    }

    build(1, 0, n - 1);
    const result = [];
    for (let i = 0; i < queryIndices.length; i++) {
        arr[queryIndices[i]] = queryCharacters[i];
        update(1, 0, n - 1, queryIndices[i]);
        result.push(maxLen[1]);
    }
    return result;
};
