//import java.util.LinkedList;
//
//class Solution {
//    public ListNode convertBiNode(TreeNode root) {
//        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
//        TreeNode prev = head;// 移动的链表前置指针
//        // 开始中序遍历
//        TreeNode node = root;
//        Deque<TreeNode> stack = new LinkedList<>();
//        while (node != null || !stack.isEmpty()){
//            if (node != null){
//                stack.push(node);
//                node = node.left;
//            }else {
//                node = stack.pop();
//                // ---链表处理
//                node.left = null;// 当前节点左指针置空
//                prev.right = node;// 前置指针右指针指向当前节点，作为链表的next指针，链表新增元素
//                prev = node;// 指针后移
//                // ---链表处理
//                // 中序遍历进入右子树
//                node = node.right;
//            }
//        }
//        head = head.right;
//        ListNode now = new ListNode(-1);
//        ListNode cur = now;
//        while(head != null){
//            cur.next = head.val;
//            cur = cur.next;
//            head = head.right;
//        }
//        return now.next;
//    }
//}
//
