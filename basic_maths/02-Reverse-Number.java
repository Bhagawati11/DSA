class ReverseNum {
    public static int reverseNum(int num) { //tc : O(log10(num)) sc : O(1)
        int rev = 0;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        return rev;
    }
   public static void main(String[] args) {
       int n = 667;
       System.out.println(reverseNum(n));
   } 
}
