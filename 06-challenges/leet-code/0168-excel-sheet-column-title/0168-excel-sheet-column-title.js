// https://leetcode.com/problems/excel-sheet-column-title/

var convertToTitle = function(columnNumber) {
    let result = '';
    while (columnNumber > 0) {
        columnNumber--;
        result = String.fromCharCode(65 + columnNumber % 26) + result;
        columnNumber = Math.floor(columnNumber / 26);
    }
    return result;
};

var convertToTitle2 = function(columnNumber) {
    if (columnNumber === 0) return '';
    columnNumber--;
    return convertToTitle2(Math.floor(columnNumber / 26)) + String.fromCharCode(65 + columnNumber % 26);
};
