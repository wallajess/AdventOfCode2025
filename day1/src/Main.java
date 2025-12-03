import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public static void main(String[] args) {

        try {
            List<String> lines = Files.readAllLines(Paths.get("/home/jazz/Documents/adventOfCode/AoC1_test.txt"));
            String[] directions = lines.toArray(new String[0]);

            Dial dial = new Dial(50);
            int numZeros = 0;

            for (String instruction : directions) {
                instruction = instruction.replace("\uFEFF", "").trim();

                int oldPos = dial.position;

                int dist = Integer.parseInt(instruction.substring(1));

                int numRotations =  dist / 100;
                numZeros += numRotations;

                if (dial.rotation(instruction) == 0) {
                    numZeros++;
                }
                if (instruction.charAt(0) == 'R' && ((Integer.parseInt(instruction.substring(1)) % 100) + oldPos) > 99) {
                    numZeros++;
                } else if (instruction.charAt(0) == 'L' && ((Integer.parseInt(instruction.substring(1)) %100) - oldPos) < 1) {
                    numZeros++;
                }

            }
            System.out.println("The password is: " + numZeros);

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }


