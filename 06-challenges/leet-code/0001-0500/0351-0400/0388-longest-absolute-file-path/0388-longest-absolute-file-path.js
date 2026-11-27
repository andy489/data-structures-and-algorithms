// https://leetcode.com/problems/longest-absolute-file-path/

// Solution: Stack of Prefix Lengths — O(n) time, O(n) space
var lengthLongestPath = function(input) {
    const lines = input.split('\n');
    const stack = [0];
    let maxLen = 0;
    for (const line of lines) {
        let depth = 0;
        while (depth < line.length && line[depth] === '\t') depth++;
        const name = line.slice(depth);
        stack[depth + 1] = stack[depth] + name.length + 1;
        if (name.includes('.')) maxLen = Math.max(maxLen, stack[depth + 1] - 1);
    }
    return maxLen;
};
