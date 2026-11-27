// https://leetcode.com/problems/maximal-rectangle/

function largestInHistogram(heights) {
    const n = heights.length;
    const stack = [-1];
    let maxArea = 0;
    for (let i = 0; i <= n; i++) {
        const h = i === n ? 0 : heights[i];
        while (stack[stack.length - 1] !== -1 && heights[stack[stack.length - 1]] >= h) {
            const height = heights[stack.pop()];
            const width = i - stack[stack.length - 1] - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        stack.push(i);
    }
    return maxArea;
}

var maximalRectangle = function(matrix) {
    const m = matrix.length, n = matrix[0].length;
    const heights = new Array(n).fill(0);
    let maxArea = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            heights[j] = matrix[i][j] === '1' ? heights[j] + 1 : 0;
        }
        maxArea = Math.max(maxArea, largestInHistogram(heights));
    }
    return maxArea;
};
