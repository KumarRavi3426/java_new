package trie;
import java.util.*;

public class trie {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            this.children = new Node[26];
            for(int i=0; i<26; i++){
                children[i] = null;     // need to initialize to null because Node is an object
            }
            this.eow = false;
        }
    }
    static Node root = new Node();      // root is static, so it won't be changed throughout
    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            int idx= word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }
    public static boolean startsWith(String key){
        Node curr = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i)-'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1; i<=key.length(); i++){
            String first = key.substring(0,i);
            String sec = key.substring(i);
            if(search(first) && wordBreak(sec)){
                return true;
            }
        }
        return false;
    }
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int count =0;
        for(int i=0; i<26; i++){    // root.children.length = 26
            if(root.children[i]!=null){
                count+= countNode(root.children[i]);
            }
        }
        return count+1;
    }
    static String ans = "";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null){
             return;
        }
        for(int i=0; i<26; i++){
            if(root.children[i]!=null && root.children[i].eow){
                temp.append((char) (i+'a'));        // typecast _ when adding integer and char, char is typecasted into integer
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);

            }
        }
    }

    public static void main(String[] args) {
//        String[] words = {"the", "a",  "there", "their", "any", "thee"};
//        for(int i=0; i< words.length;i++){
//            insert(words[i]);
//        }
//        System.out.println(search("their"));
//        System.out.println(search("thor"));
//        System.out.println(search(("an")));


//        // word break
//        String[] words = {"i", "like", "sam", "samsung", "mobile"};
//
//        String key ="ilikesung";
//
//        for(int i=0; i< words.length; i++){
//            insert(words[i]);
//        }
//        System.out.println(wordBreak(key));

//        // starts with
//        String[] words = {"apple", "app", "mango", "man", "woman"};
//        String prefix ="man";
//        for(int i=0; i< words.length; i++){
//            insert(words[i]);
//        }
//        System.out.println(startsWith(prefix));


//        // count Unique Substrings
//        String str = "ababa";
//        for(int i=0; i<str.length(); i++){
//            String suffix = str.substring(i);
//            insert(suffix);
//        }
//
//        System.out.println(countNode(root));

        // longestWord
//        // longest Word
//        String[] words = {"a", "banana", "app", "ap", "appl", "apply", "apple" };
//        for(String word : words){
//            insert(word);
//        }
//
//        longestWord(root, new StringBuilder());
//        System.out.println(ans);


    }

}
