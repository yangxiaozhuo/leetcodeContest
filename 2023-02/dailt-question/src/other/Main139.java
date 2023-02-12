package other;

import com.sun.jndi.ldap.pool.Pool;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.HashSet;
import java.util.List;

/**
 * @author yangxiaozhuo
 * @date 2023/02/02
 */
public class Main139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j,i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
