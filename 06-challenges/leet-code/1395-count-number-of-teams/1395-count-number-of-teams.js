// https://leetcode.com/problems/count-number-of-teams/

var numTeams = function(rating) {
    const n=rating.length; let cnt=0;
    for(let j=1;j<n-1;j++){
        let ls=0,ll=0,rs=0,rl=0;
        for(let i=0;i<j;i++){if(rating[i]<rating[j])ls++;else if(rating[i]>rating[j])ll++;}
        for(let k=j+1;k<n;k++){if(rating[k]<rating[j])rs++;else if(rating[k]>rating[j])rl++;}
        cnt+=ls*rl+ll*rs;
    }
    return cnt;
};
