package com.prismcortex.teahtv.data;

import com.prismcortex.teahtv.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
