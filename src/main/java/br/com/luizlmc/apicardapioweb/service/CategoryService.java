package br.com.luizlmc.apicardapioweb.service;

import br.com.luizlmc.apicardapioweb.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAllCategories();
    Category createCategory(Category category);

    boolean existsCategory(Category category);
}
