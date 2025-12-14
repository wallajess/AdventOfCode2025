import java.util.HashSet;
import java.util.Set;

public static void main(String[] args) {

    try {
        List<String> lines = Files.readAllLines(Paths.get("/home/jazz/Documents/adventOfCode/AoC5.txt"));
        List<String> ranges = new ArrayList<>();
        List<String> IDs = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()){
                index = i;
                break;
            }
            ranges.add(lines.get(i));
        }

        for (int i = index+1; i < lines.size(); i++) {
            IDs.add(lines.get(i));
        }
        //int freshItems = 0; //Part 1
        ArrayList<Long> starts = new ArrayList<>();
        ArrayList<Long> ends = new ArrayList<>();

        ArrayList<Long> sortedByStart = new ArrayList<>();

        //Sort ranges using merge sort
        MergeSort.mergeSort(ranges, 0, ranges.size()-1);

        int i = 0;
        while (i < ranges.size()-1) {
                    IDRange IDRange1 = new IDRange(ranges.get(i));
            IDRange IDRange2 = new IDRange(ranges.get(i+1));
            long start1 = IDRange1.findStart();
            long end1 = IDRange1.findEnd();
            long start2 = IDRange2.findStart();
            long end2 = IDRange2.findEnd();
            if (end1 >= start2) {
                long newEnd = Math.max(end1, end2);
                ranges.set(i, (start1 + "-" + newEnd));
                ranges.remove(i+1);
            } else {
                i++;
            }
        }

        Long totalIDs = 0L;
        for (String range : ranges) {
            IDRange IDRange = new IDRange(range);
            totalIDs += (IDRange.findEnd() - IDRange.findStart() +1);
        }


        System.out.print("Total fresh: " + totalIDs);

        //First guess: 312456880321056 (too low)

        //For part 1
        //for (String stringId: IDs) {
        //    long id = Long.parseLong(stringId);
        //    //System.out.println("ID is " + id);
        //    for (int i = 0; i <= starts.size()-1; i++) {
        //        Long start = starts.get(i);
        //        Long end = ends.get(i);
        //        if (id >= start && id <= end) {
        //            freshItems++;
        //            break;
        //        }
        //    }
        //}
        //System.out.println("Fresh IDs: " + freshItems);
        //System.out.println("Number of fresh IDs: " + freshIDs.size());
    } catch (IOException e) {
        System.out.println("Error reading file");
    }
}

