
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


    //字符流
    @Test
    public void zifuTest() throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("test.txt"));
        StringBuffer ch = new StringBuffer();
        while ((in.readLine()) !=null){
            ch.append(in.readLine());
        }
        System.out.println(ch);
        in.close();
        Writer writer = new FileWriter("test.txt");
        writer.append("\r\n");
        writer.append(ch+"精忠报国发的说法是否打算发的撒！");
//        writer.flush();
        writer.close();

    }

    //创建文件并写入---字节流
    @Test
    public void testT(){
        try{
            byte bWrite [] = new byte[1024];//{11,21,3,40,5};
            String str = "hellllllll我们就打开飞机";
            bWrite = str.getBytes();

            OutputStream os = new FileOutputStream("test.txt");
            for(int x=0; x < bWrite.length ; x++){
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
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
            System.out.println(sb.indexOf("l"));
            reader.close();
            // 关闭读取流

            fip.close();
            // 关闭输入流,释放系统资源

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试缓冲器 读写文件
    @Test
    public void wirteTest(){
        //写入文件
//        File d = new File("d:/test");
//        if(!d.mkdirs()){
//            d.mkdir();
//        }
        //获取文件
        File f = new File("d:/abcd.txt");
        try {
            String str = "欢迎来到中国 welcome come to china！";
            FileOutputStream fout = new FileOutputStream(f);
            OutputStreamWriter out = new OutputStreamWriter(fout,"UTF-8");
            out.append(str);
            out.close();
            System.out.println("文件写入成功！");
            fout.close();

            //从文件读取数据

            File file = new File("d:/test/abcd.txt");
            FileInputStream fin = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fin,"UTF-8");
            StringBuffer sb = new StringBuffer();
            while (in.ready()){
                sb.append((char)in.read());
            }
            System.out.println("文件读取成功！");
            System.out.println(sb);
            System.out.println(sb.indexOf("w"));
            in.close();
            fin.close();
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