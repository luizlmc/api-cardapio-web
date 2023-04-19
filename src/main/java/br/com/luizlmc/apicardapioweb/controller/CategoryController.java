package br.com.luizlmc.apicardapioweb.controller;

import br.com.luizlmc.apicardapioweb.dto.CategoryDTO;
import br.com.luizlmc.apicardapioweb.model.Category;
import br.com.luizlmc.apicardapioweb.service.CategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryServiceImpl;

    private ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryServiceImpl = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories(){
        return ResponseEntity.ok(categoryServiceImpl
                .findAllCategories()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList());
    }

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CategoryDTO categoryDTO, UriComponentsBuilder uriBuilder){

        if (categoryServiceImpl.existsCategory(modelMapper.map(categoryDTO, Category.class))){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Categoria ja cadastrada.");
        }
        Category newCategory = categoryServiceImpl.createCategory(modelMapper.map(categoryDTO, Category.class));

        var uri = uriBuilder.path("medicos/{id}").buildAndExpand(newCategory.getId()).toUri();

        return ResponseEntity.created(uri).body(modelMapper.map(newCategory, CategoryDTO.class));
    }
}
