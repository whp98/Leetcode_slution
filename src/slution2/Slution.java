package slution2;

import java.math.BigInteger;

public class Slution {
    //测试
    public static void main(String[] args) {
        Slution a = new Slution();
        a.addTwoNumbers0(a.getList(5),a.getList(5));
    }

    /**
     * 思路错了救不了了
     * 用新的思路解决
     */


//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return getList(getnumber(l1).add(getnumber(l2)));
//    }
//
    //用数字生成链表
    public ListNode getList(int num){
        //出错条件
        if (num < 0){
            throw new IllegalArgumentException("getList:必须以正整数生成链表");
        }
        ListNode firstNode = new ListNode(num%10);
        ListNode temNode;
        temNode = firstNode;
        while(num!=0){
            num/=10;
            if (num!=0){
                temNode.next = new ListNode(num%10);
                temNode = temNode.next;
            }
        }

        return firstNode;
    }
//
//    //用链表生成数字
//    public BigInteger getnumber(ListNode head){
//        //遍历链表
//        BigInteger i=new BigInteger("1");
//        BigInteger res=new BigInteger("0");
//        while(head!=null){
//            res.add(i.multiply(new BigInteger(head.val+"")));
//            i.multiply(new BigInteger("10"));
//            head=head.next;
//        }
//        return res;
//    }
    /**
     * 思路一：使用按照位加的原理计算，
     * 直到两条链表都结束，过程中用变量记录进位
     * 结果保存在新的链表中
     * 相加的条件
     * 一条链表不为空
     * 进位值不为零
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗 :
     * 45 MB
     * , 在所有 java 提交中击败了
     * 82.04%
     * 的用户
     *
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //伪头节点,next才是头节点
        ListNode res = new ListNode(0);
        ListNode tmpN = res;
        //保存进位
        int up=0;
        //计算结果
        int sum=0;
        while(l1!=null || l2!=null || up!=0){
            sum = (l1==null? 0 : l1.val)+(l2==null?0:l2.val)+up;
            up=sum/10;
            tmpN.next=new ListNode(sum%10);
            tmpN = tmpN.next;
            //避免空指针,向后移动
            if (l1!=null){l1=l1.next;}
            if (l2!=null){l2=l2.next;}
        }
        return res.next;
    }
    /**
     * 更加省内存方案
     *
     * 执行用时 :
     * 2 ms
     * , 在所有 java 提交中击败了
     * 99.98%
     * 的用户
     * 内存消耗 :
     * 44 MB
     * , 在所有 java 提交中击败了
     * 87.55%
     * 的用户
     */



    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        //保存进位
        int up=0;
        //计算结果
        int sum=0;
        //用于指向头指针
        ListNode head=l1;

        while(l1!=null || l2!=null || up!=0){
            sum = (l1==null? 0 : l1.val)+(l2==null?0:l2.val)+up;
            up=sum/10;
            l1.val=sum%10;
            //避免空指针,向后移动

            if (l2!=null){ l2=l2.next;}
            if (l1!=null){
                //新建新节点条件是l2还有或者是进位不为0，并且l1下一个是null
                if ((l2!=null||up!=0)&&l1.next==null){
                    l1.next = new ListNode(0);
                }
                l1=l1.next;
            }

        }
        return head;
    }

}
