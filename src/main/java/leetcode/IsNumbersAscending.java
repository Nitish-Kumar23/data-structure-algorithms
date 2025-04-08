package leetcode;

class IsNumbersAscending {

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("hello world 5 x 5"));
    }

    public static boolean areNumbersAscending(String s) {
        Integer localMax = Integer.MIN_VALUE;
        for(String str : s.split(" ")){
            if(Character.isDigit(str.charAt(0))){
                Integer val = Integer.parseInt(str);
                if(val>localMax){
                    localMax = val;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}