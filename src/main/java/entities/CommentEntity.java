package entities;

import javax.persistence.*;

@Entity
@Table(name = "Comment", schema = "webApplication", catalog = "")
public class CommentEntity {
    private int id;
    private Integer parentId;
    private String commentTitle;
    private String authorName;
    private String commentMessage;
    private int topicId;
    private String imgUrl;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "commentTitle", nullable = true, length = 100)
    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    @Basic
    @Column(name = "authorName", nullable = false, length = 30)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "commentMessage", nullable = false, length = 140)
    public String getCommentMessage() {
        return commentMessage;
    }

    public void setCommentMessage(String commentMessage) {
        this.commentMessage = commentMessage;
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
    @Column(name = "imgURL", nullable = true)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (id != that.id) return false;
        if (topicId != that.topicId) return false;
        if (parentId != null ? !parentId.equals(that.parentId) : that.parentId != null) return false;
        if (commentTitle != null ? !commentTitle.equals(that.commentTitle) : that.commentTitle != null) return false;
        if (authorName != null ? !authorName.equals(that.authorName) : that.authorName != null) return false;
        if (commentMessage != null ? !commentMessage.equals(that.commentMessage) : that.commentMessage != null)
            return false;
        if (imgUrl != null ? !imgUrl.equals(that.imgUrl) : that.imgUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (commentTitle != null ? commentTitle.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (commentMessage != null ? commentMessage.hashCode() : 0);
        result = 31 * result + topicId;
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        return result;
    }
}
