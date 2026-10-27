package Arrays;

public class MaximumProduct {
    public static void main(String[] args) {
        // drop prefix or suffix
        // ---------------------->
        // <----------------------
        // why need both prefx and suffix? for odd number of negative numbers in the
        // array
        // eg: [-12,3,99,0,1] -> prefix = -12*3*99=3564 , suffix = 1*0*99=0
        // if we only take prefix then we will get 3564 but if we take suffix then we
        // will get 0 which is less than 3564 so we need both prefix and suffix to get
        // the maximum product

        // the explanation is that if we have an odd number of negative numbers in the
        // array then the product of all the numbers will be negative and we need to
        // drop one negative number to get the maximum product so we need both prefix
        // and suffix to get the maximum product

        int[] nums = { -12, 3, 99, 0, 1 };
        int prefix = 1, suffix = 1;
        int n = nums.length;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            res = Math.max(res, Math.max(prefix, suffix));
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0)
                suffix = 1;
        }
        System.out.println(res);
    }

}
