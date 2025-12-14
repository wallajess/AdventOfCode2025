public class IDRange {

    String IDrange;

    public IDRange(String IDrange) {
        this.IDrange = IDrange.trim();    }

    public long findStart() {
        int index = IDrange.indexOf("-");
        return Long.parseLong(IDrange.substring(0, index));
    }

    public long findEnd() {
        int index = IDrange.indexOf("-");
        return Long.parseLong(IDrange.substring(index + 1));
    }

}
