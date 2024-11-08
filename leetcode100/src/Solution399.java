import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class Solution399 {
    @Test
    public void test(){
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //  equations元素正序+正序拼接 --> 相乘 ； 正序+逆序拼接 --> 相除 ；查找equations元素的组合，每个元素可以是正序的、逆序的
        //  先把equations的元素化简成最简形式；再用hashmap存equations的元素和与之对应的values元素，正序的、逆序的都存
        //  把问题化简成最简形式，通过hashmap查找，查找的过程中累乘对应的values元素
        HashMap<String,HashMap<String,Double>> hMap=new HashMap<>();
        List<String> simplify=new ArrayList<>();
        for (int i = 0; i < equations.size(); i++) {
            simplify=simplify(equations,i);
            hMap.putIfAbsent(simplify.get(0), new HashMap<>()); 
            hMap.get(simplify.get(0)).put(simplify.get(1), values[i]);
            hMap.putIfAbsent(simplify.get(1), new HashMap<>()); 
            hMap.get(simplify.get(1)).put(simplify.get(0), 1.0/values[i]);
            simplify.clear();
        }
        double[] results=new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            simplify=simplify(queries,i);
            while (true) {
                //hMap.get(simplify.get(0)).
            }
        }
        return null;
    }
    private List<String> simplify(List<List<String>> equations, int i) {
        return null;
    }
}
/*
 * 
399. 除法求值
给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。

注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。

示例 1：

输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
解释：
条件：a / b = 2.0, b / c = 3.0
问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
注意：x 是未定义的 => -1.0
示例 2：

输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
输出：[3.75000,0.40000,5.00000,0.20000]
示例 3：

输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
输出：[0.50000,2.00000,-1.00000,-1.00000]
 */

