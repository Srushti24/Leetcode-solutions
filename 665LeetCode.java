class Solution {
public boolean checkPossibility(int[] nums) {
int total=-1;
for(int i=1;i<nums.length;i++)
{
if(nums[i-1]>nums[i])
{
// total++;
if(total>=0)
{
return false;
}
if(i-1>=1 && nums[i-2]>nums[i] &&
i!=nums.length-1 && nums[i+1]<nums[i-1] )
{
// System.out.println("1st");
// System.out.println("i is"+i);

                 //   System.out.println("2nd");
                    return false;
   
            }
            total++;
            
        }
        
    }
    
    return true;
}
}
