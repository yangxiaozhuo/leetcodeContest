package two;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 850. 矩形面积 II
 *
 * @author yangxiaozhuo
 * @date 2022/09/16
 */
public class Main16 {
    class Solution {
        int mod=(int)1e9+7;
        public int rectangleArea(int[][] rectangles) {
            int map1[]=compress(rectangles,0,2),map2[]=compress(rectangles,1,3);
            boolean has[][]=new boolean[map1.length][map2.length];
            for(int i=0;i<map1.length-1;i++){for(int j=0;j<map2.length;j++){has[i][j]=covered(rectangles,i,j);}}
            long ans=0;
            for(int i=0;i<map1.length-1;i++){for(int j=0;j<map2.length-1;j++){if(has[i][j]){ans+=(long)(map1[i+1]-map1[i])*(map2[j+1]-map2[j]);}}}
            return (int)(ans%mod);
        }
        boolean covered(int r[][],int a,int b){
            for(int i=0;i<r.length;i++){if(a>=r[i][0]&&a<r[i][2]&&b>=r[i][1]&&b<r[i][3]){return true;}}
            return false;
        }
        int[] compress(int r[][],int idx1,int idx2){
            TreeSet<Integer> set=new TreeSet<>();
            for(int i=0;i<r.length;i++){
                set.add(r[i][idx1]);
                set.add(r[i][idx2]);
            }
            Map<Integer,Integer> map=new HashMap<>();
            int ans[]=new int[set.size()];
            int p=0;
            for(int a:set){
                ans[p]=a;
                map.put(a,p);
                p++;
            }
            for(int i=0;i<r.length;i++){
                r[i][idx1]=map.get(r[i][idx1]);
                r[i][idx2]=map.get(r[i][idx2]);
            }
            return ans;
        }
    }
}
