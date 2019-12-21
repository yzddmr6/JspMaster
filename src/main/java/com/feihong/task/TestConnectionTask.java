package com.feihong.task;

import com.feihong.bean.ShellEntry;
import com.feihong.util.BasicSetting;
import com.feihong.util.ConnectionUtil;
import javafx.concurrent.Task;

import java.io.IOException;

public class TestConnectionTask extends Task<Integer> {
    private String result;
    private ShellEntry entry;
    private int status = 0;


    public TestConnectionTask(ShellEntry entry){
        this.entry = entry;
    }

    public int getStatus(){
        return this.status;
    }

    public String getConnectionStatus(){
        return this.result;
    }

    @Override
    protected Integer call() {
        BasicSetting.getInstance().initialize(entry);
        String connecionStatus = null;
        try {
            connecionStatus = ConnectionUtil.getConnectionStatus();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        this.status = 1;
        this.result = connecionStatus;

        return 1;
    }
}
//参考：https://blog.csdn.net/loongshawn/article/details/52996382