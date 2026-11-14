// https://leetcode.com/problems/largest-rectangle-in-histogram/

var largestRectangleArea = function(heights) {
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
};
