package commandandtag;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class FailHistory {
    private static final ConcurrentHashMap<Tag, Integer> FAIL_HISTORY = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Integer> FAIL_MAP = new ConcurrentHashMap<>();

    public static void addFailHistory(Tag tag) {
        Integer failCnt = FAIL_HISTORY.putIfAbsent(tag, 1);
        if (failCnt != null) {
            FAIL_HISTORY.put(tag, ++failCnt);
        }
    }

    public static void print() {
        Map<Integer, Integer> copiedMap = new HashMap<>(FAIL_MAP);
        copiedMap.remove(0);

        TreeSet<FailTag> failTags = new TreeSet<>();
        copiedMap.forEach((key, value) -> failTags.add(new FailTag(key, value)));

        System.out.println(failTags);
    }

    public static void addFailMap(int number) {
        Integer failCnt = FAIL_MAP.putIfAbsent(number, 1);
        if (failCnt != null) {
            FAIL_MAP.put(number, ++failCnt);
        }
    }

    public static void printCreateFailCnt() {
        Map<Integer, Integer> copiedMap = new HashMap<>(FAIL_MAP);
        int createFailCnt = copiedMap.getOrDefault(0, 0);
        System.out.println(createFailCnt);
    }
}
