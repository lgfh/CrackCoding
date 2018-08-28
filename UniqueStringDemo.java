

/*
Q: Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 */


/*
    indexof 返回String对象内第一次出现子字符串的位置
    lastinxexof 返回String对象中字符串最后出现的位置
    如果给定的字符串中没有重复，说明子字符串（此处为单个char字符）第一次出现的位置和最后一次出现的位置一致，即字符串中没有重复的字符，每一个字符都是unique
    如果字符串中有重复，则其前后出现的位置不一致
    经过验证，即使包含一些特殊的符号，也可以正确判断，每个符号对应其ascii码（猜测）
    别忘记判断传入的字符串非空
    即使字符串中包含空格也不影响判断，--忘记字符串中的空格怎么去掉了--已查询解决

    # trim只能去掉首尾的空格，要去掉所有的字符串中的空格 利用replace/replaceall
 */


public class UniqueStringDemo {

    public static void main(String[] args) {

        String s1 = " I am alpha";
        String s2 = "abcdefghijk";
        String s3 = "abcdefab";
        String s4 = "abcd0123";
        String s5 = "abc12,.?/*&^";

        String s1trim = s1.trim();
        String s1trim2 = s1.replaceAll(" ","");

        System.out.println(isUnique(s1trim));
        System.out.println(isUnique(s1trim2));

    }




    public static boolean isUnique(String s) {

        if (s == null && s.isEmpty())
            return false;
        else
        {
            char [] ele = s.toCharArray();
            for(char e:ele){
                if (s.indexOf(e) != s.lastIndexOf(e))
                    return true;
            }
            return false;
        }
    }
}



