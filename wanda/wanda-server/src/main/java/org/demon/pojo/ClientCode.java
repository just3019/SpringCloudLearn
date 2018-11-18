package org.demon.pojo;

import java.util.Date;

public class ClientCode {
    private Integer id;

    private String no;

    private Integer status;

    private Date createtime;

    private Date updatetime;

    private Date failtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getFailtime() {
        return failtime;
    }

    public void setFailtime(Date failtime) {
        this.failtime = failtime;
    }
}