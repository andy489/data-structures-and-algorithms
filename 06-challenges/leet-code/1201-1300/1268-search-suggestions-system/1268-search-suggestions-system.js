// https://leetcode.com/problems/search-suggestions-system/

var suggestedProducts = function(products, searchWord) {
    products.sort();
    const res=[]; let prefix='';
    for(const c of searchWord){
        prefix+=c;
        let lo=0,hi=products.length;
        while(lo<hi){const m=(lo+hi)>>1;if(products[m]<prefix)lo=m+1;else hi=m;}
        const sg=[];
        for(let i=lo;i<Math.min(lo+3,products.length);i++){
            if(products[i].startsWith(prefix))sg.push(products[i]);else break;
        }
        res.push(sg);
    }
    return res;
};
