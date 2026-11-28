// https://leetcode.com/problems/design-spreadsheet/

var Spreadsheet = function(rows) {
    this.cells = new Map();
};

Spreadsheet.prototype.setCell = function(cell, value) {
    this.cells.set(cell, value);
};

Spreadsheet.prototype.resetCell = function(cell) {
    this.cells.delete(cell);
};

Spreadsheet.prototype.getValue = function(formula) {
    const expr = formula.slice(1);
    const parts = expr.split('+');
    let sum = 0;
    for (const part of parts) {
        if (part[0] >= '0' && part[0] <= '9') {
            sum += parseInt(part);
        } else {
            sum += this.cells.get(part) || 0;
        }
    }
    return sum;
};
