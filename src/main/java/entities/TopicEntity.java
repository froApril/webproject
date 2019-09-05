package entities;

import javax.persistence.*;

@Entity
@Table(name = "Topic", schema = "webApplication")
public class TopicEntity {
    private int id;
    private String topicName;
    private int commentNum;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "topicName", nullable = true, length = 30)
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Basic
    @Column(name = "commentNum", nullable = false)
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicEntity that = (TopicEntity) o;

        if (id != that.id) return false;
        if (commentNum != that.commentNum) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        result = 31 * result + commentNum;
        return result;
    }
}
