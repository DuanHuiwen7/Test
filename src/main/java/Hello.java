import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.*;

public class Hello {


    public static void main(String[] args) throws ParseException {

        testQueue();


    }

    /**
     * 字符串转换unicode
     */
    public static String convert(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append(String.format("\\u%04x", Integer.valueOf(c)));
        }

        return unicode.toString();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 多少组
        List<String> re = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); // 数列的长度
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            Integer start = null;
            Integer end = null;

            for (int j = 0; j < n; j++) {
                a.add(sc.nextInt());
            }
            for (int j = 0; j < n; j++) {
                b.add(sc.nextInt());
            }
            boolean isBigin = false;
            boolean isYes = false;
            for (int j = 0; j < n; j++) {
                if (a.get(j) != b.get(j) && !isBigin) {
                    if (start != null) {
                        isYes = false;
                        break;
                    }
                    start = j;
                    isBigin = true;
                }
                if (a.get(j) == b.get(j) && isBigin) {
                    end = j;
                    isBigin = false;
                    int ss = a.get(start) - b.get(start);
                    for (int k = start; k <= end; k++) {
                        int s = a.get(k) - b.get(k);
                        if (s != ss) {
                            isYes = false;
                            break;
                        } else {
                            isYes = true;
                        }
                    }
                }
            }
            if (isYes) {
                re.add("YES");
            } else {
                re.add("NO");
            }
        }

        for (String s : re) {
            System.out.println(s);
        }
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        int re = 0;
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 1; i < n; i++) {
            if (a.get(i - 1) > a.get(i)) {
                re = re + ((a.get(i - 1)) / a.get(i));
                if (i > 1 && a.get(i - 2) > a.get(i - 1) / (((a.get(i - 1)) / a.get(i)) + 1)) {
                    re = re + (a.get(i - 2) / (a.get(i - 1) / (((a.get(i - 1)) / a.get(i)) + 1)));
                }

            }
        }
        System.out.println(re);
    }

    public static void test3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        int m = sc.nextInt();
        int re = 0;
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            b.add(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (b.get(i) >= a.get(j)) {
                    if (a.get(j) > s) {
                        s = a.get(j);
                    }
                }
            }
            re = re + b.get(i) - s;
        }

        System.out.println(re);
    }

    public static void test4() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //
        int m = sc.nextInt();
        int re = 0;
        List<List<Integer>> msgs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                a.add(sc.nextInt());
            }
            msgs.add(a);
        }

        for (int i = 0; i < m; i++) {
            List<Integer> a = msgs.get(i);
            int start = 0;
            if (a.get(2) == n) {
                start = a.get(0);
                if (start == 1) {
                    re = 1;
                    break;
                }
            }
        }


        System.out.println(re);
    }

    public static int findRepeatNumber(int[] nums) {
        int re = -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    re = nums[i];
                    break;
                }
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }

        }
        return re;

    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }


    public String replaceSpace(String s) {
        String replaceStr = "%20";
        StringBuilder sb = new StringBuilder();
        char[] strs = s.toCharArray();
        for (char c : strs) {
            if (c == " ".charAt(0)) {
                sb.append(replaceStr);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ArrayList<Object> res = new ArrayList<>();

    public Object[] reversePrint(ListNode head) {
        res.add(head.val);
        while (head != null) {
            head = head.next;
            res.add(reversePrint(head)[0]);
        }
        return res.toArray();
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeD(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int len = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeD(map, preorder, 0, len - 1, inorder, 0, len - 1);

        return root;
    }

    public TreeNode buildTreeD(Map<Integer, Integer> map, int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preEnd == preStart) {
            return root;
        } else {
            int rootIndex = map.get(rootVal);
            int leftNodes = rootIndex - inStart;
            int rightNodes = inEnd - rootIndex;
            TreeNode lefeSubTree = buildTreeD(map, preorder, preStart + 1, preStart + leftNodes, inorder, inStart, rootIndex - 1);
            TreeNode rightSubTree = buildTreeD(map, preorder, preEnd - rightNodes + 1, preEnd, inorder, rootIndex + 1, inEnd);
            root.left = lefeSubTree;
            root.right = rightSubTree;
            return root;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     */
    static class CQueue {
        private Stack<Integer> stackHead;
        private Stack<Integer> stackBack;

        public Stack<Integer> getStackHead() {
            return stackHead;
        }

        public void setStackHead(Stack<Integer> stackHead) {
            this.stackHead = stackHead;
        }

        public Stack<Integer> getStackBack() {
            return stackBack;
        }

        public void setStackBack(Stack<Integer> stackBack) {
            this.stackBack = stackBack;
        }

        public CQueue() {
            stackHead = new Stack<>();
            stackBack = new Stack<>();
        }

        public void appendTail(int value) {
            if (stackHead.isEmpty()) {

            }
            stackHead.push(value);
        }

        public int deleteHead() {
            if (stackHead == null || stackHead.size() == 0) {
                return -1;
            }
            int len = stackHead.size();
            for (int i = 0; i < len; i++) {
                stackBack.push(stackHead.pop());
            }
            int re = stackBack.pop();
            for (int i = 0; i < len - 1; i++) {
                stackHead.push(stackBack.pop());
            }
            return re;
        }
    }


    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     *
     * @param
     * @return
     */
    public static int fib(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * <p>
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * @param
     * @return
     */
    public int numWays(int n) {
        int a = 1, b = 2, sum;
        for (int i = 1; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     */
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        int index = numbers.length - 1;
        while (index > 0) {
            if (numbers[index] < numbers[index - 1]) {
                return numbers[index];
            }
            index--;
        }
        return numbers[0];
    }

    /**
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
     */
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        if (board.length == 0 || word == null || word.length() > board.length * board[0].length) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                int index = 0;
                if (c == word.charAt(index)) {
                    Map<String, String> findedMap = new HashMap<>();
                    flag = findPath(board, word, i, j, index, findedMap);
                    if (flag == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean findPath(char[][] board, String word, int i, int j, int indexB, Map<String, String> findedMap) {
        String key = i + "-" + j;
        if (findedMap.get(key) != null) {
            return false;
        }
        findedMap.put(key, String.valueOf(board[i][j]));
        int index = indexB + 1;
        if (index >= word.length()) {
            return true;
        }
        boolean falg = false;
        char c;
        if (i > 0 && falg == false) {
            c = board[i - 1][j];
            if (c == word.charAt(index)) {
                int ii = i - 1;
                falg = findPath(board, word, ii, j, index, findedMap);
            }
        }
        if (i < board.length - 1 && falg == false) {
            c = board[i + 1][j];
            if (c == word.charAt(index)) {
                int ii = i + 1;
                falg = findPath(board, word, ii, j, index, findedMap);
            }
        }
        if (j > 0 && falg == false) {
            c = board[i][j - 1];
            if (c == word.charAt(index)) {
                int jj = j - 1;
                falg = findPath(board, word, i, jj, index, findedMap);
            }
        }
        if (j < board[0].length - 1 && falg == false) {
            c = board[i][j + 1];
            if (c == word.charAt(index)) {
                int jj = j + 1;
                falg = findPath(board, word, i, jj, index, findedMap);
            }
        }
        if (falg == false) {
            findedMap.remove(key);
        }
        return falg;
    }

    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
     * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] finded = new boolean[m][n];
        return bfs(0, 0, m, n, k, finded);
    }

    public int bfs(int i, int j, int m, int n, int k, boolean[][] finded) {
        if (i >= m || j >= n || sum(i, j) > k || finded[i][j]) {
            return 0;
        }
        finded[i][j] = true;
        return bfs(i + 1, j, m, n, k, finded) + bfs(i, j + 1, m, n, k, finded) + 1;
    }

    public int sum(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m = m / 10;
        }
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long max;
        int k = n % 3;
        int p = 1000000007;
        long rem = 1, x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (k == 2) {
            max = rem * 6 % p;
        } else if (k == 1) {
            max = rem * 4 % p;
        } else {
            max = rem * 3 % p;
        }
        return (int) (max);
    }

    /**
     * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     */
    public int hammingWeight(int n) {
        int re = 0;
        while (n > 0) {
            re += n & 1;
            n >>>= 1;
        }
        return re;
    }

    /**
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     */
    public int[] printNumbers(int n) {
        int max = 1;
        int k = 10;
        while (n > 0) {
            if ((n & 1) == 1) max *= k;
            k *= k;
            n >>= 1;
        }
        int[] re = new int[max - 1];
        for (int i = 1; i <= re.length; i++) {
            re[i - 1] = i;
        }


        return re;
    }

    public void printNumbers1(int n) {
        StringBuilder str = new StringBuilder();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            System.out.println(str.toString().substring(index));
        }
    }

    public boolean increment(StringBuilder str) {
        boolean isOverflow = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            char s = (char) (str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                str.replace(i, i + 1, "0");
                if (i == 0) {
                    isOverflow = true;
                }
            }
            // 没发生进位则跳出for循环
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
            return head;
        }
        ListNode temp = head;
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return temp;
    }

    /**
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
     * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
     * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     */
    public boolean isMatch(String s, String p) {
        boolean flag = false;
        String[] strs = s.split("");
        String[] ps = p.split("");
        int index = 0;
        int i = 0;
        while (i < s.length() && index < p.length()) {
            String str = strs[i];
            String pStr = ps[index];
            if (!str.equals(pStr)) {
                if (pStr.equals(".")) {
                    i++;
                    index++;
                } else if (pStr.equals("*")) {
                    if (index == 0) {
                        break;
                    }
                    String temp = ps[index - 1];
                    if (temp.equals(str)) {
                        i++;
                    } else {
                        if (temp.equals(".")) {
                            flag = true;
                            break;
                        }
                        index++;
                    }
                } else {
                    if (index == p.length() - 1) {
                        break;
                    }
                    String temp = ps[index + 1];
                    if ("*".equals(temp)) {
                        index++;
                    } else {
                        break;
                    }
                }
            } else {
                i++;
                index++;
            }
        }
        return flag;
    }

    public boolean isMatch2(String s, String p) {
        boolean flag = false;

        return flag;
    }

    public boolean isMatch1(String A, String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] f = new boolean[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空正则和非空正则两种
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空正则分为两种情况 * 和 非*
                    if (B.charAt(j - 1) != '*') {
                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到 * 了，分为看和不看两种情况
                        //不看
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        //看
                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }

    public static void testQueue() {

        Hello h = new Hello();
        String s = "aaa";
        String p = "a.aa";

        System.out.println(h.isMatch(s, p));

    }

    public static StringBuilder fixWDC(StringBuilder sbs) {

        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            /**
             * (.)\\1+ 表示 表示任意一个字符重复两次或两次以上（括号里的点表示任意字符，后面的\\1表示取第一个括号匹配的内容，后面的加号表示匹配1次或1次以上。二者加在一起就是某个字符重复两次或两次以上）
             * $1是第一个小括号里的内容，$2是第二个小括号里面的内容，
             */
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+", "$1$1").replaceAll("(.)\\1(.)\\2", "$1$1$2"));
        }
        return null;
    }


}

///*
//
//                                                                                   _oo0oo_
//                                                                                  o8888888o
//                                                                                  88" . "88
//                                                                                  (| -_- |)
//                                                                                  0\  =  /0
//                                                                                ___/`---'\___
//                                                                              .' \\|     |// '.
//                                                                             / \\|||  :  |||// \
//                                                                            / _||||| -:- |||||- \
//                                                                           |   | \\\  -  /// |   |
//                                                                           | \_|  ''\---/''  |_/ |
//                                                                           \  .-\__  '-'  ___/-. /
//                                                                         ___'. .'  /--.--\  `. .'___
//                                                                      ."" '<  `.___\_<|>_/___.' >' "".
//                                                                     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//                                                                     \  \ `_.   \_ __\ /__ _/   .-` /  /
//                                                                 =====`-.____`.___ \_____/___.-`___.-'=====
//                                                                                   `=---='
//
//
//                                                                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//                                                                           佛祖保佑         永无BUG
//
//*/
