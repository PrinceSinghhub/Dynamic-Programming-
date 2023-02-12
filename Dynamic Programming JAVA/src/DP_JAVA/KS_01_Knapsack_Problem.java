package DP_JAVA;

import java.util.Arrays;

public class KS_01_Knapsack_Problem {
    public static void main(String[] args) {

        int[] item = {1,2,3};
        int[] profit = {10,12,28};
        int[] weight = {1,2,4};

        int W = 6;
        KS01_knapsackProblem(item,profit,weight,W);
    }

    private static void KS01_knapsackProblem(int[] item, int[] profit, int[] weight,int W) {

        int[][] arr = new int[item.length+1][W+1];

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//
//        }

//        todo if weight = 0 or item = 0 then profile = 0 (not need to write this becouse in java already 0 bydefaut in 2d arry)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {

                arr[0][j] = 0;
                arr[i][0] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));

        }

//        todo start store value in our arr
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 1; j < arr[i].length ; j++) {

                if(weight[i-1]<=j){
                    arr[i][j] = Math.max(profit[i-1]+arr[i-1][j-weight[i-1]],arr[i-1][j]);
                }
                else {
                    arr[i][j] = arr[i-1][j];
                }

            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));

        }

        System.out.println("Maximum Profit is: " + arr[arr.length-1][W]);

    }


}
