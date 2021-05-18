package arithmetic; /**
 * @(#)arithmetic.java, 2021-03-08.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class getOffer {

    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * in: 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
     * out: true
     */
    @Test
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        int x = array.length - 1;
        int y = 0;
        while (true) {
            if (x < 0 || y >= array[0].length) {
                return false;
            }
            int value = array[x][y];
            if (value == target) {
                return true;
            } else if (value < target) {
                y++;
            } else {
                x--;
            }
        }
    }

    /**
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     * "We Are Happy"
     * "We%20Are%20Happy"
     */
    @Test
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * {67,0,24,58}
     * [58,24,0,67]
     */
    @Test
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * in:[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
     * out:{1,2,5,3,4,6,7}
     */
    @Test
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }
        int root = pre[0];
        TreeNode treeNode = new TreeNode(root);
        if (pre.length == 1 || in.length == 1) {
            return treeNode;
        }
        //前序 中左右
        //中序  左中右
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root) {
                index = i;
                break;
            }
        }
        treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, 1 + index), Arrays.copyOfRange(in, 0, index));
        treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, 1 + index, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return treeNode;
    }

    /**
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty() && stack1.empty()) {
            return -1;
        }
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * [3,4,5,1,2]
     * 1
     */
    public int minNumberInRotateArray(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        while (midIndex < rightIndex && midIndex > leftIndex) {
            int midValue = array[midIndex];
            if (midValue >= array[rightIndex]) {
                leftIndex = midIndex;
            } else if (midValue <= array[rightIndex]) {
                rightIndex = midIndex;
            }
            midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        }
        return array[leftIndex] > array[rightIndex] ? array[rightIndex] : array[leftIndex];
    }

    public int minNumberInRotateArray2(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] == array[right]) {
                right--;
            } else {
                left = mid + 1;
            }
        }
        return array[left];
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n\leq 39n≤39
     * 0 1 1 2 4
     * 4
     * 3
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    public int Fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    public int jumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        for (int i = 2; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int jumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        int[] array = new int[target + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= target; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += array[j];
            }
            array[i] = sum;
        }
        return array[target];
    }

    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 1 2
     */
    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        for (int i = 2; i <= target; i++) {
            third = second + first;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     */
    public int NumberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) == flag) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public int NumberOf2(int n) {
       int count = 0;
       while (n!=0){
           count++;
           n = n&(n-1);
       }
       return count;
    }

}
