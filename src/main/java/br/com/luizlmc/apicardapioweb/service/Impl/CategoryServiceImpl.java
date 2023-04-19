package br.com.luizlmc.apicardapioweb.service.Impl;

import br.com.luizlmc.apicardapioweb.model.Category;
import br.com.luizlmc.apicardapioweb.repository.CategoryRepository;
import br.com.luizlmc.apicardapioweb.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean existsCategory(Category category) {
        return categoryRepository.existsCategoryByName(category.getName());
    }
}
