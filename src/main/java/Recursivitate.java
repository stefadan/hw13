    public class Recursivitate {

        public static void main(String[] args) {
            int result = sumOfNumbers(5);
            System.out.println("Sum of first numbers "+result);
            int resulta = firstEvenIntegers(8);
            System.out.println("Sum of first even numbers " + resulta);
            String res = recursiveReversePalindrom("lupul");
            System.out.println("Reverse palindom: "+res);
            boolean resPalindom = isPalindrome("lupul");
            System.out.println(" String + "+ resPalindom + " Is palindom: "+resPalindom);
            Long sum = sumOfNumberDigits(Long.valueOf(11111));
            System.out.println("sum=" + sum);
            int fibo = fiboArray(8);
            System.out.println("fibo=" + fibo);
        }

        //1) sum of first n integer numbers
        public static int sumOfNumbers(int n) {
            if (n < 0) return 1;
            else
                return n + sumOfNumbers(n - 1);
        }

        //2) sum of first n EVEN integers
        public static int firstEvenIntegers(int n) {
            int result = 0;
            if (n < 2)
                return 0;
            else if (n % 2 == 0) {
                //System.out.println("n="+n+"  "+firstEvenIntegers(n - 2));
                result = n + firstEvenIntegers(n - 2);
            }
            return result;
        }

        //3) Palindrome: a word that reads the same backwards as forwards, e.g. madam or ana
        //3.1) recursive string reverse
        public static String recursiveReversePalindrom(String sir) {
            //System.out.println(sir.length());
            if (sir.length() == 0) {
                return "";
            }
            //System.out.println(sir.substring(sir.length()-1) + recursiveReverse(sir.substring(0, sir.length()-1)));
            return sir.substring(sir.length() - 1) + recursiveReversePalindrom(sir.substring(0, sir.length() - 1));

        }

        //3.2) recursive check of first and last letter
        public static boolean isPalindrome(String s) {
            return s.length() <= 1 ||
                    (s.charAt(0) == s.charAt(s.length() - 1) &&
                            isPalindrome(s.substring(1, s.length() - 1)));
        }

        //4) sum of digits for a number
        public static Long sumOfNumberDigits(Long n) {
            Long result;
            if (n == 0) {
                return Long.valueOf(0);
            }
            result = (n % 10) + sumOfNumberDigits(n / 10);
            return result;
        }

        //5) fibonacci array
        public static int fiboArray(int n) {

            int res[] = new int[n + 1];
            res[0] = 0;
            if (n > 0) {
                res[1] = 1;
                for (int i = 2; i <= n; i++) {
                    res[i] = res[i - 1] + res[i - 2];
                }
            }
            return res[n - 1];
        }

    }

