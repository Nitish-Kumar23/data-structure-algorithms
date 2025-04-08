package leetcode;

public class EquilibriumIndex {

    public static void main(String[] args) {
        System.out.println(equilibriumIndex(new int[]{-7, 1, 5, 2, -4, 3, 0}));
    }

    private static int equilibriumIndex(int[] arr) {
        if(arr==null || arr.length==0){
            return -1;
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[arr.length - 1] - arr[0] == 0) {
                    return 0;
                }
                continue;
            }
            int left = arr[i - 1];
            int right = arr[arr.length - 1] - arr[i];
            if (left == right) {
                return i;
            }

        }

        return -1;
    }

}