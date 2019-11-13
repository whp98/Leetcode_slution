package slution1;
//暴力算法，穷举法
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]+nums[i]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}