package Test;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * @Project: lbd_restaurant
 * @Product: IntelliJ IDEA
 * @Author Rogchen
 * @Email: chenhk128@163.com
 * @Created Date: 2017/6/22
 * @Created Time  10:43
 **/
public class FileTest{

    //创建文件并写入
    @Test
    public void testT(){
        try{
            byte bWrite [] = {11,21,3,40,5};
            OutputStream os = new FileOutputStream("test.txt");
            for(int x=0; x < bWrite.length ; x++){
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("text.txt");
            int size = is.available();

            for(int i=0; i< size; i++){
                System.out.print((char)is.read() + "  ");
            }
            is.close();
        }catch(IOException e){
            System.out.print("Exception");
        }
    }

    //创建文件和文件夹并写入
    @Test
    public void test2() {
        try {
            File d = new File("d:/test");
            if(!d.mkdirs()) {   //存在返回true，否则false
                d.mkdir();  //不存在就创建
            }
            File f = new File("d://test/test2.txt");
            FileOutputStream fop = new FileOutputStream(f);
            // 构建FileOutputStream对象,文件不存在会自动新建

            OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
            // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
//             writer.write("中文乱码");
            writer.append("中文输入");
            // 写入到缓冲区

            writer.append("\r\n");
            //换行

            writer.append("English");
            // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入

            writer.close();
            //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉

            fop.close();
            // 关闭输出流,释放系统资源

            FileInputStream fip = new FileInputStream(f);
            // 构建FileInputStream对象

            InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
            // 构建InputStreamReader对象,编码与写入相同

            StringBuffer sb = new StringBuffer();
            while (reader.ready()) {
                sb.append((char) reader.read());
                // 转成char加到StringBuffer对象中
            }
            System.out.println(sb.toString());
            reader.close();
            // 关闭读取流

            fip.close();
            // 关闭输入流,释放系统资源

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取目录和文件
    @Test
    public void test3(){
        try {
            String dirname = "d:/Rogchen";
            File f1 = new File(dirname);
            if (f1.isDirectory()) {
                System.out.println( "目录 " + dirname);
                String s[] = f1.list();
                for (int i=0; i < s.length; i++) {
                    File f = new File(dirname + "/" + s[i]);
                    if (f.isDirectory()) {
                        System.out.println(s[i] + " 是一个目录");
                    } else {
                        System.out.println(s[i] + " 是一个文件");
                    }
                }
            } else {
                System.out.println(dirname + " 不是一个目录");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //测试删除目录和文件
    @Test
    public void test4(){
        File folder = new File("d:/test");
//        deleteFolder(folder);
        File[] files = folder.listFiles();
        if(files!=null) {
            for(File f: files) {
                if(f.isDirectory()) {
                    System.out.println("这是目录");
                    f.delete();
                } else {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
