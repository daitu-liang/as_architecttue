package com.kakaxi.androidmvp.model.partyfirst;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/24.
 */

public class AttenListBean implements Serializable {

    /**
     * id : 22
     * case_id : 9737
     * desc : 网格通
     * status : 0
     * report_man : 辉
     * createtime : 14141414
     * status_desc : 未读
     */

    private String id;
    private String case_id;
    private String desc;
    private String status;
    private String report_man;
    private String createtime;
    private String status_desc;
    private String instructions;
    private String left_time;
    private String overdate;

    public String getLeft_time() {
        return left_time;
    }

    public void setLeft_time(String left_time) {
        this.left_time = left_time;
    }

    public String getOverdate() {
        return overdate;
    }

    public void setOverdate(String overdate) {
        this.overdate = overdate;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReport_man() {
        return report_man;
    }

    public void setReport_man(String report_man) {
        this.report_man = report_man;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStatus_desc() {
        return status_desc;
    }

    public void setStatus_desc(String status_desc) {
        this.status_desc = status_desc;
    }

    @Override
    public String toString() {
        return "AttenListBean{" +
                "id='" + id + '\'' +
                ", case_id='" + case_id + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", report_man='" + report_man + '\'' +
                ", createtime='" + createtime + '\'' +
                ", status_desc='" + status_desc + '\'' +
                ", instructions='" + instructions + '\'' +
                ", left_time='" + left_time + '\'' +
                ", overdate='" + overdate + '\'' +
                '}';
    }
}
