package slution7;


public class Slution1 {
    public static void main(String[] args) {
        Slution1 a = new Slution1();
        System.out.println(a.reverse(456));
        System.out.println(a.reverse3(153423649));
        //System.out.println(a.reverse(1534236464));
        System.out.println(Integer.MIN_VALUE);

    }
    /**
     *  基本思路：
     *  首先判断是不是负数，记住这个数的符号然后取绝对值，然后将绝对值转换为字符串
     *  然后获取该字符串的整体最后转化为int类型
     *  此法不通报错：
     *  Exception in thread "main" java.lang.NumberFormatException: For input string: "4646324351"
     * 原因是 prasint有最大值限
     *
     * 发现没读题，原来溢出返回0
     * 然后
     * 通过	4 ms	34.3 MB
     *
     */
    public int reverse(int x) {
        try{
            if (x>=0){
                String strTem = ""+x;
                char[] chars = strTem.toCharArray();
                strTem = "";
                for (char c:chars){
                    strTem = c+strTem;
                }
                int i = Integer.valueOf(strTem).intValue();
                return i;
            }else{
                String strTem = ""+(-x);
                char[] chars = strTem.toCharArray();
                strTem = "";
                for (char c:chars){
                    strTem = c+strTem;
                }
                int i = Integer.valueOf(strTem).intValue();
                return -i;
            }
        }catch (Exception e){
            return 0;
        }

    }



    //网友的思路
    public int reverse2(int x) {
        try {
            if(x > 0) {
                StringBuilder str = new StringBuilder().append(x);
                return Integer.parseInt(str.reverse().toString());
            }else {
                StringBuilder str = new StringBuilder().append(-x);
                return Integer.parseInt(str.reverse().toString())*(-1);
            }
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    //官方思路
    public int reverse3(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
