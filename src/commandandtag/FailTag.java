package commandandtag;

import java.util.StringJoiner;

public class FailTag implements Comparable<FailTag> {
    private final Tag tag;
    private final Integer failCnt;

    public FailTag(Tag tag, Integer failCnt) {
        this.tag = tag;
        this.failCnt = failCnt;
    }

    @Override
    public int compareTo(FailTag o) {
        int result = o.failCnt.compareTo(failCnt);
        if(result == 0){
            result = tag.compareTo(o.tag);
        }
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FailTag.class.getSimpleName() + "[", "]")
                .add("tag=" + tag)
                .add("failCnt=" + failCnt)
                .toString();
    }
}
