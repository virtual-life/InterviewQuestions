import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by pviswanathan on 12/19/15.
 */
public class Solution {
    static HashMap<Character,Character> brackets = new HashMap<Character, Character>();
    static {
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');
    }

    public static boolean balanced(String input){

        Stack<Character> stack  =   new Stack<Character>();
        for (char c : input.toCharArray()){
            if(brackets.containsKey(c)){
                stack.push(c);
            }else if(stack.empty() || brackets.get(stack.pop()) != c){
                return false;
            }
        }
        if(!stack.empty()){
            return false;
        }

        return true;
    }

    public static void main(String args[]){

        String input = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
        }catch (IOException io){
            io.printStackTrace();
        }
        if(balanced(input)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }



    }
}
