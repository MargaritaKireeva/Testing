public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        boolean rez = luckyTicket("123123");
        System.out.println(rez);
    }

    public static boolean luckyTicket(String ticket) {
        if (ticket.length() == 6) {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < ticket.length() / 2; i++) {
                sum1 += ticket.charAt(i) - '0';
            }
            for (int i = ticket.length() / 2; i < ticket.length(); i++) {
                sum2 += ticket.charAt(i) - '0';
            }
            if (sum1 == sum2)
                return true;
            else return false;
        } else {
            return false;
        }
    }
}
