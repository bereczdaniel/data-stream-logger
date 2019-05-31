package data.stream.logger.writers

import data.stream.logger.{DataStreamLoggerMap, DbWriter}
import data.stream.logger.types.{LogDataConstFields, LogDataStruct}

class ConsoleWriter extends DbWriter {
  override def writeToDb(d: LogDataStruct) = {
    println(d.toString)
  }

  override def close: Unit = {}

  override def open: Unit = {}
}

/**
  * A test method:
  */
object ConsoleWriter {
  def main(args: Array[String]): Unit = {
    val cw = new ConsoleWriter()
    val lds = LogDataStruct.createFromMessage[Long](1, x=>x, DataStreamLoggerMap.getCurrentTimestamp, new LogDataConstFields("start", 456, "kafka"))
    cw.writeToDb(lds)
  }
}