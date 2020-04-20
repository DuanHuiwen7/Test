import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello {


    public static void main(String[] args) throws ParseException {

        System.out.println("c = " + "".split("")[0]);
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        int j = 0;
        for (int pre : preorder) {
            for (int in : inorder) {
                if (pre == preorder[0] && pre == in) {
                    if (j > 0) {
                        root.left = new TreeNode(inorder[j - 1]);
                    } else if (j < inorder.length - 1) {
                        root.right = new TreeNode(inorder[j + 1]);
                    }
                }
                j++;
            }
            i++;
        }

        return null;
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

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//


//    /**
//     * 无线打印测试,传入设备ID,和波次ID即可
//     * @param uniqueCode
//     * @param pickingId
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping("/wirless/print/save")
//    @ResponseBody
//    public Object save(String uniqueCode, Long pickingId) throws Exception {
//        checkSelfId();
//        Staff staff = getStaff();
//        Object o = wirelessPrintService.saveWirelessPrint(staff, uniqueCode, pickingId);
//        return o;
//    }
