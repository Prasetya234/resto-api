package com.belajarspringboot.resto.serviceimpl;

import com.belajarspringboot.resto.exception.NotFoundException;
import com.belajarspringboot.resto.model.Tag;
import com.belajarspringboot.resto.respository.ProductRespository;
import com.belajarspringboot.resto.respository.TagRespository;
import com.belajarspringboot.resto.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private TagRespository tagRespository;

    @Override
    public Tag addTag(int productId, Tag tagRequest){
        Tag tag = productRespository.findById(productId).map(p -> {
            p.addTags(tagRequest);
            return tagRespository.save(tagRequest);
        }).orElseThrow(() -> new NotFoundException("Product id tidak tersedia"));
        return tag;
    }
}
