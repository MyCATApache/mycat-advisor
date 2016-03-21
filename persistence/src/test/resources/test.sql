USE test;
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info
(
   id               INTEGER NOT NULL AUTO_INCREMENT COMMENT '编号',
   userName             VARCHAR(36) COMMENT '用户名',
   PRIMARY KEY (id)
   );

INSERT INTO user_info(userName) VALUES('YangLong');