package MajorityElement;

import java.util.ArrayList;
import java.util.List;

public class nby3 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 3, 2 };
        List<Integer> res = majorityElementTwo(nums);
        System.out.println(res);

    }

    public static List<Integer> majorityElementTwo(int[] nums) {
        int can1 = 0;
        int can2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int n : nums) {
            if (n == can1) {
                count1++;
            } else if (n == can2) {
                count2++;
            } else if (count1 == 0) {
                can1 = n;
                count1++;
            } else if (count2 == 0) {
                can2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == can1) {
                count1++;
            } else if (n == can2)
                count2++;
        }
        if (count1 > nums.length / 3)
            list.add(can1);
        if (count2 > nums.length / 3)
            list.add(can2);
        return list;

    }

}
