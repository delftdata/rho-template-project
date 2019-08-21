package org.tudelft.rho

import java.io.{ByteArrayOutputStream, ObjectOutputStream}

import grizzled.slf4j.Logging
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.TimeCharacteristic
import org.tudelft.rho.gateway.GatewayCommunication.{JsonSupport, RegisterServiceSerialized}
import org.tudelft.rho.runtime.flink.FnFlinkRunnerWithByteArraySchema
import scalaj.http.{Http, HttpOptions}

// Required arguments:
// --bootstrap.servers localhost:9092 --zookeeper.connect localhost:2181

object Runner extends Logging {

  def main(args: Array[String]): Unit = {
    val paramterTool = ParameterTool.fromArgs(args)

    val bootstrapServer = paramterTool.getRequired("bootstrap.servers")
    logger.info("kafka Servers $bootstrapServer")
    logger.info("Zookeeper Servers zookeeper")

    val MaxParallelism                          = $parallelism$
    val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val fnNamespace                             = new $namespace$()

    val fnRunner = new FnFlinkRunnerWithByteArraySchema(fnNamespace, Some(paramterTool.getProperties))

    fnRunner.buildGraph(environment).execute()
  }
}
