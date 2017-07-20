import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @Description:队列
 * @Project: try
 * @Product: IntelliJ IDEA
 * @Author zkj
 * @Email:
 * @Created Date: 2017/7/17
 * @Created Time  20:19
 **/
public class QueueDemo {
    private static final Logger logger = Logger.getLogger(QueueDemo.class.getName());

    @Test
    public void testDemo(){
        //实例化队列
        Queue<Integer> queue = new LinkedList<Integer>();
        Random random = new Random(47);
        for(int i=0;i<10;i++) {
            int a = random.nextInt(i + 10);
            //生成随机数放入到队列中
            queue.offer(a);
        }
        //打印出当前队列
        logger.info(queue.toString());
        printQueue(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for(char c:"brod".toCharArray()){
            qc.offer(c);
        }
        logger.info(qc.toString());
        printQueue(qc);
    }

    private static void printQueue(Queue queue) {
        //获取队列的头
        while (queue.peek() !=null) {
            //删除队列头
            logger.info(queue.remove() + " ");
        }
    }

}
