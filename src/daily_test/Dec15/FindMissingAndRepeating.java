package daily_test.Dec15;

// Qs Link = {https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1}

public class FindMissingAndRepeating {
    public static void main(String[] args) {

        int[] a = {1,2,4,7,3,4,6};

        int[] ans = findTwoElement(a, 7);

        System.out.println("Repeating num: " + ans[0]);
        System.out.println("Missing num: " + ans[1]);
    }

    public static int[] findTwoElement(int[] arr, int n) {

        int[] ans = new int[2];

        int[] freq = new int[n+1];

        for(int i = 0 ; i < n ; i++){
            freq[arr[i]]++;
            if(freq[arr[i]] == 2) ans[0] = arr[i];
        }
        for(int i = 1 ; i <= n ; i++){
            if(freq[i] == 0){
                ans[1] = i;
                return ans;
            }
        }
        return ans;
    }
}
