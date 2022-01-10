package FileHandling;


import java.util.*;

public class Count {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int t = sc.nextInt();
        sc.nextLine();

        while (t > 0) {

            String s = sc.nextLine();


            boolean isFound = false;

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String binary = s.substring(i, j);

                    int num = binToDec(binary);

                    if (isPrime(num)) {
                        System.out.println("Yes");
                        isFound = true;
                        break;
                    }
                }
                if(isFound) break;
            }

            if (!isFound) System.out.println("No");
            t--;
        }

    }

    static int binToDec(String s){
        int ans = 0;

        int pow = 0;
        for(int i = s.length()-1; i>=0 ; i--){
            if(s.charAt(i) == '1'){
                ans += (int)Math.pow(2, pow);
            }
            pow++;
        }
        return ans;
    }

    static boolean isPrime(int n){
        if(n == 0) return false;
        if(n ==1) return false;
        if(n == 2 ) return true;

        for(int i = 2; i <= (int)Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }

        return true;
    }











//
//
//
//
//
//
//        String[][] liked = null;
//        String[][] disliked = null;
//
//        Set<String> set = new HashSet<>();
//        List<String> total_liked_items = new ArrayList<>();
//
//        try {
//            File myObj = new File("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\d_difficult.in.txt");
//            Scanner sc = new Scanner(myObj);
//
//            int c = sc.nextInt(); // num of customers
//            liked  = new String[c][5];
//            disliked  = new String[c][5];
//
//            for (int i = 0 ; i < c ; i++){
//
//                int l = sc.nextInt();       //num of liked items
//
//                for(int j = 0 ; j < l ; j++){
//                    String ingredient =  sc.next();
//                    liked[i][j] = ingredient;
//                    if(set.add(ingredient)) total_liked_items.add(ingredient);
//                }
//
//
//                int d = sc.nextInt();  // num of disliked item
//                for(int j = 0 ; j < d ; j++){
//                    String ingredient =  sc.next();
//                    disliked[i][j] = ingredient;
//                }
//            }
//
//
//            sc.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//
//        int numOfItems = 0;
//        List<String> list = new ArrayList<>();
//
//        try {
//            File myObj = new File("C:\\Users\\rjskg\\OneDrive\\Desktop\\input_data\\d_difficult_3.out.txt");
//            Scanner sc = new Scanner(myObj);
//
//            numOfItems = sc.nextInt();
//
//            for(int i = 0 ; i < numOfItems ; i++){
//                list.add(sc.next());
//            }
//            sc.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//
//        int count = 0;
//
//        for(int i = 0 ; i< liked.length ; i++){
//            if(canBuy(liked[i], disliked[i], list)) count++;
//        }
//
//        System.out.println(count);
//
//    }
//
//
//    static boolean canBuy(String[] buyerLikes, String[] buyerDislikes, List<String> target_items){
//        for(String item : buyerLikes){
//            if(item == null || item == "") break;
//            if(!target_items.contains(item)) return false;
//        }
//
//        for (String item : buyerDislikes){
//            if(item == null || item == "") break;
//            else if(target_items.contains(item)) return false;
//        }
//
//        return true;
//    }

}
