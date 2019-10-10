package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Comment", schema = "webApplication", catalog = "")
public class CommentEntity {
    private int id;
    private int topicId;
    private String commentTitle;
    private Date createDate;
    private int authorId;
    private String commentMessage;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "topic_id", nullable = false)
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "comment_title", nullable = false, length = 30)
    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "comment_message", nullable = false, length = 140)
    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (topicId != that.topicId) return false;
        if (authorId != that.authorId) return false;
        if (commentTitle != null ? !commentTitle.equals(that.commentTitle) : that.commentTitle != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (commentMessage != null ? !commentMessage.equals(that.commentMessage) : that.commentMessage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + topicId;
        result = 31 * result + (commentTitle != null ? commentTitle.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + authorId;
        result = 31 * result + (commentMessage != null ? commentMessage.hashCode() : 0);
        return result;
    }
}
