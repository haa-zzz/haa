package 简单;

import java.util.Scanner;

/*
    给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

    示例:

    输入: 3
    输出: 5
    解释:
    给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/unique-binary-search-trees
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    二叉搜索树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，
                则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树
    分析：动态规划
    设G(n)为n个节点的二叉搜索树的总数，f(i)为以i为根节点的二叉搜索树的总数。则
        G(n) = f(1)+f(2)+....f(n);
    又因为它的左、右子树也分别为二叉排序树则f(i) = G(i-1)*G(n-i);
    所以:G(n) = G(0)*G(n-1)+G(1)*G(n-2)+....+G(n-1)*G(0);
 */
public class 不同的二叉搜索树 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(numTrees(n));
    }
    //方法一：
    /*
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }

     */
    /*方法二：事实上我们在方法一中推导出的 G(n)函数的值在数学上被称为卡塔兰数 Cn
        C0 = 1;
        C(n+1) = 2*(z*n+1)/(n+2)*C(n);

     */
    public static int numTrees(int n) {
        long c = 1;
        for (int i = 0; i < n; i++) {

            c = c * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) c;

    }


}
