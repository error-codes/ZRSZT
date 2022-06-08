USE zrszt;
########################################################################################################################
DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    user_id   bigint(20) COMMENT '用户ID',
    nick_name varchar(50)  NOT NULL COMMENT '昵称',
    avatar    varchar(255) NOT NULL COMMENT '头像',
    phone     varchar(15)  NOT NULL COMMENT '手机号',
    channel   varchar(100) NOT NULL COMMENT '我的频道',
    PRIMARY KEY (user_id)
) ENGINE INNODB,
  character set utf8mb4;

########################################################################################################################
DROP TABLE IF EXISTS collect;

CREATE TABLE collect
(
    collect_id   bigint(20) COMMENT '收藏ID',
    entity_id    bigint(20) NOT NULL COMMENT '实体ID',
    user_id      bigint(20) NOT NULL COMMENT '用户ID',
    collect_time datetime   NOT NULL COMMENT '收藏时间',
    category     tinyint(3) NOT NULL COMMENT '实体类别',
    PRIMARY KEY (collect_id)
) ENGINE INNODB,
  character set utf8mb4;

########################################################################################################################
DROP TABLE IF EXISTS search_history;

CREATE TABLE search_history
(
    history_id  bigint(20) COMMENT '历史ID',
    user_id     bigint(20)   NOT NULL COMMENT '用户ID',
    keyword     varchar(100) NOT NULL COMMENT '搜索词',
    search_time datetime     NOT NULL COMMENT '搜索时间',
    PRIMARY KEY (history_id)
) ENGINE INNODB,
  character set utf8mb4;

