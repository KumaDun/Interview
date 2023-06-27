public class PhoneNumberReformat {
    public String solution(String s){
        String digits = null;
        try {
            digits = filter(s);
        } catch (Exception e) {
            System.out.println("Input String is null");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int remainingLength;
        while(true){
            remainingLength = digits.length()- i;
            if (remainingLength >4){
                sb.append(digits.substring(i,i+3));
                sb.append('-');
                i = i + 3;
            }
            if (remainingLength == 4){
                sb.append(digits.substring(i,i+2));
                sb.append('-');
                sb.append(digits.substring(i+2));
                break;
            }
            if (remainingLength <= 3){
                sb.append(digits.substring(i));
                break;
            }
        }
        return sb.toString();
    }

    public String filter(String s) throws Exception {
        if (s == null) {
            throw new Exception();
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ' && c != '-'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
