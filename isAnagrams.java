import java.util.Arrays;

/**
 * 原文：
 *
 * Write a method to decide if two strings are anagrams or not.
 *
 * 译文：
 *
 * 写一个函数判断两个字符串是否是变位词。
 */

/*
变位词(anagrams)指的是组成两个单词的字符相同，但位置不同的单词。比如说， abbcd和abcdb就是一对变位词。

方法一：
    将String转为char[],利用arrays.sort(char[])将字符串排序，判断排序后的两字符串是否相等

方法二：
    利用一个int[256]来表示所有的ascii字符，第一个字符串每个字符出现一次在对应位置计数加1，
    第二个字符串中每个字符出现一次在对应的位置减1，
    由于初始化int[]每个位置都为0，所以第一个字符串中出现的次数少于第二个的位置上会出现负值
    判断有小于零的情况出现时，可知两个字符串的字符不相同，返回false

 */

public class isAnagrams {


    public static void main(String[] args) {

        String s1 = "bee";
        String s2 = "eea";
//        System.out.println(isAnagrams1(s1,s2));
        System.out.println(isAnagrams2(s1,s2));
    }

    public static boolean isAnagrams1(String s1,String s2){

        if(s1 != null && s2 != null && !s1.isEmpty() && !s2.isEmpty()){
            if(s1.equals(s2)){
                System.out.println("1st string is identical to 2nd string ");
                return false;
            }
            if(s1.length() != s2.length()){
                System.out.println("Length varies,definitely not anagrams");
                return false;
            }
            return sort(s1).equals(sort(s2));
        }
        else {
            System.out.println("either string is empty");
            return false;
        }

    }
     static String sort(String s){
        char [] a = s.toCharArray();
         Arrays.sort(a);        //字符串转为char用数组接收，对char数组排序
        return new String(a);
    }


    public static boolean isAnagrams2(String s1,String s2){
        if(s1 != null && s2 != null && !s1.isEmpty() && !s2.isEmpty()){

            if(s1.equals(s2)){
                System.out.println("1st string is identical to 2nd string ");
                return false;
            }
            if(s1.length() != s2.length()){
                System.out.println("Length varies,definitely not anagrams");
                return false;
            }

            //定义一个256的数组可以表示所有的ascii码，初始int数组所有的位置都为0
            int [] a = new int[256];
            //s1转char数组，循环，包含一个字符，在char数组对应的位置加1
            for (char i : s1.toCharArray())
                a[i]++;
            //s2转char数组，循环，每包含一个字符，在对应的char数组位置减1，必须使用前置的"--a[]"运算符否则最后一个是不同的情况（例如 s1="bee"，s2="eea"）在
            // 未做运算就判断不会出现0-1=-1而小于0的情况！
            for (int j=0;j<s2.length();j++){
                //如果s1中在该位置的char数组数量小于s2减的数量将出现负值，则可知字符不完全一样
                if (--a[s2.charAt(j)] < 0)
                    return false;
            }
            return true;

        }
        else {
            System.out.println("either string is empty");
            return false;
        }
    }

}
