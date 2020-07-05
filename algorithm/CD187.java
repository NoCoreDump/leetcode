package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @author sunwb
 * @version 1.0.0
 * @ClassName CD187.java
 * @Description 派对的最大快乐值 https://www.nowcoder.com/practice/a5f542742fe24181b28f7d5b82e2e49a?tpId=101&&tqId=33255&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * 整个公司的人员结构可以看作是一棵标准的多叉树。树的头节点是公司唯一的老板，除老板外，每个员工都有唯一的直接上级，叶节点是没有任何下属的基层员工，除基层员工外，每个员工都有一个或多个直接下级，另外每个员工都有一个快乐值。
 * 这个公司现在要办 party，你可以决定哪些员工来，哪些员工不来。但是要遵循如下的原则：
 * 1.如果某个员工来了，那么这个员工的所有直接下级都不能来。
 * 2.派对的整体快乐值是所有到场员工快乐值的累加。
 * 3.你的目标是让派对的整体快乐值尽量大。
 * 给定一棵多叉树，请输出派对的最大快乐值。
 * @createTime 2020年06月22日
 */


public class CD187 {
    /*输入描述:
    第一行两个整数 n 和 root，n 表示公司的总人数，root 表示公司的老板。
    第二行 n 个整数 happy_i 表示员工 i 的快乐值。
    接下来 n - 1 行每行两个整数 u_i 和 v_i 表示 u_i 是 v_i 的直接上级。
    输出描述:
    输出一个整数表示最大快乐值。

    输入
    3 1
    5 1 1
    1 2
    1 3
    输出
    5
    */
    public static void DFS(ArrayList<Integer>[] arr, int[] happy, int root,int[][] dfs){
        dfs[root][0] = 0;//领导不去
        dfs[root][1] = happy[root];//领导去，则快乐值至少为自己快乐值
        if(arr[root]!=null){
            for(int i=0;i<arr[root].size();i++){
                int j = arr[root].get(i);
                DFS(arr,happy,j,dfs);
                dfs[root][0] += Math.max(dfs[j][0],dfs[j][1]);
                dfs[root][1] += dfs[j][0];
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int num = Integer.parseInt(str1[0]);//公司总人数
        int N = num + 1;
        int root = Integer.parseInt(str1[1]);//根节点
        String[] str2 = br.readLine().split(" ");
        int[] happy = new int[N];
        for(int i=0;i<num;i++){
            happy[i+1] = Integer.parseInt(str2[i]);//每个员工的快乐值
        }
        ArrayList<Integer>[] arr = new ArrayList[N];
        for(int i=0;i<num-1;i++){
            String[] str = br.readLine().split(" ");
            int u = Integer.parseInt(str[0]);//起点
            int v = Integer.parseInt(str[1]);//终点
            if(arr[u] == null){
                arr[u] = new ArrayList<>();
            }
            arr[u].add(v);
        }
        int[][] dfs = new int[arr.length][2];
        DFS(arr,happy,root,dfs);
        System.out.println(Math.max(dfs[root][0],dfs[root][1]));
    }
}
