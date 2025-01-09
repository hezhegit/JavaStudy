public class MoveZeroes283 {


    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        while(i<nums.length && j<nums.length){
            while (i<nums.length && nums[i]!=0){
                i++;
            }
            j = i+1;
            while (j<nums.length && nums[j]==0){
                j++;
            }

            if(j < nums.length){
                nums[i]=nums[j];
                nums[j]=0;
            }

        }
    }


    public void moveZeroes2(int[] nums) {
        int no_zero = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[no_zero]=nums[i];
                no_zero++;
            }
        }
        for(int i=no_zero;i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 m = new MoveZeroes283();
        int[] nums = new int[]{0,1,0,3,12,0,0};
        m.moveZeroes2(nums);
        for (int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
