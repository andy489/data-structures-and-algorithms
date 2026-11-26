// https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

var minimumMoves = function(grid) {
    const n=grid.length, visited=new Set();
    const key=(r,c,d)=>`${r},${c},${d}`;
    let q=[[0,0,0]], steps=0;
    visited.add(key(0,0,0));
    while(q.length){
        const nq=[];
        for(const[r,c,d] of q){
            if(r===n-1&&c===n-2&&d===0)return steps;
            const add=(nr,nc,nd)=>{const k=key(nr,nc,nd);if(!visited.has(k)){visited.add(k);nq.push([nr,nc,nd]);}};
            if(d===0){
                if(c+2<n&&grid[r][c+2]===0)add(r,c+1,0);
                if(r+1<n&&grid[r+1][c]===0&&grid[r+1][c+1]===0){add(r+1,c,0);add(r,c,1);}
            }else{
                if(r+2<n&&grid[r+2][c]===0)add(r+1,c,1);
                if(c+1<n&&grid[r][c+1]===0&&grid[r+1][c+1]===0){add(r,c+1,1);add(r,c,0);}
            }
        }
        q=nq;steps++;
    }
    return -1;
};
