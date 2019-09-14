package entities;

import javax.persistence.*;


@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true)
@Table(name = "Topic", schema = "webApplication")

public class TopicEntity {
    private int id;
    private String topicName;
    private Integer commentNum=0;
    private Integer score=0;
    private Integer times=0;

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
    @Column(name = "commentNum", nullable = true, columnDefinition = "INT default 0")
    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "score", nullable = true,columnDefinition = "INT default 0")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Basic
    @Column(name = "times", nullable = true,columnDefinition = "INT default 0")
    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicEntity that = (TopicEntity) o;

        if (id != that.id) return false;
        if (topicName != null ? !topicName.equals(that.topicName) : that.topicName != null) return false;
        if (commentNum != null ? !commentNum.equals(that.commentNum) : that.commentNum != null) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;
        if (times != null ? !times.equals(that.times) : that.times != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (topicName != null ? topicName.hashCode() : 0);
        result = 31 * result + (commentNum != null ? commentNum.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (times != null ? times.hashCode() : 0);
        return result;
    }
}
