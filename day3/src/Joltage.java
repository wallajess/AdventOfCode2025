public class Joltage {
    String bank;

    public Joltage(String bank) {
        this.bank = bank;
    }

    public int findHighest(String bank) {
        int highest = 0;
        for (int i = 0; i < bank.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(bank.charAt(i)));
            if (digit >= highest) {
                highest = digit;
            }
        }
        System.out.println("Highest digit is: " + highest);
        return highest;
    }

    public int findNextHighest(String restBank
            //, int digit)
    ){
        //String digitstr = String.valueOf(digit);
        //int index = bank.indexOf(digitstr);
        //String restBank = bank.substring(index + 1);
        //System.out.println("The rest of the bank is: " + restBank);
        return findHighest(restBank);
    }
}

