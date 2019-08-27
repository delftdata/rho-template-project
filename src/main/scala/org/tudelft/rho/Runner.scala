package org.tudelft.rho
import grizzled.slf4j.Logging
import org.apache.flink.api.java.utils.ParameterTool
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.tudelft.rho.runtime.flink.FnFlinkRunnerWithKeyedSchema

object Runner extends Logging {

  def main(args: Array[String]): Unit = {

    val paramterTool = ParameterTool.fromArgs(args)

    val environment: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val fnNamespace = new $namespace$()

    val fnRunner = new FnFlinkRunnerWithKeyedSchema(fnNamespace, Some(paramterTool.getProperties))

    fnRunner.buildGraph(environment).execute(fnNamespace.descriptor.name)
  }
}
