// https://leetcode.com/problems/convert-a-number-to-hexadecimal/

var toHex = function(num) {
    if (num === 0) return '0';
    const hexChars = '0123456789abcdef';
    // Convert to unsigned 32-bit
    num = num >>> 0;
    let result = '';
    while (num > 0) {
        result = hexChars[num & 0xf] + result;
        num >>>= 4;
    }
    return result;
};
