// https://leetcode.com/problems/number-of-closed-islands/

var closedIsland = function(grid) {
    const m = grid.length, n = grid[0].length;
    function dfs(i, j) {
        if (i<0||i>=m||j<0||j>=n||grid[i][j]!==0) return;
        grid[i][j]=1;
        dfs(i+1,j);dfs(i-1,j);dfs(i,j+1);dfs(i,j-1);
    }
    for(let i=0;i<m;i++){dfs(i,0);dfs(i,n-1);}
    for(let j=0;j<n;j++){dfs(0,j);dfs(m-1,j);}
    let count=0;
    for(let i=0;i<m;i++) for(let j=0;j<n;j++) if(grid[i][j]===0){dfs(i,j);count++;}
    return count;
};
