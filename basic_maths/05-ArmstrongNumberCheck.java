class ArmstrongCheck {

// Input:N = 153
// Output:True
// Explanation: 1^3+5^3+3^3 = 1 + 125 + 27 = 153
//tc : O(log10(num)) sc : O(1)
    public static boolean armstrongCheck(int num) {
        int num_digits = 0;
        int num1 = num;
        int num2 = num;
        while (num > 0) {
            num_digits += 1;
            num /= 10;
        }
        int sum = 0;
        while (num2 > 0) {
            sum += Math.pow(num2 % 10, num_digits);
            num2 /= 10;
        }

        if(num1==sum)
            return true;
        return false;

    }
    public static void main(String[] args) {
        System.out.println(armstrongCheck(1573));
    }
}
