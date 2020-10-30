package api.v1.mapper;

import api.v1.model.CategoryDTO;
import domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() throws Exception {
        // Given
        Category category = new Category();
        category.setName("Andreas");
        category.setId(1L);

        // When
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        // Then
        assertEquals(Long.valueOf(1L), categoryDTO.getId());
        assertEquals("Andreas", categoryDTO.getName());
    }
}