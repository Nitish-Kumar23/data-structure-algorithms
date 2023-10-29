package Leetcode;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String lCommonPrefix = strs[0];
        for (int i=1;i<strs.length;i++){
            if(lCommonPrefix.isBlank()){
                return "";
            }
            boolean strSplit = false;
            String strToCheck = strs[i].length() > lCommonPrefix.length() ? strs[i].substring(0,lCommonPrefix.length()) : strs[i];
            for (int j=0;j<strToCheck.length();j++){
                if(strToCheck.charAt(j)!=lCommonPrefix.charAt(j)){
                    strSplit = true;
                    lCommonPrefix = lCommonPrefix.substring(0,j);
                    break;
                }
            }
            if(strSplit!=true){
                lCommonPrefix = lCommonPrefix.substring(0,strToCheck.length());
            }
        }
        return lCommonPrefix;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
