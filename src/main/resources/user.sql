DROP TABLE IF EXISTS user;

CREATE TABLE user (
    user_id bigint(20) COMMENT '用户ID',
    nick_name varchar(50) NOT NULL COMMENT '昵称',
    avatar varchar(255) NOT NULL COMMENT '头像',
    phone varchar(15) NOT NULL COMMENT '手机号',
    PRIMARY KEY (user_id)
) ENGINE INNODB, character set utf8mb4;