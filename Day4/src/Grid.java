import java.util.ArrayList;
import java.util.List;

public class Grid {
    List<List<String>> grid;


    public Grid(List<List<String>> grid) {
        this.grid = new ArrayList<>();
        for (List<String> row : grid) {
            this.grid.add(new ArrayList<>(row));
        }
    }

    public int size() {
        return grid.size();
    }

    public List<String> get(int i) {
        return grid.get(i);
    }

    public void set(int i, int j, String value) {
        grid.get(i).set(j, value);
    }


    public boolean isValid(int row, int col) {
        return row >= 0 && row < grid.size() && col >= 0 && col < grid.get(row).size();
    }

    public int getNumberOfNeighbours(int i, int j) {
        int count = 0;
        //test field to the left
        if (this.isValid(i, j - 1) && (grid.get(i).get(j - 1).equals("@"))) {
            count++;
        }

        //test field to the right
        if (this.isValid(i, j + 1) && (grid.get(i).get(j + 1).equals("@"))) {
            count++;
        }

        //test field above to the left
        if (this.isValid(i - 1, j - 1) && (grid.get(i - 1).get(j - 1).equals("@"))) {
            count++;
        }

        //test field above
        if (this.isValid(i - 1, j) && (grid.get(i - 1).get(j).equals("@"))) {
            count++;
        }

        //test field above to the right
        if (this.isValid(i - 1, j + 1) && (grid.get(i - 1).get(j + 1).equals("@"))) {
            count++;
        }

        //test field to bottom  left
        if (this.isValid(i + 1, j - 1) && (grid.get(i + 1).get(j - 1).equals("@"))) {
            count++;
        }

        //test field below
        if (this.isValid(i + 1, j) && (grid.get(i + 1).get(j).equals("@"))) {
            count++;
        }

        //test field to bottom right
        if (this.isValid(i + 1, j + 1) && (grid.get(i + 1).get(j + 1).equals("@"))) {
            count++;
        }
        System.out.println("Number of neighbours for this field is " + count);
        return count;
    }

    public int numberOfAccessibleRolls() {
        int accessibleRolls = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j).equals("@")) {
                    int numNeighbours = this.getNumberOfNeighbours(i, j);
                    if (numNeighbours < 4) {
                        accessibleRolls++;
                    }
                }
            }
        }
        return accessibleRolls;
    }

    public int removeRoll() {
        int rollsRemoved = 0;

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j).equals("@")) {
                    int numNeighbours = this.getNumberOfNeighbours(i, j);
                    if (numNeighbours < 4) {
                        grid.get(i).set(j, ".");
                        rollsRemoved++;
                    }
                }
            }
        }
        return rollsRemoved;
    }
}
