package Arrays.ReapetingAndMissing;

public class RepeatingAndMissing {
    public static void main(String[] args) {

    }

    public int[] findMissingRepeatingNumbers(int[] nums) {
        long n = nums.length;
        long eSum = n * (n + 1) / 2;
        long eSqrSum = n * (n + 1) * (2 * n + 1) / 6;

        long sqrSum = 0;
        long sum = 0;
        for (int x : nums) {
            sum = (long) sum + x;
            sqrSum = (long) sqrSum + (long) x * x;
        }
        long sumDiff = eSum - sum; // x-y
        long sqrDiff = eSqrSum - sqrSum;// x^2 - y^2 -> (x-y)(x+y)
        long xPlusy = sqrDiff / sumDiff;// x +y

        long missing = (sumDiff + xPlusy) / 2;// x
        long repeating = xPlusy - missing;// y

        return new int[] { (int) repeating, (int) missing };
    }

}
