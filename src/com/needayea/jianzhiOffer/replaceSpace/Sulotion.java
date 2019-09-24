package com.needayea.jianzhiOffer.replaceSpace;

/**
 * @author lixiaole
 * @date 2018/9/19
 * @Description
 */

/**
 * 替换空格
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 1 使用java中的原字符串方法 return str.toString().replace(" ","%20");
 * 2 自己手写替换方法
 *  思路： 1 先统计需要替换的字符串中的空格个数  spaceNumber
 *          若 空格个数为0 则直接返回原串   否则 获取该空格个数
 *        2 根据空格个数得到新替换后的串长度 为 oldLength+spaceNumber*2
 *
 *        3倒序  从尾部向头部 倒序进行替换
 *            如果原串中的该下标对应的字符不为空格  则原样赋值到新串
 *            否则  进行一一替换
 *
 */
public class Sulotion {

    public static void main(String[] args) {
        String result =ReplaceSpace(new StringBuffer("We Are Happy  "));
        System.out.println(result);
    }

    public static String ReplaceSpace(StringBuffer str){
        int spaceNumber = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)== ' '){
                spaceNumber++;
            }
        }
        if(spaceNumber == 0 ){
            return str.toString();
        }
        int indexOld = str.length()-1;
        int indexNew = str.length() + spaceNumber * 2 - 1;
        str.setLength(indexNew+1);
        for(;indexOld>=0;--indexOld){
            if(str.charAt(indexOld) == ' '){
                str.setCharAt(indexNew--,'%');
                str.setCharAt(indexNew--,'0');
                str.setCharAt(indexNew--,'2');
            }else {
                str.setCharAt(indexNew--,str.charAt(indexOld));
            }
        }
        return str.toString();
    }
}
