/**
 * Design an algorithm and write code to remove the duplicate characters in a **string** without using any additional buffer. NOTE: One or two additional variables are fine. An extra copy of the array is not.
 *
 * FOLLOW UP
 *
 * Write the test cases for this method.
 *
 * 译文：
 *
 * 设计算法并写出代码移除【字符串】中重复的字符，不能使用额外的缓存空间。注意： 可以使用额外的一个或两个变量，但不允许额外再开一个数组拷贝。
 *
 * 进一步地，
 *
 * 为你的程序写测试用例。
 */

/*
不能使用buffer 所以不能使用StringBuffer
 */
public class RemoveDupicateLetter {


    public static void main(String[] args) {
        String s1 = "abcdedffg";
        String s2 = "a";
        String res = removeDuplicateLetter(s1);
        String res2 = removeDuplicateLetter(s2);
        System.out.println(res);
        System.out.println(res2);
    }



    public static String removeDuplicateLetter(String s){


        int len = s.length();
        if(len < 2)
            return s;
        String str = " ";
        for (int i =0;i<len;i++){
            if(s.charAt(i) != ' '){
                str += s.charAt(i);
                for (int j=i+1;j<len;j++){
                    if(s.charAt(i) == s.charAt(j)){
                        //未生效？？？？？,需要调用replace之后再用str来接收
//                        s.replace(s.charAt(j),' ');
                        s = s.replace(s.charAt(j),' ');

                    }
                }
            }
        }

        return str;
    }


    //failed

//    public static String removeDuplicateLetter2(String s){
//
//        int len = s.length();
//        if(len < 2)
//            return s;
//        char[] c = new char[256];
//        for(int i=0;i<len;i++){
//            c[i] = s.charAt(i);
//            for(int j=i+1;j<len;j++){
//                if(s.charAt(i) == s.charAt(j)){
//                    c[j] = ' ';
//                }
//            }
//        }
//
//        return c.toString();
//    }

}
