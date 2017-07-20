import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @Project: try
 * @Product: IntelliJ IDEA
 * @Author zkj
 * @Email:
 * @Created Date: 2017/7/17
 * @Created Time  19:09
 **/
public class jiheTest {

    @Test
    public void HashSetTest(){
        HashSet set = new HashSet();
        for(int i=0;i<5;i++){
            set.add("第"+i+"次");
            if(i==3){
                set.add("abc");
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()){
            Object s = it.next();
            System.out.println(s.toString());
        }

    }

    @Test
    public void TreeSetTest(){
        TreeSet set = new TreeSet();
        for(int i=0;i<5;i++){
            set.add("第"+i+"次");
            if(i==3){
                set.add("abc");
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()){
            Object s = it.next();
            System.out.println(s.toString());
        }
    }


    @Test
    public void mapTest(){
        Map map = Maps.newHashMap();
        for(int i=0;i<5;i++){
            map.put(i,"第"+i+"次");
        }

        java.util.Set set = map.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()){
            HashMap ob = (HashMap) it.next();
            for(int i=0;i<5;i++) {
                System.out.println(ob.containsKey(i));
            }
        }
    }

}
