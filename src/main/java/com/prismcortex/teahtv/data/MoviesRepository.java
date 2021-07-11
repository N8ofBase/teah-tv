package com.prismcortex.teahtv.data;

import com.prismcortex.teahtv.models.Movies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {
}
