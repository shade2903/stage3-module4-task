package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class CommentDtoResponse {
    private Long id;
    private String name;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdateDate;

    private NewsDtoResponse newsDto;

    public CommentDtoResponse() {
    }

    public CommentDtoResponse(Long id,
                              String name,
                              LocalDateTime createDate,
                              LocalDateTime lastUpdateDate,
                              NewsDtoResponse newsDto) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.newsDto = newsDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public NewsDtoResponse getNewsDto() {
        return newsDto;
    }

    public void setNewsDto(NewsDtoResponse newsDto) {
        this.newsDto = newsDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentDtoResponse that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(newsDto, that.newsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, lastUpdateDate, newsDto);
    }

    @Override
    public String toString() {
        return "CommentDtoResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", newsDto=" + newsDto +
                '}';
    }
}
