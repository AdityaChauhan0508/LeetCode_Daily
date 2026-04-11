import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        // number -> [secondLast, last]
        Map<Integer, int[]> map = new HashMap<>();

        int result = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            int num = nums[k];

            if (!map.containsKey(num)) {
                map.put(num, new int[]{-1, k}); // [secondLast, last]
            } else {
                int[] pair = map.get(num);

                if (pair[0] != -1) {
                    // we have at least 3 occurrences
                    result = Math.min(result, k - pair[0]);
                }

                // shift indices
                pair[0] = pair[1];
                pair[1] = k;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : 2 * result;
    }
}