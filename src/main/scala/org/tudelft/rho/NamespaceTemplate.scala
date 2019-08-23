package org.tudelft.rho

import org.tudelft.rho.api.fn._
import org.tudelft.rho.api.domain._
import org.tudelft.rho.api.fn.api.EventHandler
import org.tudelft.rho.api.fn.fnInterpreter._
import org.tudelft.rho.$namespace$._
import org.tudelft.rho.api.ExceptionMessage

class $namespace$ extends FnNamespace {

  type State = $namespace$State

  override def descriptor: FnNamespaceDescriptor =
    named("$namespace$")
      .withQualifiedPaths(
      ${register("$function$", $function$ _ ) }::,::function$
      )
      .withSerializers(classOf[CallbackRequestEnv], classOf[LogMessage], classOf[ExceptionMessage],
      ${classOf[$function-input$]}::,::function$
      )

  override def initialState: State = $namespace$State($initial-state$)

  override def onPersist: EventHandler[State] = {
    ${case ($function-output$($output-var-bindings$), $namespace$State($curr-state$)) => $namespace$State($state-update$)}::\n::function$
    case (_, state)                                => state // Do nothing with the State
  }
  

  ${def $function$($function-input-binding$: $function-input$, ctx: ExecutionContext[$function-output$], state: $namespace$State): Fn[$function-output$] = {
    $function-business-logic$  
  }
  }::\n::function$

}

object $namespace$ {
  ${
  case class $function-input$($function-input-def$) extends FnRequest
  case class $function-output$($function-output-def$) extends FnResponse
  }::\n::function$

  case class $namespace$State($state-def$) extends ManagedState // Define members of state here, use them in the onPersist handler

  type State = $namespace$#State
}
