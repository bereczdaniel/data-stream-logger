package data.stream.logger

import data.stream.logger.types.LogDataStruct

trait DbWriter extends Serializable {
  // TODO error handling, exceptions
  def writeToDb(d: LogDataStruct): Unit

  def open: Unit

  def close: Unit
}
