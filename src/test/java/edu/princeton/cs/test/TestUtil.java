package edu.princeton.cs.test;

import org.testng.Assert;

import java.util.Random;
import java.util.Stack;

import static java.lang.System.out;
import static edu.princeton.cs.test.CommonStructure.Node;

public class TestUtil {
    private static char separator = ',';
    private static Random random = new Random(7);

    public static void printIntArray(int[] array){
        StringBuffer buffer = new StringBuffer();

        for(int element : array){
            buffer.append(element).append(separator);
        }
        printString(buffer.deleteCharAt(buffer.length() - 1).toString());
    }

    public static void printString(String ss){
        out.println(ss);
    }

    public static void printBoolean(boolean bool){
        out.println(bool);
    }

    public static <T> void printList(Node<T> head){
        StringBuilder sb = new StringBuilder();
        while (null != head){
            sb.append(head.value).append(separator);
            head = head.next;
        }
        printString(sb.deleteCharAt(sb.length() - 1).toString());
    }

    private static String recursionString(Stack<Integer> sk){
        if(sk.empty()) {return "";}
        else {
            StringBuffer buffer = new StringBuffer();
            buffer.append(TestUtil.separator).append(sk.pop().toString());
            buffer.insert(0,recursionString(sk));
            return buffer.toString();
        }
    }

    public static void printStackReversly(Stack<Integer> sk){
        Stack<Integer> skclone = new Stack<>();
        Object[] array = new Object[sk.size()];sk.copyInto(array);
        for(Object cln : array){  skclone.push(((Integer) cln));  }
        String stackStr = recursionString(skclone);
        TestUtil.printString(stackStr.substring(stackStr.indexOf(TestUtil.separator) + 1));
    }

    public static int generateRandomInteger(){
        return random.nextInt(3);
    }

    public static void assertEqualAndPrintToInfo(Object actual,Object expected){
        Assert.assertEquals(actual,expected);
        printString("result is '" + expected.toString() + "'");
    }
}
