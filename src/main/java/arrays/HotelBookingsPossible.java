package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBookingsPossible {
    public class Solution {
        public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
            Collections.sort(arrive);
            Collections.sort(depart);

            int bookings = 0, n = arrive.size(), i = 0, j = 0;
            while (i < n && j < n) {
                if (arrive.get(i) <= depart.get(j)) {
                    i++;
                    bookings++;
                    if (bookings > k) return false;
                } else {
                    bookings--;
                    j++;
                }
            }
            return true;
        }
    }
}
