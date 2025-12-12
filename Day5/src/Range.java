public class Range {
    String range;

    public Range (String range) {
        this.range = range;    }

    public Long findStart() {
        int index = range.indexOf("-");
        return Long.parseLong(range.substring(0, index));
    }

    public Long findEnd() {
        int index = range.indexOf("-");
        return Long.parseLong(range.substring(index + 1));
    }


}
