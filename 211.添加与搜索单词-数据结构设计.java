/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    Node root; 

    public WordDictionary() {
        root = new Node('a');
    }
    
    public void addWord(String word) {
        
        Node pre = root;
        for (int i = 0;i < word.length();i++) {
            char cur = word.charAt(i);
            Node node = pre.charNodes[cur - 'a'];
            if (node == null) {
                node = new Node(cur);
                pre.charNodes[cur - 'a'] = node;
            }
            pre = node;
        }
        pre.isEnd = true;
    }
    
    public boolean search(String word) {
        
        return search(root, word);
    }
    
    private boolean search(Node nroot, String word) {
        Node curNode = nroot;

        for (int i = 0;i < word.length();i++) {
            char cur = word.charAt(i);
            
            if (cur == '.') {
                if (i == word.length() - 1 ) {
                    for (Node node : curNode.charNodes) {
                        if (node != null && node.isEnd) return true;
                    }
                    return false;
                }

                String sub = word.substring(i + 1);
                for (Node next : curNode.charNodes) {
                    if (next != null && search(next, sub)) {
                        return true;
                    }
                }   
                return false;
            }

            Node node = curNode.charNodes[cur - 'a'];
            if (node == null) {
                return false;
            } else {
                curNode = node;
            }
        }
        
       return curNode.isEnd;
    }

    public static class Node {
        
        char c;
        boolean isEnd;
        Node[] charNodes;
        
        public Node(char c) {
            this.c = c;
            isEnd = false;
            charNodes = new Node[26];
        }
    }
}

 

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

