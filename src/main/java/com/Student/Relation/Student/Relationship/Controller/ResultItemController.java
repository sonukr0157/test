package com.Student.Relation.Student.Relationship.Controller;

import com.Student.Relation.Student.Relationship.Entity.ResultItem;
import com.Student.Relation.Student.Relationship.Repository.ResultItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultItems")
public class ResultItemController {

    @Autowired
    private ResultItemRepository resultItemRepository;

    @PostMapping
    public ResultItem saveResultItem(@RequestBody ResultItem resultItem) {
        return resultItemRepository.save(resultItem);
    }

    @GetMapping
    public List<ResultItem> getAllResultItems() {
        return resultItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResultItem getResultItemById(@PathVariable Long id) {
        return resultItemRepository.findById(id).orElse(null);
    }
}
