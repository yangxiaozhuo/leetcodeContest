package three;

/**
 * 901. 股票价格跨度
 *
 * @author yangxiaozhuo
 * @date 2022/10/21
 */
public class Main21 {
    class StockSpanner {
        int[] nums;
        int l;
        int r;

        public StockSpanner() {
            nums = new int[10010];
            l = 0;
            r = 0;
        }

        public int next(int price) {
            if (nums[r] > price) {
                nums[++r] = price;
                l = r - 1;
                return 1;
            } else if (nums[r] == price) {
                nums[++r] = price;
                return r - l;
            } else {
                nums[++r] = price;
                while (l > 0 && nums[l] <= price) {
                    l--;
                }
                return r - l;
            }
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 **/
}
