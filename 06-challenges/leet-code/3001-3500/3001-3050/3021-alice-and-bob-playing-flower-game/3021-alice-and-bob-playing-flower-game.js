// https://leetcode.com/problems/alice-and-bob-playing-flower-game/

var flowerGame = function(n, m) {
    const oddX = Math.floor((n+1)/2), evenX = Math.floor(n/2);
    const oddY = Math.floor((m+1)/2), evenY = Math.floor(m/2);
    return oddX * evenY + evenX * oddY;
};
