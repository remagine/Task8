package commandandtag;

public class Tag implements Comparable<Tag> {
    private final int id;
    private final boolean valid;

    public Tag(int number) {
        this.id = number;
        this.valid = number >= 1 && number <= 9;
    }

    private void fail(int number) {
        FailHistory.addFailMap(number);
    }

    public void fail() {
        FailHistory.addFailMap(id);
    }

    public static void printHistory() {
        FailHistory.printCreateFailCnt();
        AvailableTags.print();
        FailHistory.print();
    }

    @Override
    public int compareTo(Tag o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return id == tag.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void execute() {
        if (valid) {
            AvailableTags.addTag(this);
        } else {
            fail();
        }
    }

    public void create() {
        AvailableTags.getMinTag();
    }
}
