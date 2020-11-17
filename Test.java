package OperatingSystem;

import java.util.ArrayList;

/**
 * 测试
 */

public class Test {
    public static void main(String[] args) {
        ArrayList<PCB> pcbs = new ArrayList<>();
        pcbs.add(new PCB("P1",2,5));
        pcbs.add(new PCB("P2",2,5));
//        pcbs.add(new PCB("P3",6,3));
////        pcbs.add(new PCB("P4",9,2));
////        pcbs.add(new PCB("P5",5,1));

        Operating operating = new Operating();
        //执行处理器调度
        operating.Process(pcbs);

    }
}
