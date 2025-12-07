import java.util.ArrayList;

public class Ids {
    String idRange;

    Ids(String idRange) {
        this.idRange = idRange;    }

    public long findStart() {
        int index = idRange.indexOf("-");
        return Long.parseLong(idRange.substring(0, index));
    }

    public long findEnd() {
        int index = idRange.indexOf("-");
        return Long.parseLong(idRange.substring(index + 1));
    }

    public ArrayList<Id> getIds(long start, long end) {
        ArrayList<Id> ids = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            String numStr = String.valueOf(i);
            Id id = new Id(numStr);
            ids.add(id);
        }
        return ids;
    }
}
