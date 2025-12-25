class Solution{
    //brute force : nested loop
    //time complexity : O(n^2)
    public int maxArea(int[] height) {
        int maxCapacity = Integer.MIN_VALUE;
        for(int i =0;i<height.length;i++){
            for(int j = i+1;j<height.length;j++){
                maxCapacity = Integer.max(Integer.min(height[i],height[j])*(j-i),maxCapacity);
                //System.out.println("capacity = "+maxCapacity+"(height[i],height[j] = "+height[i]+","+height[j]+" j, i = "+j+","+i);
            }
        }
        return maxCapacity;
    }
    //Using 2 pointer
    //time complexity : O(n)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxCapacity = Integer.MIN_VALUE;
        while(left<right){
            maxCapacity = Integer.max(Integer.min(height[left],height[right])*(right-left),maxCapacity);
            if(height[left]<=height[right]) left++;
            else right--;

        }
        return maxCapacity;
    }
}