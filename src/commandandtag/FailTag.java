package commandandtag;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

public class FailTag implements Comparable<FailTag> {
    private final Integer tagNum;
    private final Integer failCnt;

    public FailTag(Integer tagNum, Integer failCnt) {
        this.tagNum = tagNum;
        this.failCnt = failCnt;
    }

    @Override
    public int compareTo(FailTag o) {
        int result = o.failCnt.compareTo(failCnt);
        if(result == 0){
            result = tagNum.compareTo(o.tagNum);
        }
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FailTag.class.getSimpleName() + "[", "]")
                .add("tagNum=" + tagNum)
                .add("failCnt=" + failCnt)
                .toString();
    }
}
