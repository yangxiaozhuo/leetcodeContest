package text01;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yangxiaozhuo
 * @date 2023/02/09
 */
public class Main09 {
}

class AuthenticationManager {
    HashMap<String, Integer> map = new HashMap<>();
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer orDefault = map.getOrDefault(tokenId, -1);
        if (currentTime >= orDefault) {
            map.remove(tokenId);
            return;
        }
        map.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        ArrayList<String> list = new ArrayList<>();
        map.forEach(((s, integer) -> {
            if (integer <= currentTime) {
                list.add(s);
            }
        }));
        for (String s : list) {
            map.remove(s);
        }
        return map.size();
    }
}