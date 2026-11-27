class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length, try1=0;
        for(int i=0; i<len; i++)
        {
            for(int j=i+1; j<len; j++)
            {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
            }
        }
        }
        return new int[] {}; 
    }
    
}
