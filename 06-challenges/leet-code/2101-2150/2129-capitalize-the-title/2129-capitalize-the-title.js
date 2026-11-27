// https://leetcode.com/problems/capitalize-the-title/
var capitalizeTitle = function(title) {
    return title.split(' ').map(w => {
        if (w.length <= 2) {
            return w.toLowerCase();
        }
        return w[0].toUpperCase() + w.slice(1).toLowerCase();
    }).join(' ');
};
