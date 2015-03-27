package com.shuoma;
public class MinInARotatedArrayII{
    public static void main(String[] args) {
        System.out.println(new MinInARotatedArrayII().main());
    }


    public int  main() {
        int[] num = {1, 1, 1};

        int n = num.length;
        int m, l = 0, r = n-1;
        while (l <= r && num[l] >= num[r]) {
          m = l + ((r - l) >> 1);
          // System.out.println(l+" "+r+" "+m);
          if (num[m] > num[r]) l = m+1;
          else {
              if (num[m] == num[r]) r--;
              else r = m;
          }
        }
        return num[l];
    }
}