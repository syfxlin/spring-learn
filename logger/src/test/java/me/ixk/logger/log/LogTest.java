package me.ixk.logger.log;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 需要启动 Spring 环境，配置才能生效，Trace 级别的日志才会打印出来（默认是 DEBUG）
@SpringBootTest
class LogTest {

  @Test
  void test() {
    Log log = new Log();
    log.printLog();
  }
}
