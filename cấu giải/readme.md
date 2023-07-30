136. Single Number

class Solution {
    public int singleNumber(int[] nums) {
        int len = nums.length;
    ;
     boolean isTwice = false; 
     for (int i=0; i < len; i++) { 
       isTwice = false;
       for (int j=0; j<len; j++) {
         if (isTwice) break;
         if (i != j)
            if(nums[i] == nums[j]) 
                isTwice = true;
       }         
       if(!isTwice)   
       return nums[i];;
     }
    }}
1. Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
         int len = nums.length;

        int[] result = new int[2] ;
        
        int sum = 0;

        for (int i = 0; i < len; i++) {
            for(int j = i+1; j < len; j++)
            {

                sum = nums[i]+nums[j];       
                if(sum == target)
                {
                    result[0]=i;
                    result[1]=j;
                }
            }
        
        }
        return result;
        
    }
}
27. Remove Element
class Solution {
    public int removeElement(int[] nums, int val) {
          int len = nums.length;
        int newnums = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[newnums] = nums[i];
                newnums++;
            }
            
        }

        return newnums;
        
    }
}
485. Max Consecutive Ones
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=nums.length;
         int count = 1;
         int maxcount=1;
         for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]){
                count++;}
            else{
                if(count>maxcount)
                maxcount=count;
                 count = 1;
            }    
                
        
    }
     if(count>maxcount)
                maxcount=count;
    return maxcount;
}}
169. Majority Element
class Solution {
    public int majorityElement(int[] nums) {
        int maxcount = 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > maxcount) {
                maxcount = count;
                index = i;
                count=0;
            }
            
        }
  
        // if (maxcount > nums.length / 2)
          return nums[index];
        
    }
   
}
268. Missing Number

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
      

        for (int i = 0; i <= n; i++) {
            boolean found = false;
            
            
            for (int j=0; j < n; j++) {
                if (nums[j] == i) {
                    found = true;
                    j++; 
                    break;
                }
            }

            if (!found) 
                return i; 
        }

        return -1; 
    }
}


