// https://leetcode.com/problems/decode-the-slanted-ciphertext/

// Solution: Matrix Diagonal — O(n) time, O(n) space
var decodeCiphertext = function(encodedText, rows) {
    if (rows === 1) return encodedText;
    const n = encodedText.length, cols = n / rows;
    const res = [];
    for (let col = 0; col < cols; col++) {
        for (let r = 0, c = col; r < rows && c < cols; r++, c++) res.push(encodedText[r * cols + c]);
    }
    return res.join('').replace(/\s+$/, '');
};
