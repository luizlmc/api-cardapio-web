package br.com.luizlmc.apicardapioweb.repository;

import br.com.luizlmc.apicardapioweb.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsCategoryByName(String name);
}
