# [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)

## Description

ROman numberals are represented by seven different symbols: `I`, `V`, `X`, `L`, `C`, `D`, and `M`.

| Symbol | Value |
| ------ | ----- |
| I      | 1     |
| V      | 5     |
| X      | 10    |
| L      | 50    |
| C      | 100   |
| D      | 500   |
| M      | 1000  |

For example, two is written as `II` in Roman numberal, just two one's added together. Twelve is written as, `XII`, which is simply `X` + `II`. The number twenty seven is written as `XXVII`, which is `XX` + `V` + `II`. 

Roman numberals are usually written largest to smallest from left to right. However, the numberal for four is not `IIII`. Instead, the number for is written as `IV`. Because one is before the five we subtract it making four. The same princple applies to the number nine, which is written as `IX`. There are six instances where subtraction is used:

- `I` can be placed before `V` (5) and `X` (10) to make 4 and 9.
- `X` can be placed before `L` (50) and `C` (100) to make 40 and 90.
- `C` can be place before `D` (500) ane `M` (1000) to make 400 and 900.

Given a roman numberal, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

## Example 1

```example
Input: "III"
Output: 3
```

## Example 2

```example
Input: "IV"
Output: 4
```

## Example 3

```example
Input: "IX"
Output: 9
```

## Example 4

```example
Input: "LVIII"
Output: 58
Explanation: L = 50, V = 5, III = 3.
```

## Example 5

```example
Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
```

## Solution

```javascript
/**
 * @param {String} s 
 * @returns {Number}
 */
const romanToInt = s => {
  const map = {
    'I': 1,
    'V': 5,
    'X': 10,
    'L': 50,
    'C': 100,
    'D': 500,
    'M': 1000
  };
  const integer = [ ...s ].reduce((holder, char, index) => {
    const current = map[char];
    const next = map[s[index + 1]];
    return holder + (current < next ? -current : current);
  }, 0);
  return integer;
};
```
