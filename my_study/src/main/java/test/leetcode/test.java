/**
 * @(#)test.java, 2021-04-07.
 * <p/>
 * Copyright 2021 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package test.leetcode;

import com.google.common.collect.Lists;
import org.apache.activemq.store.kahadb.disk.index.ListNode;
import org.checkerframework.checker.units.qual.min;
import org.ehcache.core.util.CollectionUtil;
import org.junit.Test;

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
        } else if(left>=s.length()){
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
                }else {
                    break;
                }
            }
        }
    }


    @Test
    public void testMultiply() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }

}