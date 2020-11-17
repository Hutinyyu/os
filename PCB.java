package OperatingSystem;

public class PCB {
    //PCB名;
    public  String pcbName;
    //运行时间
    public int time;
    //优先级
    public int priority;
    //pcb状态
    public char state = 'R';


    public PCB(String pcbName, int time, int priority) {
        this.pcbName = pcbName;
        this.time = time;
        this.priority = priority;
    }

    public String getPcbName() {
        return pcbName;
    }

    public void setPcbName(String pcbName) {
        this.pcbName = pcbName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PCB:" +
                "pcb编号=" + pcbName + '\t' +
                "\t 运行时间=" + time +

                "\t 优先级=" + priority +
                "\t 状态=" + state ;
    }
}
