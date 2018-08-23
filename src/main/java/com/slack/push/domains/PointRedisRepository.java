package com.slack.push.domains;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by sunu@wemakeprice.com on 2018. 7. 30..
 **/
public interface PointRedisRepository extends CrudRepository<Point, String> {
}
