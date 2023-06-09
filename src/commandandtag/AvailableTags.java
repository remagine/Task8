package commandandtag;

import java.util.TreeSet;

public class AvailableTags {
    private static final TreeSet<Tag> availableTags = new TreeSet<>();

    static {
        for (int i = 1; i < 10; i++) {
            availableTags.add(new Tag(i));
        }
    }

    public static void getMinTag() {
        Tag minTag = availableTags.pollFirst();
        if (minTag == null) {
            minTag = new Tag(0);
            minTag.fail();
        }
    }

    public static void addTag(Tag tag) {
        if (!availableTags.add(tag)) {
            tag.fail();
        }
    }

    public static void print() {
        System.out.println(availableTags);
    }
}
