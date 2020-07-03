package me.ixk.logger.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
  private final Logger logger = LoggerFactory.getLogger(Log.class);

  public void printLog() {
    logger.trace("Trace message");
    logger.debug("Debug message");
    logger.info("Info message");
    logger.warn("Warn message");
    logger.error("Error message");

    logger.info("Level: TRACE < DEBUG < INFO < WARN < ERROR < FATAL");
  }
}
