package me.ixk.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CacheApplicationTests {
    @Autowired
    CachedService cachedService;

    @Test
    void cache() {
        log.info(cachedService.cache());
        log.info(cachedService.cache());
        cachedService.reloadCache();
        log.info(cachedService.cache());
    }
}
