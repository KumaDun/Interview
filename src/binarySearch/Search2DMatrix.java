package binarySearch;
/*
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。
示例 1：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true
示例 2：


输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false

提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
通过次数314,652提交次数646,333

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/search-a-2d-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int row = 0;
        return searchMatrix(matrix, target, row, col);
    }

    public boolean searchMatrix(int[][] matrix, int target, int row, int col){
        if (row>=matrix.length || col <0){
            return false;
        }
        if (matrix[row][col] == target){
            return true ;
        }
        else if(matrix[row][col]>target){
            return searchMatrix(matrix, target, row, col-1);
        }
        else{
            return searchMatrix(matrix, target, row+1, col);
        }
    }
}
