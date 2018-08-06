package org.demon.pojo;

public class MessageIMUser {
    private Long id;

    private String messageNo;

    private Integer uid;

    private Boolean receive = false;

    private Boolean open = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageNo() {
        return messageNo;
    }

    public void setMessageNo(String messageNo) {
        this.messageNo = messageNo == null ? null : messageNo.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Boolean getReceive() {
        return receive;
    }

    public void setReceive(Boolean receive) {
        this.receive = receive;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}