package entities;

import javax.persistence.*;

@Entity
@Table(name = "Topics", schema = "webApplication", catalog = "")
public class TopicsEntity {
    private int id;
    private String topicName;
    private Integer commentNum;
    private String topicDescription;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "topicName", nullable = false, length = 30)
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Basic
    @Column(name = "commentNum", nullable = true)
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "topicDescription", nullable = false, length = 255)
    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicsEntity that = (TopicsEntity) o;

        if (id != that.id) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (topicDescription != null ? !topicDescription.equals(that.topicDescription) : that.topicDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (topicDescription != null ? topicDescription.hashCode() : 0);
        return result;
    }
}
