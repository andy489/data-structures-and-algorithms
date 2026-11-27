# 1797. Design Authentication Manager

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-authentication-manager/

---

## Problem Statement

There is an authentication system that works with authentication tokens. For each session, the user will receive a new authentication token that will expire `timeToLive` seconds after the `currentTime`. If the token is renewed, the expiry time will be extended to expire `timeToLive` seconds after the (potentially different) `currentTime`.

Implement the `AuthenticationManager` class:

- `AuthenticationManager(int timeToLive)` constructs the `AuthenticationManager` and sets the `timeToLive`.
- `generate(String tokenId, int currentTime)` generates a new token with the given `tokenId` at the given `currentTime` in seconds.
- `renew(String tokenId, int currentTime)` renews the **unexpired** token with the given `tokenId` at the given `currentTime` in seconds. If there are no unexpired tokens with the given `tokenId`, the request is ignored, and nothing happens.
- `countUnexpiredTokens(int currentTime)` returns the number of **unexpired** tokens at the given `currentTime`.

Note that if a token expires at time `t`, and another action happens at time `t` (`renew` or `countUnexpiredTokens`), the token is considered **expired** at the time of the later action.

---

## Examples

**Example 1:**
```
Input:
["AuthenticationManager","renew","generate","countUnexpiredTokens","generate","renew","renew","countUnexpiredTokens"]
[[5],["aaa",1],["aaa",2],[6],["bbb",7],["aaa",8],["bbb",10],[15]]
Output: [null,null,null,1,null,null,null,0]
```

---

## Constraints

- `1 <= timeToLive <= 10^8`
- `1 <= currentTime <= 10^8`
- `1 <= tokenId.length <= 5`
- `tokenId` consists only of lowercase letters.
- All calls to `generate` will contain unique values of `tokenId`.
- The values of `currentTime` across all the function calls will be **strictly increasing**.
- At most `2000` calls will be made to `generate`, `renew`, and `countUnexpiredTokens`.
