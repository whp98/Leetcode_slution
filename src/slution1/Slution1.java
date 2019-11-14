package slution1;
class Slution1 {
    //穷举法一
    // 通过	36 ms	37.3 MB
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
    //穷举法二
    //通过	17 ms	37.5 MB
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            int a = target-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==a){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
}