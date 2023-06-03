package com.belajarspringboot.resto.controller;

import com.belajarspringboot.resto.model.Tag;
import com.belajarspringboot.resto.response.CommonResponse;
import com.belajarspringboot.resto.response.CommonResponseGenerator;
import com.belajarspringboot.resto.service.TagService;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class TagController {
    @Autowired
    private TagService tagService;

    @PostMapping("/{product_id}/product")
        public CommonResponse<Tag> addTagProduct(@PathVariable("product_id") int productId, @RequestBody Tag tag){
        return CommonResponseGenerator.sukses(tagService.addTag(productId, tag));
    }
}
