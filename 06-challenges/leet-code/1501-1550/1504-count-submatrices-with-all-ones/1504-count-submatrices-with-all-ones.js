// https://leetcode.com/problems/count-submatrices-with-all-ones/

var numSubmat = function(mat) {
    const m = mat.length, n = mat[0].length;
    const height = new Array(n).fill(0);
    let result = 0;
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            height[j] = mat[i][j] === 1 ? height[j] + 1 : 0;
        }
        const stack = []; // [h, width]
        let total = 0;
        for (let j = 0; j < n; j++) {
            let width = 1;
            while (stack.length && stack[stack.length - 1][0] >= height[j]) {
                const [h, w] = stack.pop();
                total -= h * w;
                width += w;
            }
            total += height[j] * width;
            result += total;
            stack.push([height[j], width]);
        }
    }
    return result;
};
