import com.google.common.collect.Maps;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Project: try
 * @Product: IntelliJ IDEA
 * @Author zkj
 * @Email:
 * @Created Date: 2017/7/13
 * @Created Time  17:45
 **/
public class tomtopTest {


    public void readTest(){

    }

    @Test
    public void jsonMapTest(){
        List list = new ArrayList();
        for(int i = 0;i < 4;i++) {
            TreeMap map = new TreeMap();
            map.put("sku1_"+i, "aaaaaaa"+i);
            map.put("sku2_"+i, "bbbbbbb"+i);
            map.put("sku3_"+i, "ccccccc"+i);
            list.add(map);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",list);
        JSONArray jsa = jsonObject.getJSONArray("list");
        System.out.println(jsa);
        for(int i=0;i<jsa.size();i++){
            JSONObject ob = jsa.getJSONObject(i);
            System.out.println(ob.get("sku1_"+i)+"::::"+ob.get("sku2_"+i)+"::::"+ob.get("sku3_"+i));
        }
    }


    @Test
    public void jsonListTest(){
        List list = new ArrayList();
        for(int i = 0;i < 4;i++) {
            list.add("非常好"+i+"henhao!");
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list",list);
        JSONArray jsa = jsonObject.getJSONArray("list");
        System.out.println(jsa);
        for(int i=0;i<jsa.size();i++){
            Object ob = jsa.get(i);
            System.out.println(ob.toString());
        }
    }

    @Test
    public void jsonArryTest(){

        JSONArray ja = new JSONArray();
        for(int i = 0;i < 4;i++) {
            ja.add("非常好"+i+"henhao!");
        }
        System.out.println(ja);
        for(int i=0;i<ja.size();i++){
            Object ob = ja.get(i);
            System.out.println(ob.toString());
        }
    }

    @Test
    public void mapTest(){

        int sub0=0,sub1=0,sub2=0; JSONArray ja = new JSONArray();
        for(int i=0;i<5;i++){
            TreeMap map = new TreeMap();
            map.put("sku1"+i,1+i);
            map.put("sku2"+i,2+i);
            map.put("sku3"+i,3+i);
            ja.add(map);
        }
        System.out.println(ja);
        for(int j= 0;j<ja.size();j++){
            JSONObject jb = ja.getJSONObject(j);
            sub0 += Integer.valueOf(jb.get("sku1"+j).toString());
            sub1 += Integer.valueOf(jb.get("sku2"+j).toString());
            sub2 += Integer.valueOf(jb.get("sku3"+j).toString());
            System.out.println(jb);
        }
        System.out.println("结果sub0："+sub0+"  结果sub1："+sub1+"  结果sub2："+sub2);
        int [] arry = {sub2,sub1,sub0};
        Arrays.sort(arry);
        Map ap = Maps.newHashMap();
        for(int z=0;z<arry.length;z++){
            ap.put(z,arry[z]);
        }
        System.out.println(ap.toString());
    }


}
