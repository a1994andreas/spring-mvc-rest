package springframework.app.services;

import org.springframework.stereotype.Service;
import springframework.app.domain.Category;
import springframework.app.repositories.CategoryRepository;
import springframework.app.v1.mapper.CategoryMapper;
import springframework.app.v1.model.CategoryDTO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categoryDTOS = new LinkedList<>();
        categoryRepository.findAll().iterator().forEachRemaining( category -> {
            categoryDTOS.add(categoryMapper.categoryToCategoryDTO(category));
        });
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
