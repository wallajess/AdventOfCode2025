public class Dial {
    int position;

    Dial(int position) {
        this.position = position;
    }

    public int rotation(String instruction) {

        String direction = instruction.substring(0, 1);
        int distance = Integer.parseInt(instruction.substring(1));

        if (direction.equals("R")) {
            position  = (position + distance) % 100;
        } else {
            position = (position - distance) % 100;
            if (position < 0) {
                position += 100;
            }
        }
        return position;
    }
}
