package com.prismcortex.teahtv.data;

import com.prismcortex.teahtv.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
