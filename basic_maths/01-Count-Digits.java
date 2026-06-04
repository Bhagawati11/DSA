class Solution {
    public static int bruteForce(int num) {//tc : O(log10(num)) sc : O(1)
        int count = 0;
        while (num > 0) {
            count += 1;
            num /= 10;
        }
        return count;
    }
    public static int optimalApproach(int num) { //tc : O(1) sc : O(1)
        return (int) (Math.log10(num) + 1);
    }
    public static void main(String[] args) {
        int num = 12345;

        System.out.println(bruteForce(num));
        System.err.println(optimalApproach(num));
        
    }
}