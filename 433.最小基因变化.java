/*
 * @lc app=leetcode.cn id=433 lang=java
 *
 * [433] 最小基因变化
 */

// @lc code=start
class Solution {
    
    private static final char[] KEYS = new char[]{'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        
        int n = bank.length;

        Set<String> bankSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for (String s : bank) {
            bankSet.add(s);
        }
        
        if (!bankSet.contains(endGene)) {
            return -1;
        } else if (startGene.equals(endGene)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(startGene);

        int step = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();       
            for (int i = 0;i < len;i++) {
                String cur = queue.poll();
                for (int j = 0;j < cur.length();j++) {
                    for (char c : KEYS) {
                        if (cur.charAt(j) != c) {

                            StringBuilder sb = new StringBuilder(cur);
                            sb.setCharAt(j, c);
                            String curr = sb.toString();
                            if (curr.equals(endGene)) return step;
                            if (!visited.contains(curr) && bankSet.contains(curr)) {
                                queue.offer(curr);
                                visited.add(curr);
                            }
                        }
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}
// @lc code=end

