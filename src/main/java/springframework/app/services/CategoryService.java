package springframework.app.services;

import springframework.app.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories ();

    CategoryDTO getCategoryByName (String name);
}
