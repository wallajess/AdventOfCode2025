

public static void main(String[] args) {

    try {
        List<String> lines = Files.readAllLines(Paths.get("/home/jazz/Documents/adventOfCode/AoC3.txt"));
        String[] banks = lines.toArray(new String[0]);
        long total = 0;
        for (String bank : banks) {
            System.out.println("The bank is: " + bank);
            Joltage joltage = new Joltage(bank);

            int highest = 0;
            int nextHighest = 0;
            long highestJoltage = 0;
            //System.out.println("Highest is: " + highest);

            //Make sure the number is far enough to the front
            String startOfBank = bank.substring(0, bank.length() - 12);
            System.out.println("This is the part we're looking at " + startOfBank);

            //Get the first digit
            highest = joltage.findHighest(startOfBank);

            highestJoltage = highest;

            //Continue on the for the next 11 digits as follows:
            for (int i = 11; i > 0; i--) {
                System.out.println("The index is currently " + i);

                //Get index of current relevant digit (must be turned to string first - should have used an array of digits and iterated over that!!!)
                String highestStr = String.valueOf(highest);
                int index = bank.indexOf(highestStr);

                //Cut bank after that digit
                bank = bank.substring(index+1);

                //If the bank is still long, make sure the digit we need is far enough to the front
                if (bank.length() > i) {

                    String relevantBank = bank.substring(0, bank.length() - i + 1);
                    System.out.println("This is the part we're looking at " + relevantBank);
                    nextHighest = joltage.findNextHighest(relevantBank);
                    highestJoltage = highestJoltage * 10 + nextHighest;
                    System.out.println("The highest joltage is: " + highestJoltage);
                    highest = nextHighest;
                } else {
                    System.out.println("The rest of the bank is relevant because there only this may digits left: " + i);

                    System.out.println("The highest joltage is: " + highestJoltage + " * " + i + " plus the rest of the bank: " + bank);

                    highestJoltage = highestJoltage * (long) (Math.pow(10, i)) + (Long.parseLong(bank));
                    System.out.println("The highest joltage is: " + highestJoltage);
                    break;
                }


                    //Check to make sure the digit isn't too close to the end of the bank for part 1 - first attempt
                    //    while (bank.indexOf(String.valueOf(highest)) >= bank.length()-i) {
                    //        String actualHighest = bank.substring(bank.length()-i);
                    //        highest = joltage.findHighest(actualHighest);
                    //        long nextHighest = joltage.findNextHighest(bank, highest);
                    //        highestJoltage = (highestJoltage * 10) + nextHighest;
                    //
                    //        highest = nextHighest;
                }
                total += highestJoltage;

                System.out.println("The total joltage is: " + total);
            }

    } catch (IOException e) {
        System.out.println("Error reading file");
        }
                }