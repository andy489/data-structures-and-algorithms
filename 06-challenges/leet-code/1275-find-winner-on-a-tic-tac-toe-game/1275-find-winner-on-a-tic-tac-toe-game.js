// https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

var tictactoe = function(moves) {
    const row=[0,0,0],col=[0,0,0];let diag=0,anti=0;
    for(let i=0;i<moves.length;i++){
        const[r,c]=moves[i],v=i%2===0?1:-1;
        row[r]+=v;col[c]+=v;if(r===c)diag+=v;if(r+c===2)anti+=v;
    }
    for(let i=0;i<3;i++) if(Math.abs(row[i])===3||Math.abs(col[i])===3) return moves.length%2===0?'B':'A';
    if(Math.abs(diag)===3||Math.abs(anti)===3) return moves.length%2===0?'B':'A';
    return moves.length===9?'Draw':'Pending';
};
