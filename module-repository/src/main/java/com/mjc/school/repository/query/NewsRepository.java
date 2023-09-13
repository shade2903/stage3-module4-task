package com.mjc.school.repository.query;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.NewsModel;

import java.util.List;

public interface NewsRepository extends BaseRepository<NewsModel, Long> {
    List<NewsModel> readBySearchParams(NewsSearchQueryParams searchQueryParams);
}
