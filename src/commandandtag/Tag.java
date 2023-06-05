package commandandtag;

public class Tag implements Comparable<Tag> {
    private final int id;

    public Tag(int number) {
        if (number < 0 || number > 9) {
            this.id = 0;
            fail(number);
        } else {
            this.id = number;
        }
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
        if (id != 0) {
            AvailableTags.addTag(this);
        }
    }

    public void create() {
        AvailableTags.getMinTag();
    }
}
