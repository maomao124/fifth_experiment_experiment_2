import java.io.*;

/**
 * Project name(项目名称)：第五次实验_实验2
 * Package(包名): PACKAGE_NAME
 * Class(类名): ReadExample
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/21
 * Time(创建时间)： 20:59
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class ReadExample
{
    public static void main(String[] args) throws IOException
    {
        //------------------------------------------------------
        long startTime = System.nanoTime();   //获取开始时间
        //------------------------------------------------------
        File file = new File("src\\main\\java\\ReadExample.java");//添加当前文件路径
        File tempFile = new File("temp.txt");//目标文件
        FileReader inOne = new FileReader(file);//创建指向file的输入流
        BufferedReader inTwo = new BufferedReader(inOne);//创建指向inOne的输入流
        FileWriter toFile = new FileWriter(tempFile);//创建指向文件tempFile的输出流
        BufferedWriter out = new BufferedWriter(toFile);//创建指向toFile的输出流
        String s = null;
        int i = 0;
        s = inTwo.readLine();          //从源文件中读一行
        while (s != null)
        {
            i++;
            out.write(i + "  " + s);
            out.write("\n");    //换行
            s = inTwo.readLine();  //从源文件中读一行
        }
        inOne.close();
        inTwo.close();
        out.flush();
        out.close();
        toFile.close();
        System.out.println("完成");
        System.out.println("结果：");
        System.out.println("源文件长度：" + file.length());
        System.out.println("源文件行数："+i);
        System.out.println("源文件路径：" + file.getAbsolutePath());
        //------------------------------------------------------
        long endTime = System.nanoTime(); //获取结束时间
        if ((endTime - startTime) < 1000000)
        {
            double final_runtime;
            final_runtime = (endTime - startTime);
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "微秒");
        }
        else if ((endTime - startTime) >= 1000000 && (endTime - startTime) < 10000000000L)
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 1000;
            final_runtime = final_runtime / 1000;
            System.out.println("算法运行时间： " + final_runtime + "毫秒");
        }
        else
        {
            double final_runtime;
            final_runtime = (endTime - startTime) / 10000;
            final_runtime = final_runtime / 100000;
            System.out.println("算法运行时间： " + final_runtime + "秒");
        }
        Runtime r = Runtime.getRuntime();
        float memory;
        memory = r.totalMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("JVM总内存：%.3fMB\n", memory);
        memory = r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf(" 空闲内存：%.3fMB\n", memory);
        memory = r.totalMemory() - r.freeMemory();
        memory = memory / 1024 / 1024;
        System.out.printf("已使用的内存：%.4fMB\n", memory);
        //------------------------------------------------------
    }
}


