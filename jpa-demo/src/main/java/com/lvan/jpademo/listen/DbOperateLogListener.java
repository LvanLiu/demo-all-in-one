package com.lvan.jpademo.listen;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@Slf4j
public class DbOperateLogListener {

    @PostPersist
    private void postPersist(Object entity) {
        log.info("save entity");
    }

    @PostUpdate
    private void PostUpdate(Object entity) {
        log.info("update entity");
    }
}
