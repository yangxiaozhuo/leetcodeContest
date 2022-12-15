import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author yangxiaozhuo
 * @date 2022/12/11
 */
public class Main03 {
    public static void main(String[] args) {
//        [null,0,12,-1,-1,12,0,0,-1,-1,-1,0,0,0,28,0,0,0,0,12,0,0,-1,0,-1,-1,0,0,0,-1,-1,-1,-1,0,-1,0,0,-1,-1,-1,-1,-1,-1,-1,0,12,0,0]
//        ["Allocator", "allocate", "allocate", "allocate", "free", "allocate", "allocate", "allocate", "free", "allocate", "free"]
        Allocator allocator = new Allocator(10);
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 2));
        System.out.println(allocator.allocate(1, 3));
        System.out.println(allocator.free(2));
        System.out.println(allocator.allocate(3, 4));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.free(1));
        System.out.println(allocator.allocate(10, 2));
        System.out.println(allocator.free(7));
    }

    class Allocator2 {
        int[] cache;

        public Allocator2(int n) {
            cache = new int[n];
        }

        public int allocate(int size, int mID) {
            int l = 0;
            int r = 0;
            while (r < cache.length) {
                while (r < cache.length && cache[r] == 0) {
                    r++;
                }
                if (r - l >= size) {
                    for (int i = l; i < l + size; i++) {
                        cache[i] = mID;
                    }
                    return l;
                }
                while (r < cache.length && cache[r] != 0) {
                    r++;
                }
                l = r;
            }
            return -1;
        }

        public int free(int mID) {
            int res = 0;
            for (int i = 0; i < cache.length; i++) {
                if (cache[i] == mID) {
                    res++;
                    cache[i] = 0;
                }
            }
            return res;
        }
    }
    /**
     * Your Allocator object will be instantiated and called as such:
     * Allocator obj = new Allocator(n);
     * int param_1 = obj.allocate(size,mID);
     * int param_2 = obj.free(mID);
     */
    static class Allocator {
        int[] cache;
        HashMap<Integer, ArrayList<int[]>> map; //mid - [起点，终点]
        PriorityQueue<Integer> start;
        PriorityQueue<Integer> end;

        public Allocator(int n) {
            cache = new int[n];
            map = new HashMap<>();
            start = new PriorityQueue<>();
            end = new PriorityQueue<>();
        }

        public int allocate(int size, int mID) {
            PriorityQueue<Integer> tempStart = new PriorityQueue<>(start);
            PriorityQueue<Integer> tempEnd = new PriorityQueue<>(end);
            Integer poll;
            Integer poll1 = -1;
            while (!start.isEmpty()) {
                poll = start.poll();
                poll1 = end.poll();
                if (!start.isEmpty()) {
                    Integer peek = start.peek();
                    if (peek - poll1 - 1 >= size) {
                        start.addAll(tempStart);
                        end.addAll(tempEnd);
                        start.add(poll1 + 1);
                        end.add(poll1 + size);
                        if (map.containsKey(mID)) {
                            ArrayList<int[]> arrayList = map.get(mID);
                            arrayList.add(new int[]{poll1 + 1, poll1 + size});
                        } else {
                            ArrayList<int[]> arrayList = new ArrayList<>();
                            arrayList.add(new int[]{poll1 + 1, poll1 + size});
                            map.put(mID, arrayList);
                        }
                        return poll1 + 1;
                    }
                }
            }
            start.addAll(tempStart);
            end.addAll(tempEnd);
            if (cache.length - poll1 - 1 >= size) {
                start.add(poll1 + 1);
                end.add(poll1 + size);
                if (map.containsKey(mID)) {
                    ArrayList<int[]> arrayList = map.get(mID);
                    arrayList.add(new int[]{poll1 + 1, poll1 + size});
                } else {
                    ArrayList<int[]> arrayList = new ArrayList<>();
                    arrayList.add(new int[]{poll1 + 1, poll1 + size});
                    map.put(mID, arrayList);
                }
                return poll1 + 1;
            }
            return -1;
        }

        public int free(int mID) {
            if (!map.containsKey(mID)) {
                return 0;
            }
            ArrayList<int[]> ints = map.get(mID);
            map.remove(mID);
            HashSet<Integer> a = new HashSet<>();
            HashSet<Integer> b = new HashSet<>();
            for (int i = 0; i < ints.size(); i++) {
                a.add(ints.get(i)[0]);
                b.add(ints.get(i)[1]);
            }
            int res = 0;
            PriorityQueue<Integer> tempStart = new PriorityQueue<>();
            PriorityQueue<Integer> tempEnd = new PriorityQueue<>();
            while (!start.isEmpty()) {
                Integer poll = start.poll();
                Integer poll1 = end.poll();
                if (!a.contains(poll)) {
                    tempStart.add(poll);
                    tempEnd.add(poll1);
                } else {
                    res = res + poll1 - poll + 1;
                }
            }
            start.addAll(tempStart);
            end.addAll(tempEnd);
            return res;
        }
    }

}
