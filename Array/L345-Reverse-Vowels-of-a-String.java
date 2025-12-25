class Solution {
   //Using 2-pointer
   //time complexity : O(log(n))
    public boolean isVowel(char ch) {
        return ch =='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u'
            || ch =='A' || ch =='E' || ch =='I' || ch =='O' || ch =='U';
    }

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while (i < j) {
            if (!isVowel(arr[i])) i++;
            if (!isVowel(arr[j])) j--;

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        return new String(arr);
    }
}
