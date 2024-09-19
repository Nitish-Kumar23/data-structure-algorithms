package leetcode;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        // PAYPALISHIRING N=3
        char[][] arr = new char[numRows][10];
        int strIdx = 0;
        int i=0,j=0;
        while(strIdx<s.length()){
            // iterate down - increase row, same column
            while(i<numRows && strIdx<s.length()){
                arr[i][j] = s.charAt(strIdx++);
                i++;
            }
            i--;
            i--;
            j++;
            //iterate diagnolly up - descrease row,increase column
            while(i>=0 && strIdx<s.length()){
                arr[i][j] = s.charAt(strIdx++);
                i--;
                j++;
            }
            i++;
            i++;
            j--;
        }
        StringBuilder response = new StringBuilder();
        for(int k=0;k<numRows;k++){
            for(int l=0;l<arr[0].length;l++){
                if((arr[k][l]>='A' && arr[k][l]<='Z') || (arr[k][l]>='a' && arr[k][l]<='z') || arr[k][l]==',' || arr[k][l]=='.'){
                response.append(arr[k][l]);
                 }
            }
        }

        return response.toString();
    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",3));
    }

}
//https://leetcode.com/discuss/interview-question/system-design/5073436/System-Design-Template