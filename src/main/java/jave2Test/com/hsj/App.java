package jave2Test.com.hsj;

import ws.schild.jave.Utils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//毫秒格式化->时：分：秒（01:10:00）
        System.out.println(Utils.buildTimeDuration(1 * 1 * 60 * 60 * 1000 + 10 * 60 * 1000));
    }
}
