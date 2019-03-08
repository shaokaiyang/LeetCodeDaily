import java.util.Map;
import java.util.Stack;

public class IsValid20 {
    public boolean isValid(String s) {
        int length;
        do{
            length = s.length();
            s = s.replace("()", "").replace("[]","").replace("{}","");
        }while (length != s.length());
        return s.length()==0;
    }

    public boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char aChar : chars){
            if(aChar == '（' || aChar == '{' || aChar == '['){
                stack.push(aChar);
            }else if(stack.size() == 0 || !isSym(stack.pop(), aChar)){
                return false;
            }
        }
        return stack.size()==0;
    }

    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }


}
