package dev.McCoy;

public class Main {

    public static boolean ValidateCreditCardNumbers(String nums) {
        //validate nums length
        if(nums.length() <= 14 && nums.length() <= 19){
            return false;
        }

        StringBuilder str = new StringBuilder();
        str.append(nums);
        //remove last digit and save as checkDigit
        int checkDigit = Character.getNumericValue(nums.charAt(nums.length()-1));
        str.deleteCharAt(str.length()-1);
        //reverse the number
        str.reverse();
        //double each digit
        //if result is double digit add both digits
        for (int i =0; i < str.length(); i++){
            if(i%2 == 0){
                int n = Character.getNumericValue(str.charAt(i));
                String value = Integer.toString(n*2);
                if(value.length() > 1){
                    int num1 = Character.getNumericValue(value.charAt(0));
                    int num2 = Character.getNumericValue(value.charAt(1));
                    value = Integer.toString(num1 + num2);
                }
                str.setCharAt(i, value.charAt(0));
            }
        }
        //add all digits in num
        int total = 0;
        for (int i =0; i < str.length(); i++){
            total += Character.getNumericValue(str.charAt(i));
        }
        //subtract the last digit from the sum from 10 and result should equal checkDigit
        String last = Integer.toString(total);
        int lastDigit = Character.getNumericValue(last.charAt(last.length()-1));
        return 10 - lastDigit == checkDigit;
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(ValidateCreditCardNumbers("1234567890123452"));
        System.out.println(ValidateCreditCardNumbers("1234567890123456"));
    }
}
