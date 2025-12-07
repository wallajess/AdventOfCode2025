public class Id {
    boolean correct;
    String id;


        public Id(String id){
            this.id = id;
            this.correct = true;

    }

    public long findFalseIDs(long start, long end) {
        long falseIDs = 0;
        for (long i = start; i <= end; i++) {
            String numStr = String.valueOf(i);
            if (numStr.length() % 2 == 0) {
                String firstHalf = numStr.substring(0, numStr.length() / 2);
                String secondHalf = numStr.substring(numStr.length() / 2);
                if (firstHalf.equals(secondHalf)) {
                    long falseId = Long.parseLong(numStr);
                    falseIDs += falseId;
                }
            }
        }
        return falseIDs;
    }

    public String[] splitIntoChunks(int n) {
        return id.split("(?<=\\G.{" + n + "})");
    }


    public String findPattern () {
        String pattern = id.replaceFirst("^(.+?)\\1*$", "$1");
        if (pattern.length() == id.length()) {
            return " ";
        }
        return pattern;
    }

}
