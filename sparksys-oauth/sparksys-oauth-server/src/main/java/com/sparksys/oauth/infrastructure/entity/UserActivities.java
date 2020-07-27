package com.sparksys.oauth.infrastructure.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * description: 用户文章
 *
 * @author zhouxinlei
 * @date 2020-05-24 12:24:03
 */
@Data
@ApiModel(value = "UserActivities对象")
public class UserActivities {

    private static final long serialVersionUID = 1849014360372480614L;

    private String id;
    private String updatedAt;
    private UserBean user;
    private CommonBean group;
    private CommonBean project;
    private String template;
    private CommonBean comment;

    @Data
    public static class UserBean {

        private String name;
        private String avatar;
    }

    @Data
    public static class CommonBean {

        private String name;
        private String link;

    }
}