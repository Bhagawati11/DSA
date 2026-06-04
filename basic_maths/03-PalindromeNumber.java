class palindrome {
    //tc : O(log10(num)) sc : O(1)
    public static boolean checkPalin(int num) { 
        int rev = 0;
        int num1 = num;
        while (num > 0) {
            int rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        if(num1 == rev)
            return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(checkPalin(67576));
    }
}
