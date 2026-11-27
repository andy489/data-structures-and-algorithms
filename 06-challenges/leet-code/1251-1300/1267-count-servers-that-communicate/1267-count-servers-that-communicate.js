// https://leetcode.com/problems/count-servers-that-communicate/

var countServers = function(grid) {
    const m = grid.length, n = grid[0].length;
    const row = new Array(m).fill(0), col = new Array(n).fill(0);
    for(let i=0;i<m;i++) for(let j=0;j<n;j++) if(grid[i][j]){row[i]++;col[j]++;}
    let res=0;
    for(let i=0;i<m;i++) for(let j=0;j<n;j++) if(grid[i][j]&&(row[i]>1||col[j]>1)) res++;
    return res;
};
