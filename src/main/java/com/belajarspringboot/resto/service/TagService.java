package com.belajarspringboot.resto.service;

import com.belajarspringboot.resto.model.Tag;

public interface TagService {
    Tag addTag(int productId, Tag tag);
}
