package commandandtag;

import java.util.StringJoiner;

public class Tag implements Comparable<Tag> {
    private final int id;
    private final boolean valid;

    public Tag(int number) {
        this.id = number;
        this.valid = number >= 1 && number <= 9;
    }

    public void fail() {
        FailHistory.addFailHistory(this);
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

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
