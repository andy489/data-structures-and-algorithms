// https://leetcode.com/problems/building-boxes/

var minimumBoxes = function(n) {
    // Find largest h with tetrahedral number h*(h+1)*(h+2)/6 <= n
    let h = 0, total = 0;
    while (total + (h + 1) * (h + 2) / 2 <= n) {
        h++;
        total += h * (h + 1) / 2;
    }
    let floor = h * (h + 1) / 2;
    let i = 1;
    while (total < n) {
        total += i;
        floor++;
        i++;
    }
    return floor;
};
