// https://leetcode.com/problems/integer-to-english-words/

// Solution: Recursive Chunking by Thousands — O(1) time, O(1) space
const ONES = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine',
    'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen',
    'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
const TENS = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'];
const SCALES = ['', ' Thousand', ' Million', ' Billion'];

function helper(n) {
    if (n === 0) return '';
    if (n < 20) return ONES[n];
    if (n < 100) return TENS[Math.floor(n / 10)] + (n % 10 ? ' ' + ONES[n % 10] : '');
    return ONES[Math.floor(n / 100)] + ' Hundred' + (n % 100 ? ' ' + helper(n % 100) : '');
}

var numberToWords = function(num) {
    if (num === 0) return 'Zero';
    const parts = [];
    for (let i = 3; i >= 0; i--) {
        const divisor = Math.pow(1000, i);
        if (Math.floor(num / divisor) > 0) {
            parts.push(helper(Math.floor(num / divisor)) + SCALES[i]);
            num %= divisor;
        }
    }
    return parts.join(' ');
};
