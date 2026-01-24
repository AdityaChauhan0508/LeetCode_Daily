class Solution {
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);

        int result = 0, n = nums.length;

        for(int i=0; i<n; i++){
            result = Math.max(result, nums[n-1 - i] + nums[i] );
        }
        return result;
        
    }
}