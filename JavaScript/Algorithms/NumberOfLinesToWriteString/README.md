# [806. Number of Lines To Write String](https://leetcode.com/problems/number-of-lines-to-write-string/description/)

## Description
We are to write the letters of a given string `S`, from left to right into lines. Each line has maximum width 100 units, and if writing a letter would cause the width of the line to exceed 100 units, it is written on the next line. We are given an array `widths`, an array where `widths[0]` is the width of 'a', `widths[1]` is the width of 'b', ..., and `widths[25]` is the width of 'z'.  

Now answer two questions: how many lines have at least one character from `S`, and what is the width used by the last such line? Return your answer as an integer list of length 2.  

## Example 1
```
Input: 
widths = [10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
S = 'abcdefghijklmnopqrstuvwxyz'
Output: [3, 60]
Explanation:
All letters have the same length of 10. To write all 26 letters, we need two full lines and one line with 60 units.
```

## Example 2
```
Input:
widths = [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
S = 'bbbcccdddaaa'
Output: [2, 4]
Explanaiton:
All letters except 'a' have the same length of 10, and 'bbbcccdddaaa' will cover 9 * 10 + 2 * 4 = 98 units. For the last 'a', it is written on the second line because there is only 2 units left in the first line. So the answer is 2 lines, plus 4 units in the second line.
```

## Note
- The length of `S` will be in the range[1, 1000].
- `S` will only contain lowercase letters.
- `widths` is an array of length `26`.
- `widths[i]` will be in the range of `[2, 10]`

## Solution
```javascript
/**
 * Number of lines to write string
 * @param {Array} widths
 * @param {string} S
 */
const numberOfLines = (widths, S) => {
	const result = [1, 0];
	const length = S.length;
	for (let i = 0; i < length; i++) {
		const charWidth = widths[S.charCodeAt(i) - 97];
		if (result[1] + charWidth > 100) {
			result[0] += 1;
			result[1] = charWidth;
		} else {
			result[1] += charWidth;
		}
	}
	return result;
};
```

## Explanaiton
Add up every char's width, greater than 100 go to next line add line number up, and assign current char's width to lastline width.