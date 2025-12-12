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

        int freshItems = 0;
        ArrayList<Long> starts = new ArrayList<>();
        ArrayList<Long> ends = new ArrayList<>();

        for (String string : ranges) {
            Range range = new Range(string);
            starts.add(range.findStart());
            ends.add(range.findEnd());
        }

        for (String stringId: IDs) {
            long id = Long.parseLong(stringId);
            //System.out.println("ID is " + id);
            for (int i = 0; i <= starts.size()-1; i++) {
                Long start = starts.get(i);
                Long end = ends.get(i);
                if (id >= start && id <= end) {
                    freshItems++;
                    break;
                }
            }
        }

        System.out.println("Fresh IDs: " + freshItems);

    } catch (IOException e) {
        System.out.println("Error reading file");
    }
}

