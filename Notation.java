
public class Notation {


	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException{
		
		double result;
		MyStack<Double> stack= new MyStack<>();
		
		for(int i =0; i< postfixExpr.length();++i ) {
			
			if(postfixExpr.charAt(i)==' ') {
				continue;
			}
			if(Character.isDigit(postfixExpr.charAt(i))) {
				stack.push(Double.parseDouble(Character.toString(postfixExpr.charAt(i))));
			}
			
			if(postfixExpr.charAt(i)=='-' || postfixExpr.charAt(i)=='+' || postfixExpr.charAt(i)=='*'|| postfixExpr.charAt(i)=='/') {
				if(stack.size()<2) {
					throw new InvalidNotationFormatException();
					
				}
				double right= stack.pop();
				double left= stack.pop();
				
				if(postfixExpr.charAt(i)=='+') {
					result=left+right;
				}else if(postfixExpr.charAt(i)=='-') {
					result=left-right;
				}else if(postfixExpr.charAt(i)=='*') {
					result=left*right;
				}else if(postfixExpr.charAt(i)=='/') {
					result=left/right;
				}else {
					throw new InvalidNotationFormatException();
				}
				stack.push(result);
			}
		}
		if(stack.size()!=1) {
			throw new InvalidNotationFormatException(); 
			
		}
		return stack.pop();

	

	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException{
		String prefix="";
		MyStack<String> stack= new MyStack<>();
		
		for(int i=0;i<postfix.length();++i) {
			
			if(postfix.charAt(i)==' ') {
				continue;
			}
			if(Character.isDigit(postfix.charAt(i))) {
				stack.push(Character.toString(postfix.charAt(i)));
				
			}
			if(postfix.charAt(i)=='+' || postfix.charAt(i)=='-' || postfix.charAt(i)=='*' || postfix.charAt(i)=='/') {
				
				if(stack.size()<2) {
					throw new InvalidNotationFormatException();
				}
				String second=stack.pop();
				String first=stack.pop();
				
				String expression="("+ first+ postfix.charAt(i)+ second+")";
				stack.push(expression);
			}
			
			
		}
		if(stack.size()!=1) {
			throw new InvalidNotationFormatException();
		}
		return stack.pop();

	}
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

	    String postfix = "";
	    MyStack<Character> stack = new MyStack<>();

	    for (int i = 0; i < infix.length(); ++i) {

	        char c = infix.charAt(i);

	        if (c == ' ') {
	            continue;
	        }

	        if (Character.isDigit(c)) {
	            postfix += c;
	        } else if (c == '(') {
	            stack.push(c);
	            
	        } else if (c == '*' || c == '/' || c=='-' || c=='+') {
	           while(!stack.isEmpty() && (precedence(c)<=precedence(stack.top()))) {
	        	   postfix += stack.pop();
	           }
	   
	            stack.push(c);
	        } else if (c == ')') {
	            while (!stack.isEmpty() && stack.top() != '(') {
	                postfix += stack.pop();
	            }
	            if (stack.isEmpty()) {
	                throw new InvalidNotationFormatException();
	            }
	            stack.pop();
	       
	        }
	    }

	    while (!stack.isEmpty()) {
	        char c = stack.pop();
	        if (c == '(') {
	            throw new InvalidNotationFormatException();
	        }
	        postfix += c;
	    }

	    return postfix;
	}
	
	public static int precedence(char c) {
		if(c=='-' || c=='+') {
			return 1;
		}else if (c=='*' || c=='/'){
			return 2;
			
		}
		
		return 0;
		
	}
	


}
