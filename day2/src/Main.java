public static void main(String[] args) {
    try {
        BufferedReader in = new BufferedReader(new FileReader("/home/jazz/Documents/adventOfCode/AoC2.txt"));
        String line = in.readLine();
        String[] idRange = line.split(",");
        long total = 0;
        for (String range : idRange){
            Ids ids = new Ids(range);
            long start = ids.findStart();
            long end = ids.findEnd();
            ArrayList<Id> listOfIds = ids.getIds(start, end);

            for (Id id : listOfIds) {
                String pattern = id.findPattern();
                String[] units = id.splitIntoChunks(pattern.length());
                for (String unit : units){
                    if (unit.equals(pattern)){
                        id.correct = false;
                        break;
                    }
                }
                if (! id.correct){
                    total += Long.parseLong(id.id);
                }
            }
            }

        System.out.println("Total IDs: " + total);

    } catch (IOException e) {
        System.out.println("Error reading file");
    }
}
