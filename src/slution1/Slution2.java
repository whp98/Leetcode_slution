package slution1;

import java.util.HashMap;

public class Slution2 {
    /**
     * 主要使用哈希表解决问题
     * 通过	4 ms	37 MB
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        for (int i=0;i<nums.length;i++){
            hashmap.put(nums[i],i);
        }
        for (int j=0;j<nums.length;j++){
            if(hashmap.containsKey(target-nums[j])&&hashmap.get(target-nums[j])!=j){
                return new int[]{j,hashmap.get(target-nums[j])};
            }
        }

        return null;
    }
    //通过	5 ms	36.8 MB
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap();
        int c=nums.length;
        for (int i=0;i<c;i++){
            hashmap.put(nums[i],i);
        }
        int a;
        int b;
        for (int j=0;j<c;j++){
            a= target-nums[j];
            if(hashmap.containsKey(a)&&j!=(b=hashmap.get(a))){
                return new int[]{j,b};
            }
        }
        return null;
    }
    // 通过	5 ms	37.3 MB
    public int[] twoSum2(int[] nums, int target) {
        int a = 0;
        HashMap<Integer, Integer> hashmap = new HashMap();
        for (int b:nums){
            hashmap.put(b,a++);
        }
        a=0;
        int c=0;
        for (int b:nums){
            a= target-nums[c];
            if(hashmap.containsKey(a)&&hashmap.get(a)!=c){
                return new int[]{c,hashmap.get(a)};
            }
            c++;
        }
        return null;
    }
    //	通过	3 ms	36.8 MB
    //自己优化的
    public int[] twoSum3(int[] nums, int target){
        HashMap<Integer, Integer> hashmap = new HashMap();
        int c=nums.length;
        for (int i=0;i<c;i++){
            hashmap.put(nums[i],i);
        }
        int a;
        int b;
        for (int j=0;j<c;j++){
            a= target-nums[j];
            if(hashmap.containsKey(a)&&j!=(b=hashmap.get(a))){
                return new int[]{j,b};
            }
        }
        return null;
    }
    //通过	3 ms	36.8 MB
    //想法来自网友
    public int[] twoSum4(int [] nums, int target){
        int[] res = new int[2];
        HashMap<Integer, Integer> hs = new HashMap<>();
        int len = nums.length;
        for (int i=0;i<len;i++){
            if (hs.containsKey(nums[i])){
                res[0]=i;
                res[1]=hs.get(nums[i]);
                return res;
            }
            hs.put(target-nums[i],i);
        }
        return res;
    }
}
