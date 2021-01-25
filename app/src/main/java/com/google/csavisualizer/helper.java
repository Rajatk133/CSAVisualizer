package com.google.csavisualizer;

public class helper {
    int pid;
    int val;
    helper(int a,int b){
      pid=a;
      val=b;
    }

    public int getPid() {
        return pid;
    }

    public int getVal() {
        return val;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setVal(int timeno) {
        this.val = timeno;
    }

    public static int compareThem(helper t, helper t1) {
         if(t.val<t1.val)return 1;

             return 0;

    }
}
