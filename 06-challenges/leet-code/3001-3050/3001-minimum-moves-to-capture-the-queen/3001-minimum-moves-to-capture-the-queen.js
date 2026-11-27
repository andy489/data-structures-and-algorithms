// https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

var minMovesToCaptureTheQueen = function(a, b, c, d, e, f) {
    if (a === e && (c !== a || d <= Math.min(b,f) || d >= Math.max(b,f))) return 1;
    if (b === f && (d !== b || c <= Math.min(a,e) || c >= Math.max(a,e))) return 1;
    if (Math.abs(c-e) === Math.abs(d-f)) {
        if (!(a > Math.min(c,e) && a < Math.max(c,e) && b > Math.min(d,f) && b < Math.max(d,f))) return 1;
    }
    return 2;
};
