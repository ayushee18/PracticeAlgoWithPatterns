package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to
put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but once you have started you can’t skip a tree.
You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']*/
public class FruitsIntoBaskets {
    public static int maxFruitsInBasket(char [] arr) {
        int maxLength = Integer.MIN_VALUE;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                int temp = map.get(arr[i]);
                map.put(arr[i], temp + 1);
            } else {
                map.put(arr[i], 1);
            }
            while(map.size() > 2) {
                if(map.containsKey(arr[windowStart])) {
                    int temp = map.get(arr[windowStart]);
                    if(temp > 1) {
                        map.put(arr[windowStart], temp - 1);
                    } else {
                        map.remove(arr[windowStart]);
                    }
                    windowStart++;
                }
            }
            maxLength = Math.max(i - windowStart + 1, maxLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        char [] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(maxFruitsInBasket(arr));
    }
}
