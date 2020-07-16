package com.neusiri.repository;

import com.neusiri.model.UserDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author zhangdj
 * @date 2020-07-15 10:45
 */
public interface UserRepository extends ElasticsearchRepository<UserDO,Long> {

    List<UserDO> findByNameLike(String name);
}
