package lintcode.ladder9.level2;

import java.util.ArrayList;
import java.util.HashMap;

public class Q132WordSearchII {
	
	public static void main(String[] args) {
		char[][] a = new char[3][4];
//		a[0] = new char[]{'d','o','a','f'};
//		a[1] = new char[]{'a','g','a','i'};
//		a[2] = new char[]{'d','c','a','n'};
		
		
		ArrayList<String> dic = new ArrayList<String>();
//		dic.add("dog");
//		dic.add("dad");
//		dic.add("dgdg");
//		dic.add("can");
//		dic.add("again");
		dic.add("abceseeefs");
		dic.add("abceseedasfe");
		//dic.add("se");
		char[][] x = new char[3][4];
		String s1 = "abce";
		String s2 = "sfes";
		String s3 = "adee";
		
		x[0] = s1.toCharArray();
		x[1] = s2.toCharArray();
		x[2] = s3.toCharArray();
		
		System.out.println(wordSearchII(x, dic));
	}
	
	
	/**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        
        TrieNode dic = new TrieNode(' ');
        
        for(String word:words) {
            dic.addWord(word);
        }
        
        ArrayList<String> res = new ArrayList<String>();
        
        if(board==null||board.length==0||board[0].length==0) return res;
        
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board,i,j,dic,res,"",isVisited);
            }
        }
        return res;
        
    }
    
    
    public static void dfs(char[][] board, int i, int j, TrieNode dic, ArrayList<String> res, String curStr, boolean[][] isVisited) {
    
        char c = board[i][j];
        
        //f**k myself!!!! put the following after isVisited[i][j] = true;
//        if(dic.isLeaf &&!dic.isVisited) {
//            dic.isVisited = true;
//            res.add(curStr);
//        }
        
        if(!dic.children.containsKey(c)) return;
        
        isVisited[i][j] = true;
        dic = dic.children.get(c);
        curStr += c;
        
        if(dic.isLeaf&&!dic.isVisited) {
            dic.isVisited = true;
            res.add(curStr);
        }
        
        int[][] indices = new int[2][2];
        indices[0] = new int[]{0,0,1,-1};
        indices[1] = new int[]{1,-1,0,0};
        
        
        for(int m=0; m<4; m++) {
            int rIndex = i+indices[0][m];
            int cIndex = j+indices[1][m];
            
            if(rIndex>=0&&rIndex<board.length&&cIndex>=0&&cIndex<board[0].length&&
            !isVisited[rIndex][cIndex]) {
                dfs(board, rIndex, cIndex, dic, res, curStr, isVisited);
            }
        }
        isVisited[i][j] = false;
           
    }
    
    
    
    static class TrieNode {
        char ch;
        boolean isLeaf;
        boolean isVisited; //to store if the word is found already
        HashMap<Character,TrieNode> children;
        
        public TrieNode(char c) {
            this.ch = c;
            this.children = new HashMap<Character,TrieNode>();
            this.isLeaf = false;
            this.isVisited = false;
        }
        
        public void addWord(String word) {
            int i=0;
            HashMap<Character, TrieNode> p = children;
            
            while(i<word.length()) {
                char c = word.charAt(i);
                if(!p.containsKey(c)) p.put(c, new TrieNode(c));
                
                if(i==word.length()-1) p.get(c).isLeaf = true;
                p = p.get(c).children;
                i++;
            }
        }
    }

}
