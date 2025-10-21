package Hashing;
import java.util.*;

public class TicketsItinerary {
    // Won't give result when a source has multiple destinations associated with it
    private static String getStart(Map<String, String> destMap) {
        Map<String, String> srcMap = new HashMap<>();

        for(String key: destMap.keySet()) {
            srcMap.put(destMap.get(key), key);
        }

        for(String key: destMap.keySet()) {
            if(!srcMap.containsKey(key)) {
                return key;
            }
        }

        return null;  //Ideally program control shouldn't come here
    }

    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, String> destMap = new HashMap<>();
        for(List<String> ls: tickets) {
            destMap.put(ls.get(0), ls.get(1));
        }

        String st = getStart(destMap);
        List<String> res = new ArrayList<>();
        res.add(st);

        for(int i = 0; i < tickets.size(); i++) {
            res.add(destMap.get(st));
            st = destMap.get(st);
        }

        return res;
    }

    public static void main(String[] args) {
        List<List<String>> ls = new ArrayList<>();
        ls.add(new ArrayList<>(Arrays.asList("Chennai", "Bengaluru")));
        ls.add(new ArrayList<>(Arrays.asList("Mumbai", "Delhi")));
        ls.add(new ArrayList<>(Arrays.asList("Goa", "Chennai")));
        ls.add(new ArrayList<>(Arrays.asList("Delhi", "Goa")));

        List<String> res = findItinerary(ls);
        System.out.println(res);
    }
}
