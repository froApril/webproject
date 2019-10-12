package entities;

import javax.persistence.*;

@Entity
@Table(name = "Message", schema = "webApplication")
public class MessageEntity {
    private int id;
    private int posterId;
    private Integer receiverId;
    private String messageDetail;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "poster_id", nullable = false)
    public int getPosterId() {
        return posterId;
    }

    public void setPosterId(int posterId) {
        this.posterId = posterId;
    }

    @Basic
    @Column(name = "receiver_id", nullable = true)
    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "message_detail", nullable = false, length = 140)
    public String getMessageDetail() {
        return messageDetail;
    }

    public void setMessageDetail(String messageDetail) {
        this.messageDetail = messageDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (id != that.id) return false;
        if (posterId != that.posterId) return false;
        if (receiverId != null ? !receiverId.equals(that.receiverId) : that.receiverId != null) return false;
        if (messageDetail != null ? !messageDetail.equals(that.messageDetail) : that.messageDetail != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + posterId;
        result = 31 * result + (receiverId != null ? receiverId.hashCode() : 0);
        result = 31 * result + (messageDetail != null ? messageDetail.hashCode() : 0);
        return result;
    }
}
