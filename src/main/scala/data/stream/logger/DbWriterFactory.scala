package data.stream.logger

import org.apache.flink.api.java.utils.ParameterTool

object DbWriterFactory {

  /** Get the logging backend db
    *
    * @return DbWriter
    */
  def createDbWriter(dbBackend: String, parameters: ParameterTool): DbWriter = dbBackend match {
    case "couchbase" => CouchBaseWriter.createFromParameters(parameters)
    case "console" => new ConsoleWriter
    case "kafka" => KafkaWriter.createFromParameters(parameters)
    case "postgresql" =>
      // TODO
      throw new UnsupportedOperationException
    case _ => throw new UnsupportedOperationException
  }





}
