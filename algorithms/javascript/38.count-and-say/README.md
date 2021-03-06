# [38. Count and Say](https://leetcode.com/problems/count-and-say/)

## Description

The count-and-say sequence is the sequence of integers with the first five terms as following:

1. 1
2. 11
3. 21
4. 1211
5. 111221

`1` is read off as `"one 1"` or `11`.
`11` is read off as `"two 1s"` or `21`.
`21` is read off as `"one 2"`, then `one 1"` or `1211`.

Given an iteger *n* where 1 ≤ *n* ≤ 30, generate the nth term of the count-and-say sequence.

## Note

Each term of the sequence of integers will be represented as a string.

## Example 1

```example
Input: 1
Output: "1"
```

## Example

```example
Input: 4
Output: "1211"
```

## Solution

```javascript
const countAndSay = (n) => {
  if (n === 1) { return '1'; }
  const say = str => {
    let idx = 0;
    let newStr = '';
    while (idx < str.length) {
      let occurences = 1;
      while (str[idx + 1] && str[idx + 1] === str[idx]) {
        idx++;
        occurences++;
      }
      newStr += occurences + str[idx];
      idx++
    }
    return newStr;
  };
  return say(countAndSay(n - 1));
};
```
