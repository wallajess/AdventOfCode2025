import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/jazz/Documents/adventOfCode/AoC1.txt"));
            String[] directions = lines.toArray(new String[0]);

            Dial dial = new Dial(50);
            int numZeros = 0;

            for (String instruction : directions) {

                //Remove BOM
                instruction = instruction.replace("\uFEFF", "").trim();

                //Determine position prior to rotation
                int oldPos = dial.position;

                //What direction it will turn
                char direction =  instruction.charAt(0);

                //How many clicks it will make
                int dist = Integer.parseInt(instruction.substring(1));

                //Position after turning
                dial.rotation(instruction);

                //To account for numbers over 100
                numZeros += dist/100;

                int partialDist = dist % 100;

                if (direction == 'R' && (partialDist + oldPos) > 99) {
                        numZeros++;
                    } else if (direction == 'L' && (oldPos - partialDist) < 1) {
                        if (oldPos != 0) {
                            numZeros++;
                        }
                    }
                }

            System.out.println("The password is: " + numZeros);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }


