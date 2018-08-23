package com.slack.push.config.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by sunu@wemakeprice.com on 2018. 8. 23..
 **/
@Data
@Component
@ConfigurationProperties(prefix ="push.info")
public class CommonProperties {
    private String name;
    private String id;
}
