package easy;

public class TimeConversion {
    public static String timeConversion(String s) {
        // Write your code here
        String[] splited = s.split(":");
        int hour = Integer.parseInt(splited[0]);
        int minute = Integer.parseInt(splited[1]);
        int second = Integer.parseInt(splited[2].substring(0, 2));
        String day = splited[2].substring(2);
        String hourString = "";
        System.out.println(hour + " " + minute + " " + second + " " + day);

        if (day.equals("PM") && hour < 12) {
            hour += 12;
            hourString = String.valueOf(hour);
        } else if (day.equals("AM") && hour == 12) {
            hour = 0;
            hourString = "00";
        } else {
            hourString = splited[0];
        }
        System.out.println(hourString + " " + minute + " " + second + " " + day);
        return String.valueOf(hour) + ":" + splited[1] + ":" + splited[2].substring(0, 2);
    }

    public static void main(String[] args) {
        System.out.println(TimeConversion.timeConversion("04:59:59AM"));
    }
}
