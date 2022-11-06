/**
 * 2424. 最长上传前缀
 *
 * @author yangxiaozhuo
 * @date 2022/10/01
 * <p>
 * 给你一个n个视频的上传序列，每个视频编号为1到n之间的 不同数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 最长上传前缀。
 * 如果闭区间1到i之间的视频全部都已经被上传到服务器，那么我们称 i是上传前缀。最长上传前缀指的是符合定义的 i中的 最大值。
 * 请你实现LUPrefix类：
 * LUPrefix(int n)初始化一个 n个视频的流对象。
 * void upload(int video)上传video到服务器。
 * int longest()返回上述定义的 最长上传前缀的长度。
 */
public class Main02 {
    static class LUPrefix {
        int index = 0;
        int[] arr;

        public LUPrefix(int n) {
            arr = new int[n + 1];
        }

        public void upload(int video) {
            arr[video - 1]++;
            for (int i = index; i < arr.length; i++) {
                if (arr[i] == 0) {
                    index = i;
                    break;
                }
            }
        }

        public int longest() {
            return index;
        }
    }

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
}
