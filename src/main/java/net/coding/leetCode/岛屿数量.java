package net.coding.leetCode;



import main.java.net.coding.Pair;

import java.util.LinkedList;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 *  
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 岛屿数量 {

	/**
	 * 思路: 广度优先, 如果遇到某个为 1, 通过一个队列,找出与它相邻的所有节点, 并重置为 0, 避免重复判断
	 * <p>
	 *
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		final int rows = grid.length;
		final int lines = grid[0].length;
		int landSum = 0;
		//遍历每个节点
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < lines; j++) {
				char land = grid[i][j];
				if ('0' == land) {
					continue;
				}
				//找到岛屿,总数+1, 开始广度查找(四面八方都找一遍)
				landSum++;
				final LinkedList<Pair<Integer, Integer>> queues = new LinkedList<>();
				queues.add(new Pair<Integer, Integer>(i, j));
				while (!queues.isEmpty()) {
					final Pair<Integer, Integer> pair = queues.poll();
					final Integer row = pair.getKey();
					final Integer line = pair.getValue();
					//重置当前节点为 0,避免重复判断,以后再循环到可以不计算了
					grid[row][line] = '0';
					//上下左右四个方向查找
					//下方,基于当前 pair 的下面一个元素
					//摸到了就重置为 0,避免增加复杂度
					if (row < rows - 1 && '1' == grid[row + 1][line]) {
						queues.add(new Pair<>(row + 1, line));
						grid[row+1][line] = 0;
					}
					//上
					if (row > 0 && '1' == grid[row - 1][line]) {
						queues.add(new Pair<>(row - 1, line));
						grid[row-1][line] = 0;
					}
					//左边
					if (line > 0 && '1' == grid[row][line - 1]) {
						queues.add(new Pair<>(row, line - 1));
						grid[row][line-1] = 0;
					}
					//右边
					if (line < lines - 1 && '1' == grid[row][line + 1]) {
						queues.add(new Pair<>(row, line + 1));
						grid[row][line+1] = 0;
					}
				}
			}
		}
		return landSum;
	}

	public static void main(String[] args) {
		final 岛屿数量 obj = new 岛屿数量();
		final char[][] chars = new char[3][];
		chars[0] = new char[]{'1', '1', '1', '1', '0'};
		chars[1] = new char[]{'1', '1', '0', '1', '0'};
		chars[2] = new char[]{'0', '0', '1', '0', '0'};
		System.out.println(obj.numIslands(chars));
	}

}
