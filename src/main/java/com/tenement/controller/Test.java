package com.tenement.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LXPENG on 2016/4/16.
 */
public class Test {
    public static void main(String[] args)
    {
        String txt="<dt>a</dt><dd><a >b</a></dd>";

        String re1="(<[^>]+>)";	// Tag 1
        String re2="(d)";	// Any Single Character 1
        String re3="(t)";	// Any Single Character 2
        String re4=".*?";	// Non-greedy match on filler
        String re5="((?:[a-z][a-z0-9_]*))";	// Variable Name 1
        String re6="(<[^>]+>)";	// Tag 2
        String re7="(<[^>]+>)";	// Tag 3
        String re8="(<)";	// Any Single Character 3
        String re9="(a)";	// Any Single Character 4
        String re10="(.)";	// Any Single Character 5
        String re11="(>)";	// Any Single Character 6
        String re12="([a-z])";	// Any Single Word Character (Not Whitespace) 1
        String re13="(<[^>]+>)";	// Tag 4
        String re14="(<[^>]+>)";	// Tag 5

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String tag1=m.group(1);
            String c1=m.group(2);
            String c2=m.group(3);
            String var1=m.group(4);
            String tag2=m.group(5);
            String tag3=m.group(6);
            String c3=m.group(7);
            String c4=m.group(8);
            String c5=m.group(9);
            String c6=m.group(10);
            String w1=m.group(11);
            String tag4=m.group(12);
            String tag5=m.group(13);
            System.out.print("("+tag1.toString()+")"+"("+c1.toString()+")"+"("+c2.toString()+")"+"("+var1.toString()+")"+"("+tag2.toString()+")"+"("+tag3.toString()+")"+"("+c3.toString()+")"+"("+c4.toString()+")"+"("+c5.toString()+")"+"("+c6.toString()+")"+"("+w1.toString()+")"+"("+tag4.toString()+")"+"("+tag5.toString()+")"+"\n");
        }
    }
}
