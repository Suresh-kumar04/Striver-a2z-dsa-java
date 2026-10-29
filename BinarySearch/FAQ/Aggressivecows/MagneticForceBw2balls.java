package BinarySearch.FAQ.Aggressivecows;

import java.util.Arrays;

public class MagneticForceBw2balls {
    public static void main(String[] args) {
        //question link : https://leetcode.com/problems/magnetic-force-between-two-balls/
        // In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

// Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

// Given the integer array position and the integer m. Return the required force.
    }
     public int maxDistance(int[] position, int m) {
         Arrays.sort(position);
        int s = 1, e = position[position.length - 1] - position[0];
        while (s <= e) {
            int mid = (s + e) / 2;
            if (canPlace(position, m, mid)) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return e;
    }

    static boolean canPlace(int[] position, int m, int dist) {
        int balls = 1;
        int last = position[0];
        for (int i = 0; i < position.length; i++) {
            if (position[i] - last >= dist) {
                balls++;
                last = position[i];
            }
            if (balls == m) return true;
        }
        return false;
    }
    
}
