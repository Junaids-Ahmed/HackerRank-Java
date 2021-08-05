package HackerRank;

//Question Link
//https://www.hackerrank.com/challenges/java-lambda-expressions/problem
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    // Write your code here
    public PerformOperation isOdd() {
        PerformOperation isOdd = (num) -> {
            IntStream x = IntStream.of(num).filter(number -> number % 2 == 0);
            return x.count() > 0 ? false : true;
        };
        return isOdd;
    }

    public PerformOperation isPrime() {
        PerformOperation isPrime = num -> num >1 && IntStream.range(2, num/2).noneMatch(i -> num % i == 0);

        return isPrime;
    }

    public PerformOperation isPalindrome() {
        PerformOperation isPalindrome = (num) -> {
            String number = String.valueOf(num);
            String reversedString = new StringBuilder(number).reverse().toString();

            return number.equals(reversedString) ? true : false;
        };
        return isPalindrome;
    }
}
class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}

