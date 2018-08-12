

/*
Q:Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
 */

/*
    java体现不出来那个以空为结尾的字符？
    1.直接使用StringBuffer的reverse函数貌似不能体现最后的空字符？
    2。使用char数组接收然后倒叙插入到String中方式可以在字符串开头显性体现那个空字符，不确定是否符合题意。
    3。使用charAt可以在字符串结尾处显性体现那个空字符。
 */

public class CTypeStringRevers {

    public static void main(String[] args){

        String originString = "abcdefg ";
        System.out.println(reverse3(originString));
    }

//    直接使用reverse函数
    public static String reverse1(String s){

        if (s != null && !(s.isEmpty()))
//            查了api使用StringBuffer和StringBuilder效果相同
//        return new StringBuffer(s).reverse().toString();
            return new StringBuilder(s).reverse().toString();
        return "Empty string!!";
    }

//    倒序遍历，正向插入准备好的字符串中，默认值为null是否符合要求？注意ele.length会得到从1开始的个数，如果不使用ele.length-1则出现数组越界，此时null出现在开头
    public static String reverse2(String s){

        if (s == null && s.isEmpty())
            return "Empty String";
        else{
            char [] ele = s.toCharArray();
            String reverse = null;
            for (int i =ele.length; i>=0 ; i-- )
                reverse += ele[i];

            return reverse;
        }
    }

//    正向读取，然后往字符串开头添加。此时null出现在末尾
    public static String reverse3(String s){

        if (s == null && s.isEmpty())
            return "Empty String";
        else {
            String reverse = null;
            for (int i=0 ;i<s.length();i++ ) {
                reverse = s.charAt(i) + reverse;
            }
            return reverse;
        }
    }
}
