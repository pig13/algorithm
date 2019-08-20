package demo;

import java.util.Stack;

/**
 * @author whj
 *
 */

public class ReversePolish {

	/**
	 * 逆波兰式，后缀表达式运算 支持+-*%/()运算，支持正负号，必须保证输入表达式合法，否则可能报错
	 * 
	 * @param expresion
	 * @return
	 */
	public static String cal(String expresion) {
		// 预处理表达式，预处理表达式，正、负号前加S(如果一个加号（减号）出现在最前面 或左括号 后面，则该加号（减号） 为正负号) 。
		if (expresion.startsWith("+")) {
			expresion = expresion.substring(1);
		}
		if (expresion.startsWith("-")) {
			expresion = "S" + expresion;
		}
		expresion = expresion.replace("(+", "(");
		expresion = expresion.replace("(-", "(S-");
		// 预处理结束
		String result = null;
		Stack<String> stackTmp = new Stack<String>();
		Stack<String> stackMain = new Stack<String>();
		stackTmp.push("#");
		String tmp = "";
		boolean isS = false; // 是否是正负号
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (ch == 'S') {
				isS = true;
				continue;
			}
			if (ReversePolish.isNum(ch) || ch == '.' || isS) {
				tmp = tmp.concat(String.valueOf(ch));
				isS = false;
				continue;
			} else if (tmp != "") {
				stackMain.push(tmp);
				tmp = "";
			}
			if (ReversePolish.isOperator(ch)) {
				if (ReversePolish.isPriority(ch, stackTmp.peek().toCharArray()[0])) {
					stackTmp.push(String.valueOf(ch));
				} else {
					while (true) {
						stackMain.push(stackTmp.pop());
						if (ReversePolish.isPriority(ch, stackTmp.peek().toCharArray()[0])) {
							break;
						}
					}
					stackTmp.push(String.valueOf(ch));
				}
			} else if (ch == '(') {
				stackTmp.push(String.valueOf(ch));
			} else if (ch == ')') {
				while (true) {
					if (stackTmp.peek().toCharArray()[0] == '(') {
						stackTmp.pop();
						break;
					} else {
						stackMain.push(stackTmp.pop());
					}
				}
			}
		}
		if (tmp != "") {
			stackMain.push(tmp);
			tmp = "";
		}
		while (true) {
			if (stackTmp.peek() == "#") {
				stackTmp.pop();
				break;
			} else {
				stackMain.push(stackTmp.pop());
			}
		}
		while (true) {
			if (stackMain.isEmpty()) {
				break;
			} else {
				stackTmp.push(stackMain.pop());
			}
		}
		while (true) {
			if (stackTmp.isEmpty()) {
				break;
			} else {
				char stackTop = stackTmp.peek().toCharArray()[0];

				if (stackTmp.peek().trim().length() == 1 && ReversePolish.isOperator(stackTop)) {
					String numRight = stackMain.pop();
					String numLeft = stackMain.pop();
					stackMain.push(ReversePolish.calculateTwoNumbers(numLeft, numRight, stackTop));
					stackTmp.pop();
				} else {
					stackMain.push(stackTmp.pop());
				}
			}
		}
		result = stackMain.pop();
		return result;
	}

	/**
	 * 判断是是否操作符 +-*%/
	 * 
	 * @param operator
	 * @return
	 */
	public static boolean isOperator(char operator) {
		String operatorString = Character.toString(operator);
		if (operatorString.matches("[\\*\\+-/%]{1}")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isNum(char num) {
		String numString = Character.toString(num);
		if (numString.matches("[\\d]{1}")) {
			return true;
		} else {
			return false;
		}

	}

	public static String calculateTwoNumbers(String num1, String num2, char operator) {
		float result = 0;
		Float num1Float = Float.valueOf(num1);
		Float num2Float = Float.valueOf(num2);
		if (operator == '+') {
			result = num1Float + num2Float;
		} else if (operator == '-') {
			result = num1Float - num2Float;
		} else if (operator == '*') {
			result = num1Float * num2Float;
		} else if (operator == '/') {
			result = num1Float / num2Float;
		} else if (operator == '%') {
			result = num1Float % num2Float;
		}
		return String.valueOf(result);
	}

	/**
	 * 判断符号优先级
	 * 
	 * @param operator
	 * @return
	 */
	public static int priority(char operator) {
		int result = -1; // # �����ȼ�Ϊ-1�����
		if (operator == '(') {
			result = 0;
		} else if (operator == '+' || operator == '-') {
			result = 1;
		} else if (operator == '*' || operator == '/' || operator == '%') {
			result = 2;
		}
		return result;
	}

	/**
	 * 判断op1与op2的优先级
	 * 
	 * @param operator1
	 * @param operator2
	 * @return
	 */
	public static boolean isPriority(char operator1, char operator2) {
		if (ReversePolish.priority(operator1) > ReversePolish.priority(operator2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(ReversePolish.cal("-44.0/(-8)"));
		System.out.println(ReversePolish.cal("-1-2"));

	}

}
