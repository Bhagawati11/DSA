import java.util.ArrayList;

class PrintAllDivisors {
    //tc : O(num) sc : O(num)
    public static ArrayList<Integer> bruteForce(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                divisors.add(i);
        }
        return divisors;
    }
    //tc : O(sqrt(num)) sc : O(num)
    public static ArrayList<Integer> optimalApproach(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                divisors.add(i);
        }
        int len = divisors.size();
        for (int i = len - 1; i >= 0; i--) {
            int div = num / divisors.get(i);
            if (divisors.contains(div) == false)
                divisors.add(div);
        }
        return divisors;
    }
    //different way to write optimal code
    //tc : O(sqrt(num)) sc : O(num)
     public static ArrayList<Integer> optimalApproach1(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if(i!=num/i)
                    divisors.add(num/i);
            }
        }
        return divisors;
    }
    public static void main(String[] args) {
        System.out.println(bruteForce(36));
        System.out.println(optimalApproach(36));
        System.out.println(optimalApproach1(36));
    }
}
