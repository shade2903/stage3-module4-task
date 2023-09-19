package com.mjc.school.service.dto;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Component
public class NewsDtoResponse {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private Long authorId;

    private List<Long> tagsId;

    private List<Long> commentId;

    public NewsDtoResponse(Long id,
                           String title,
                           String content,
                           LocalDateTime createDate,
                           LocalDateTime lastUpdateDate,
                           Long authorId,
                           List<Long> tagsId,
                           List<Long> commentId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorId = authorId;
        this.tagsId = tagsId;
        this.commentId = commentId;
    }

    public NewsDtoResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public List<Long> getTagsId() {
        return tagsId;
    }

    public void setTagsId(List<Long> tagsId) {
        this.tagsId = tagsId;
    }

    public List<Long> getCommentId() {
        return commentId;
    }

    public void setCommentId(List<Long> commentId) {
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsDtoResponse that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(content, that.content) && Objects.equals(createDate, that.createDate) && Objects.equals(lastUpdateDate, that.lastUpdateDate) && Objects.equals(authorId, that.authorId) && Objects.equals(tagsId, that.tagsId) && Objects.equals(commentId, that.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorId, tagsId, commentId);
    }

    @Override
    public String toString() {
        return "NewsDtoResponse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorId=" + authorId +
                ", tagsId=" + tagsId +
                ", commentId=" + commentId +
                '}';
    }
}
