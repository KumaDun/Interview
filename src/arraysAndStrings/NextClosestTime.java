package arraysAndStrings;

import java.util.*;

public class NextClosestTime {
    public String nextClosestTime(String time) {
//        int [] digits = new int[]{-1, -1, -1, -1};
        HashSet<Integer> digits = new HashSet<>();
        for (int i = 0; i<time.length(); i++) {
            if (time.charAt(i) == ':') {
                continue;
            }
            digits.add(Integer.parseInt(time.substring(i, i+1)));
        }
        ArrayList<Integer> digitsList = new ArrayList<>(digits.size());
        for (Integer digit : digits) {
            digitsList.add(digit);
        }
        Collections.sort(digitsList);
        System.out.println(digitsList.toString());

        int minite0 = Integer.parseInt(time.substring(4, 5));
        int indexOfMinite0 = digitsList.indexOf(minite0);
        int minite1 = Integer.parseInt(time.substring(3, 4));
        int indexOfMinite1 = digitsList.indexOf(minite1);
        int hour0 = Integer.parseInt(time.substring(1, 2));
        int indexOfHour0 = digitsList.indexOf(hour0);
        int hour1 = Integer.parseInt(time.substring(0, 1));
        int indexOfHour1 = digitsList.indexOf(hour1);
        int size = digitsList.size();

        if (indexOfMinite0 < size - 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(time.substring(0, 4));
            sb.append(digitsList.get(indexOfMinite0 + 1));
            return sb.toString();
        } else if (indexOfMinite1 < size - 1 && digitsList.get(indexOfMinite1 + 1) <= 5) {
            StringBuilder sb = new StringBuilder();
            sb.append(time.substring(0, 3));
            sb.append(digitsList.get(indexOfMinite1 + 1));
            sb.append(digitsList.get(0));
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder();
            if ((hour1 == 0 || hour1 == 1) && indexOfHour0 < digitsList.size() - 1) {
                sb.append(time.substring(0, 1));
                sb.append(digitsList.get(indexOfHour0 + 1));
                sb.append(':');
                sb.append(digitsList.get(0));
                sb.append(digitsList.get(0));
                return sb.toString();
            } else if ((hour1 == 0 || hour1 == 1) && indexOfHour1 < digitsList.size() - 1) {
                if (digitsList.get(indexOfHour1 + 1) <= 3) {
                    sb.append(digitsList.get(indexOfHour1 + 1));
                } else {
                    sb.append(digitsList.get(0));
                }
                sb.append(digitsList.get(0));
                sb.append(':');
                sb.append(digitsList.get(0));
                sb.append(digitsList.get(0));
            } else if (hour1 == 2  && indexOfHour0 < digitsList.size() -1 ) {
                if (digitsList.get(indexOfHour0 + 1) <= 3) {
                    sb.append(time.substring(0,1));
                    sb.append(digitsList.get(indexOfHour0+1));
                    sb.append(':');
                    sb.append(digitsList.get(0));
                    sb.append(digitsList.get(0));
                } else {
                    sb.append(digitsList.get(0));
                    sb.append(digitsList.get(0));
                    sb.append(':');
                    sb.append(digitsList.get(0));
                    sb.append(digitsList.get(0));
                }
            } else {
                sb.append(digitsList.get(0));
                sb.append(digitsList.get(0));
                sb.append(':');
                sb.append(digitsList.get(0));
                sb.append(digitsList.get(0));
            }
            return sb.toString();
        }
    }
}
