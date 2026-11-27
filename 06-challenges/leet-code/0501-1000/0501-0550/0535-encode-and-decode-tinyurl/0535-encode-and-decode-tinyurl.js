// https://leetcode.com/problems/encode-and-decode-tinyurl/

var encode = (function() {
    const codeToUrl = new Map();
    let counter = 0;

    function encode(longUrl) {
        codeToUrl.set(++counter, longUrl);
        return `http://tinyurl.com/${counter}`;
    }

    function decode(shortUrl) {
        const key = parseInt(shortUrl.split('/').pop(), 10);
        return codeToUrl.get(key);
    }

    return { encode, decode };
})();

var decode = encode.decode;
encode = encode.encode;
