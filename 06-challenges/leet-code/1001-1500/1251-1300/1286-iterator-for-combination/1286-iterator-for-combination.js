// https://leetcode.com/problems/iterator-for-combination/

class CombinationIterator {
    constructor(characters, combinationLength) {
        this.combos = []; this.idx = 0;
        const n = characters.length;
        for(let mask=0;mask<(1<<n);mask++){
            if(mask.toString(2).split('1').length-1===combinationLength){
                let s='';
                for(let i=0;i<n;i++) if(mask>>(n-1-i)&1) s+=characters[i];
                this.combos.push(s);
            }
        }
    }
    next() { return this.combos[this.idx++]; }
    hasNext() { return this.idx < this.combos.length; }
}
