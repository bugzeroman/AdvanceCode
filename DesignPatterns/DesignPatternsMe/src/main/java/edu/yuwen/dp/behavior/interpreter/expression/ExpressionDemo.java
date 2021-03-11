package edu.yuwen.dp.behavior.interpreter.expression;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 10.解释器模式（行为型） 
 *
 * 
 * Demo: 定义了一个新的加减乘除计算"语法"，规则如下：
 * 1.运算符只包含加、减、乘、除，并且没有优先级的概念；
 * 2.表达式中，先书写数字，后书写运算符，空格隔开；
 * 3.按照先后顺序，取出两个数字和一个运算符计算结果，结果重新放入数字的最头部位置，直到最后一个数字作为计算结果。
 */
public class ExpressionDemo {
    private Deque<Expression> numbers = new LinkedList<>();

    public long interpret(String expression) {
        String[] elements = expression.split(" ");
        int length = elements.length;
        for (int i = 0; i < (length + 1) / 2; ++i) {
            numbers.addLast(new NumberExpression(elements[i]));
        }

        for (int i = (length + 1) / 2; i < length; ++i) {
            String operator = elements[i];
            boolean isValid = "+".equals(operator) || "-".equals(operator) || "*".equals(operator)
                    || "/".equals(operator);
            if (!isValid) {
                throw new RuntimeException("Expression is invalid: " + expression);
            }

            Expression exp1 = numbers.pollFirst();
            Expression exp2 = numbers.pollFirst();
            Expression combinedExp = null;
            if (operator.equals("+")) {
                combinedExp = new AdditionExpression(exp1, exp2);
            } else if (operator.equals("-")) {
                combinedExp = new SubstractionExpression(exp1, exp2);
            } else if (operator.equals("*")) {
                combinedExp = new MultiplicationExpression(exp1, exp2);
            } else if (operator.equals("/")) {
                combinedExp = new DivisionExpression(exp1, exp2);
            }
            long result = combinedExp.interpret();
            numbers.addFirst(new NumberExpression(result));
        }

        if (numbers.size() != 1) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }

        return numbers.pop().interpret();
    }

    public static void main(String[] args) {
        String expression = "8 3 2 4 - + *";
        long result = new ExpressionDemo().interpret(expression);
        System.out.println("expression=" + expression);
        System.out.println("result=" + result);
    }
}
