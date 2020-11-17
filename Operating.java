package OperatingSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author ：Hutinyyu
 * @time:2020.11.17
 *  进程调度方法
 */

public class Operating {
    public void Process(ArrayList<PCB> pcbs) {
        separation();
        System.out.println("=========================优先数调度算法处理器进程已开启=========================");
        separation();

        sort(pcbs);
        reveal(pcbs);
        separation();
//      遍历集合 边遍历边操作，边排序
        for (int i = 0; i < pcbs.size(); i++) {
            System.out.println("开始执行" + pcbs.get(i).pcbName + "进程:");
            System.out.println(pcbs.get(i));
             //开始运算优先级-1,时间-3
            // 之前时间是-1，改成-3程序报错
            //原因：没有对time进行限制，以至于陷入死循环
            //解决：加了if语句，对time进行限制
            if (pcbs.get(i).time >2){
                pcbs.get(i).priority -= 1;
                pcbs.get(i).time-=3;//当时间>2时，时间-3
            }else{
                pcbs.get(i).priority -= 1;
                pcbs.get(i).time -=1;//当1=<时间<2时，时间-1
            }

           
//            int n =pcbs.get(i).priority - 3;
//            pcbs.get(i).setPriority(n);


            //若time=0,该进程退出队列
            if (pcbs.get(i).time == 0) {
                pcbs.get(i).state = 'E';
                System.out.println(pcbs.get(i).pcbName + "退出进程队列，信息如下:");
                System.out.println(pcbs.get(i));
                pcbs.remove(i);//把已运行完的PCB块移出集合
            } else {
                System.out.println(pcbs.get(i).pcbName + "进程执行完毕，信息如下:");
                System.out.println(pcbs.get(i));
                separation();
                sort(pcbs);//排序
                separation();
            }

            //若集合为空，该进程退出程序
            if (pcbs.size() == 0) {
                System.out.println("所有进程执行完毕！");
                break;
            } else {
                System.out.println("此时进程队列的所有进程信息：");
                separation();
                reveal(pcbs);//遍历
                separation();
            }
//          防止下标溢出
            i -= 1;
        }
    }

    //分割线
    public void separation() {
        System.out.println("======================================================================");
    }


    public void sort(ArrayList<PCB> pcbs) {
//        根据优先级进行升序排序
        Collections.sort(pcbs, new Comparator<PCB>() {
            @Override
            public int compare(PCB o1, PCB o2) {
                //return o1.getPriority() - o2.getPriority();  //升序
                return o2.getPriority() - o1.getPriority(); //降序
            }
        });
    }

    //遍历进程
    public void reveal(ArrayList<PCB> pcbs) {
        for (PCB p :
                pcbs) {
            System.out.println(p);
        }
    }
}
