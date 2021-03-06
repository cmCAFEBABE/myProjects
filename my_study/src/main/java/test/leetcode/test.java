/**
 * @(#)test.java, 2021-04-07.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test.leetcode;

import com.google.common.collect.Lists;
import org.apache.activemq.store.kahadb.disk.index.ListNode;
import org.apache.poi.ss.formula.functions.T;
import org.checkerframework.checker.units.qual.min;
import org.ehcache.core.util.CollectionUtil;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 陈敏(chenmin5 @ corp.netease.com)
 */
public class test {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 1) {
            return s;
        }
        Character[][] array = new Character[numRows][s.length()];
        int i = 0;
        int j = 0;
        int index = 0;
        boolean addFlag = true;
        while (i < numRows && j < array[0].length && index < s.length()) {
            array[i][j] = s.charAt(index);
            index++;
            if (addFlag) {
                if (i >= numRows - 1) {
                    addFlag = false;
                    if (i > 0) {
                        i--;
                    }
                    j++;
                } else {
                    i++;
                }
            } else {
                if (i <= 0) {
                    addFlag = true;
                    i++;
                } else {
                    if (i > 0) {
                        i--;
                    }
                    j++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int m = 0; m < array.length; m++) {
            for (int n = 0; n < array[m].length; n++) {
                if (array[m][n] != null) {
                    sb.append(array[m][n]);
                }
            }
        }
        return sb.toString();
    }

    public String conver2(String s, int numRows) {
        if (s == null || s.length() == 1 || numRows == 1) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        boolean downFlag = true;
        int i = 0;
        for (char ch : s.toCharArray()) {
            list.get(i).append(ch);
            if (i == 0) {
                downFlag = true;
            } else if (i == list.size()) {
                downFlag = false;
            }
            i = downFlag ? i + 1 : i - 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : list) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }

    @Test
    public void convert() {
        System.out.println(convert("AB", 1));
    }

    public int reverse(int x) {
        boolean flag = x > 0;
        x = Math.abs(x);
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (x != 0) {
            linkedList.add(x % 10);
            x /= 10;
        }
        Integer result = 0;
        for (Integer num : linkedList) {
            result = result * 10 + num;
        }
        return flag ? result : -result;
    }
//
//    @Test
//    public int myAtoi(String s) {
//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        for (char ch : s.toCharArray()) {
//            if (ch == ' ' || ch == '+' || ch == '-')
//                stringBuilder;
//        }
//        return null;
//    }

    @Test
    public void test() {
        String str = "YXPE21040011(签署合同7天内)即将失效,请延长生效日期(供应商:YX2999)";

        String patStr = ".*?(?=\\()";

        Pattern pattern = Pattern.compile(patStr);

        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 1) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * minValueInArray(height, left, right);
            maxArea = Math.max(area, maxArea);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    private int minValueInArray(int[] height, int left, int right) {
        return Math.min(height[left], height[right]);
    }

    @Test
    public void maxArea() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    private String intToRoman(Integer num) {
        if (num <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                stringBuilder.append("M");
            } else if (num >= 900) {
                num -= 900;
                stringBuilder.append("CM");
            } else if (num >= 500) {
                num -= 500;
                stringBuilder.append("D");
            } else if (num >= 400) {
                num -= 400;
                stringBuilder.append("CD");
            } else if (num >= 100) {
                num -= 100;
                stringBuilder.append("C");
            } else if (num >= 90) {
                num -= 90;
                stringBuilder.append("XC");
            } else if (num >= 50) {
                num -= 50;
                stringBuilder.append("L");
            } else if (num >= 40) {
                num -= 40;
                stringBuilder.append("XL");
            } else if (num >= 10) {
                num -= 10;
                stringBuilder.append("X");
            } else if (num >= 9) {
                num -= 9;
                stringBuilder.append("IX");
            } else if (num >= 5) {
                num -= 5;
                stringBuilder.append("V");
            } else if (num >= 4) {
                num -= 4;
                stringBuilder.append("IV");
            } else if (num >= 1) {
                num -= 1;
                stringBuilder.append("I");
            }
        }
        return stringBuilder.toString();
    }

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int sum = 0;
        for (int i = 0; i < symbols.length && s.length() > 0; i++) {
            String str = symbols[i];
            while (s.substring(0, Math.min(str.length(), s.length())).equals(str)) {
                sum += values[i];
                s = s.substring(Math.min(str.length(), s.length()));
            }
        }
        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        String first = strs[0];
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        boolean go = true;
        while (go && index < first.length()) {
            char ch = first.charAt(index);
            for (int i = 1; i < strs.length; i++) {
                go = index < strs[i].length() && ch == strs[i].charAt(index);
                if (!go) {
                    break;
                }
            }
            if (go) {
                stringBuilder.append(ch);
            }
            index++;
        }
        return stringBuilder.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int target = -first;
            int left = i + 1;
            int right = nums.length - 1;
            List<List<Integer>> list = twoSum(nums, left, right, target, first);
            if (list != null && list.size() > 0) {
                result.addAll(list);
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int left, int right, int target, int first) {
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(first);
                subResult.add(nums[left]);
                subResult.add(nums[right]);
                result.add(subResult);
                while (left + 1 < nums.length && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
                while (right - 1 > 0 && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = a + nums[left] + nums[right];
                if (Math.abs(sum - target) < Math.abs(bestSum - target)) {
                    bestSum = sum;
                }
                if (sum == target) {
                    return bestSum;
                } else if (sum > target) {
                    while (left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    right--;
                } else {
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return bestSum;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = a + b + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(a);
                        list.add(b);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                    } else {
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test7() {
        int[] array = {1, 1, 1, 0};
        threeSumClosest(array, 100);
    }


    private Map<Character, List<String>> map = new HashMap<>();

    {
        map.put('2', Stream.of("a", "b", "c").collect(Collectors.toList()));
        map.put('3', Stream.of("d", "e", "f").collect(Collectors.toList()));
        map.put('4', Stream.of("g", "h", "i").collect(Collectors.toList()));
        map.put('5', Stream.of("j", "k", "l").collect(Collectors.toList()));
        map.put('6', Stream.of("m", "n", "o").collect(Collectors.toList()));
        map.put('7', Stream.of("p", "q", "r", "s").collect(Collectors.toList()));
        map.put('8', Stream.of("t", "u", "v").collect(Collectors.toList()));
        map.put('9', Stream.of("w", "x", "y", "z").collect(Collectors.toList()));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return new ArrayList<>();
        }
        if (digits.length() == 1) {
            return map.get(digits.charAt(0));
        }
        char ch = digits.charAt(0);
        List<String> subString1s = map.get(ch);
        List<String> subString2s = letterCombinations(digits.substring(1));
        List<String> result = new ArrayList<>();
        for (int i = 0; i < subString1s.size(); i++) {
            for (int j = 0; j < subString2s.size(); j++) {
                result.add(subString1s.get(i) + subString2s.get(j));
            }
        }
        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1 || head == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = new ListNode(-1);
        second.next = first;
        ListNode newHead = second;
        int i = 0;
        for (; i < n && first != null; i++) {
            first = first.next;
        }
        if (i != n) {
            //异常
            return head;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return newHead.next;
    }

    //()[]{}
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{': {
                    stack.push(ch);
                    break;
                }
                case ')': {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                }
                case ']': {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                }
                case '}': {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test8() {
        boolean valid = isValid("]");
        System.out.println(valid);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(-1);
        ListNode preHead = first;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                first.next = l2;
                break;
            }
            if (l2 == null) {
                first.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                first.next = l1;
                l1 = l1.next;
                first = first.next;
            } else {
                first.next = l2;
                l2 = l2.next;
                first = first.next;
            }
        }
        return preHead.next;
    }

    @Test
    public void testGenerateParenthesis() {
        System.out.println(generateParenthesis(5));
    }

    //输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, new StringBuffer(), 0, 0, n);
        return result;
    }

    private void generateParenthesis(List<String> result, StringBuffer subResult, int leftCount, int rightCount, int maxCount) {
        if (subResult.length() == maxCount * 2) {
            //这里不用校验加入的是否是有效的！？   rightCount<leftCount 这个条件就可以valid
            result.add(subResult.toString());
            return;
        }
        if (leftCount < maxCount) {
            subResult.append('(');
            generateParenthesis(result, subResult, leftCount + 1, rightCount, maxCount);
            subResult.deleteCharAt(subResult.length() - 1);
        }
        if (rightCount < leftCount) {
            subResult.append(')');
            generateParenthesis(result, subResult, leftCount, rightCount + 1, maxCount);
            subResult.deleteCharAt(subResult.length() - 1);
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        //分治算法
//        ListNode listNode0 = mergeKLists_fz(lists, 0, lists.length - 1);
        //优先队列
        ListNode listNode1 = mergeKLists_quote(lists);

        return listNode1;
    }

    private ListNode mergeKLists_quote(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode node : lists) {
            if (node != null) {
                priorityQueue.add(node);
            }
        }
        ListNode first = new ListNode(-1);
        ListNode head = first;
        while (!priorityQueue.isEmpty()) {
            ListNode maxNode = priorityQueue.remove();
            first.next = maxNode;
            first = first.next;
            if (maxNode.next != null) {
                priorityQueue.add(maxNode.next);
            }
        }
        return head.next;
    }

    /**
     * 分治算法
     *
     * @param lists
     * @param left
     * @param right
     */
    private ListNode mergeKLists_fz(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        return mergeTwoLists2(mergeKLists_fz(lists, left, mid), mergeKLists_fz(lists, mid + 1, right));
    }


    private ListNode mergeTwoLists2(ListNode a, ListNode b) {
        ListNode first = new ListNode(-1);
        ListNode head = first;
        while (a != null && b != null) {
            if (a.val < b.val) {
                head.next = a;
                a = a.next;
            } else {
                head.next = b;
                b = b.next;
            }
            head = head.next;
        }
        head.next = a == null ? b : a;
        return first.next;
    }


    public Set<String> generateParenthesis2(int n) {
        Set<String> set = new HashSet<>();
        if (n <= 0) {
            return set;
        }
        if (n == 1) {
            set.add("()");
            return set;
        }
        Set<String> stringBuilders = generateParenthesis2(n - 1);
        stringBuilders.forEach(string -> {
            set.add(string + "()");
            set.add("()" + string);
            set.add("(" + string + ")");
        });
        return set;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode newHead = first;
        while (first.next != null && first.next.next != null) {
            ListNode oldSecondNode = first.next.next;
            ListNode oldFirstNode = first.next;
            oldFirstNode.next = oldSecondNode.next;
            oldSecondNode.next = oldFirstNode;
            first.next = oldSecondNode;
            first = oldFirstNode;
        }
        return newHead.next;
    }

    public ListNode buildListNode(List<Integer> list) {
        List<ListNode> collect = list.stream().map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < collect.size() - 1; i++) {
            collect.get(i).next = collect.get(i + 1);
        }
        return collect.get(0);
    }

    @Test
    public void testReverseKGroup() {
        ListNode listNode = buildListNode(Lists.newArrayList(1, 2, 3, 4, 5));
        System.out.println(reverseKGroup(listNode, 2));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        Integer count = countOfList(head);
        if (count < k || count < 2) {
            return head;
        }
        ListNode first = new ListNode(-1);
        ListNode oldHead = first;
        first.next = head;
        for (int i = 0; i < count / k; i++) {
            first = reverseKNode(first, k);
        }
        for (int i = 0; i < k; i++) {
            oldHead = oldHead.next;
        }
        return oldHead;
    }

    private Integer countOfList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    //翻转head 节点之后的链表
    public ListNode reverseKNode(ListNode head, Integer k) {
        ListNode tempEnd = head.next;
        for (int i = 0; i < k - 1; i++) {
            ListNode newFirst = tempEnd.next;
            tempEnd.next = tempEnd.next.next;
            newFirst.next = head.next;
            head.next = newFirst;
        }
        return tempEnd;
    }

    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String first = strs[0];
        if (first == null || first.length() == 0) {
            return "";
        }
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j] == null || strs[j].length() < i || strs[j].charAt(i) != ch) {
                    return stringBuilder.toString();
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    /**
     * 取s1的排列组合case太多  不如求s2的子串
     * <p>
     * 比较相等即比较字符是否相同即可
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        char[] array1 = new char[26];
        char[] array2 = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(array1, array2)) {
            return true;
        }
        for (int right = s1.length(); right < s2.length(); right++) {
            int left = right - s1.length();//即将删掉的字符
            array2[s2.charAt(right) - 'a']++;
            array2[s2.charAt(left) - 'a']--;
            if (Arrays.equals(array1, array2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        char[] array = new char[26];
        for (int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i) - 'a']--;
            array[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int right = s1.length(); right < s2.length(); right++) {
            int left = right - s1.length();//即将删掉的字符
            if (array[s2.charAt(right) - 'a'] == 0) {
                diff++;
            }
            array[s2.charAt(right) - 'a']++;
            if (array[s2.charAt(right) - 'a'] == 0) {
                diff--;
            }
            if (array[s2.charAt(left) - 'a'] == 0) {
                diff++;
            }
            array[s2.charAt(left) - 'a']--;
            if (array[s2.charAt(left) - 'a'] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }

        }
        return false;
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for (char ch : s.toCharArray()) {
            while (set.contains(ch)) {
                set.remove(s.charAt(left++));
            }
            set.add(ch);
            max = Math.max(max, set.size());
        }
        return max;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 两数相乘 模拟法
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int index = result.length - 1 - (num1.length() - 1 - i);
            for (int j = num2.length() - 1; j >= 0; j--) {
                Integer firstNum = num1.charAt(i) - '0';
                Integer secondNum = num2.charAt(j) - '0';
                int subResult = firstNum * secondNum;
                result[index] += subResult % 10;
                result[index - 1] += subResult / 10;
                if (result[index] > 10) {
                    result[index] -= 10;
                    result[index - 1] += 1;
                }
                index--;
            }
        }
        boolean startAppendFlag = false;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                startAppendFlag = true;
            }
            if (startAppendFlag) {
                stringBuilder.append(result[i]);
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        List<String> midResult = Arrays.asList(s.split("\\s+"));
        Collections.reverse(midResult);
        return String.join(" ", midResult);
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        s = s.trim();
        int left = 0;
        int right = s.length() - 1;
        LinkedList<String> list = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                stringBuilder.append(s.charAt(left));
            } else if (stringBuilder.length() != 0) {
                list.addFirst(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
            left++;
        }
        if (stringBuilder.length() > 0) {
            list.addFirst(stringBuilder.toString());
        }
        return String.join(" ", list);
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] node = path.split("/+");
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < node.length; i++) {
            if (node[i].equals(".") || node[i].equals("")) {
                continue;
            } else if (node[i].equals("..")) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else {
                list.add(node[i]);
            }
        }
        list.addFirst("");
        return list.size() > 1 ? String.join("/", list) : "/";
    }

    @Test
    public void testSimplifyPath() {
        String path = "/../";
//        System.out.println(simplifyPath(path));
        System.out.println(String.join("/", Lists.newArrayList("1")));
        System.out.println(String.join("/", Lists.newArrayList("1", "2")));
    }

    @Test
    public void testRestoreIpAddresses() {
        System.out.println(restoreIpAddresses("1111"));
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        List<String> subResult = new ArrayList<>();
        restoreIpAddresses(s, 0, subResult, result);
        return result;
    }

    private void restoreIpAddresses(String s, int left, List<String> subResult, List<String> result) {
        if (subResult.size() == 4) {
            if (left == s.length()) {
                result.add(String.join(".", subResult));
            }
            return;
        } else if (left >= s.length()) {
            return;
        }
        if (s.charAt(left) == '0') {
            subResult.add("0");
            restoreIpAddresses(s, left + 1, subResult, result);
            subResult.remove(subResult.size() - 1);
        } else {
            for (int right = left; right < s.length(); right++) {
                Integer value = Integer.valueOf(s.substring(left, right + 1));
                if (value > -1 && value < 256) {
                    subResult.add(value.toString());
                    restoreIpAddresses(s, right + 1, subResult, result);
                    subResult.remove(subResult.size() - 1);
                } else {
                    break;
                }
            }
        }
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            while (i > 0 && nums[i] == nums[i - 1] && i < nums.length - 1) {
                i++;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) {
                    left++;
                } else if (nums[right] + nums[left] > target) {
                    right--;
                } else {
                    ArrayList<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    result.add(subList);
                    left++;
                    right--;
                    while (left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }


    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //用-1表示遍历过
        int[][] way = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, dfsMaxAreaOfIsland(grid, i, j, way));
            }
        }
        return max;
    }

    //旋转数据查找
    //关键: 至少一边是有序的
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else {
                //左边有序
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                //右边有序
                else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int max = 1;
        while (right < nums.length) {
            if (nums[right] > nums[left]) {
                right++;
            } else {
                left = right;
                right = right + 1;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.remove();
            }
        }
        return queue.isEmpty() ? -1 : queue.peek();
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int arm = num;
                int subLen = 0;
                while (set.contains(arm)) {
                    subLen++;
                    arm++;
                }
                max = Math.max(subLen, max);
            }
        }
        return max;
    }

    @Test
    public void testGetPermutation() {
        System.out.println(getPermutation(3, 3));
    }

    public String getPermutation(int n, int k) {
        if (n < 0 || k < 0) {
            return "";
        }
        int[] num = new int[n];
        int[] used = new int[n];
        for (int i = 1; i < num.length + 1; i++) {
            num[i - 1] = i;
        }
        List<String> result = new ArrayList<>();
        StringBuilder subResult = new StringBuilder();
        for (int i = 0; i < num.length; i++) {
            if (dfs(used, num, i, subResult, result, k)) {
                break;
            }
        }
        return result.get(k - 1);
    }

    private boolean dfs(int[] used, int[] num, int currentIndex, StringBuilder subResult, List<String> result, Integer k) {
        subResult.append(num[currentIndex]);
        used[currentIndex] = 1;
        if (subResult.length() == num.length) {
            result.add(subResult.toString());
            if (result.size() == k) {
                return true;
            }
        }
        for (int i = 0; i < num.length && subResult.length() != num.length; i++) {
            if (used[i] == 0) {
                if (dfs(used, num, i, subResult, result, k)) {
                    return true;
                }
            }
        }
        used[currentIndex] = 0;
        subResult.deleteCharAt(subResult.length() - 1);
        return false;
    }

    @Test
    public void testFindKthLargest() {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};

        System.out.println(findKthLargest(array, 4));
    }


    @Test
    public void testSearch() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(array, 0));
    }


    private Integer dfsMaxAreaOfIsland(int[][] grid, int x, int y, int[][] way) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        //标记遍历过
        grid[x][y] = 0;
        int subSum = 1;
        for (int i = 0; i < way.length; i++) {
            subSum += dfsMaxAreaOfIsland(grid, x + way[i][0], y + way[i][1], way);
        }
        return subSum;
    }

    @Test
    public void testThreeSum2() {
        int[] nums = {0, 0, 0};
        System.out.println(threeSum2(nums));
    }

    @Test
    public void testMultiply() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return intervals;
        }
        //先排序
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= result.get(result.size() - 1)[0] && intervals[i][0] <= result.get(result.size() - 1)[1]) {
                int[] ints = result.get(result.size() - 1);
                ints[1] = Math.max(ints[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    /**
     * 接雨水
     */
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int[] leftMaxHeigh = new int[height.length];
        int[] rightMaxHeigh = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                leftMaxHeigh[i] = height[i];
            } else {
                leftMaxHeigh[i] = Math.max(leftMaxHeigh[i - 1], height[i]);
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                rightMaxHeigh[i] = height[i];
            } else {
                rightMaxHeigh[i] = Math.max(rightMaxHeigh[i + 1], height[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftMaxHeigh[i], rightMaxHeigh[i]) - height[i];
        }
        return sum;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        if (head == null) {
            return head;
        }
        while (true) {
            if (slowNode != null) {
                slowNode = slowNode.next;
            }
            if (fastNode != null && fastNode.next != null) {
                fastNode = fastNode.next.next;
            } else {
                return null;
            }
            if (fastNode == slowNode) {
                ListNode first = head;
                while (first!=slowNode){
                    first = first.next;
                    slowNode = slowNode.next;
                }
                return first;
            }
        }
    }

}