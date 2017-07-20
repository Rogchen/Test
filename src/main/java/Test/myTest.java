import org.junit.Test;

import java.util.logging.Logger;

/**
 * @Description:
 * @Project: try
 * @Product: IntelliJ IDEA
 * @Author zkj
 * @Email:
 * @Created Date: 2017/7/12
 * @Created Time  17:21
 **/

public class myTest {
    private static final Logger loggerr = Logger.getLogger(myTest.class.getName());

    //冒泡
    @Test
    public void test1(){
        int [] a = {1,3,66,33,55,61,32,34,55,6,89,4,9,8,76,55,44,32,12,14,54,65,71,2,99};
        for(int i =1 ;i <a.length;i++){
            for(int j= 0;j<a.length-1;j++){
                if(a[j+1]<a[j]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
      for(int i= 0;i<a.length;i++){
          System.out.println(a[i]);
      }
    }

    //折半
    @Test
    public void test2(){
        int [] array = {1,3,66,33,55,61,32,34,55,6,89,4,9,8,76,55,44,32,12,14,54,65,71,2,99};
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int low = 0;
            int high = i - 1;
            while(low <= high)
            {
                int mid = (low + high) / 2;
                if(temp < array[mid])
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            for(int j = i; j >= low + 1; j--)
            {
                array[j] = array[j - 1];
            }
            array[low] = temp;
            System.out.println(array[i]);
        }
    }

}
