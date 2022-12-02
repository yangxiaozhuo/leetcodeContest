package three;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 01.08. 零矩阵
 *
 * @author yangxiaozhuo
 * @date 2022/09/30
 */
public class Main30 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            int[][] temp = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j]==0) {
                        temp[i][j] = 1;
                    }
                }
            }
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix[0].length; j++) {
                    if(temp[i][j] == 1){
                        for(int k = 0; k < matrix.length; k++) {
                            matrix[k][j] = 0;
                        }
                        for(int k = 0; k < matrix[0].length; k++) {
                            matrix[i][k] = 0;
                        }
                    }
                }
            }
        }
    }
}
