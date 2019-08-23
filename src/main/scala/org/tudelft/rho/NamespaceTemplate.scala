package org.tudelft.rho

import org.tudelft.rho.api.domain._
import org.tudelft.rho.api.fn._
import org.tudelft.rho.api.fn.FnNamespace._
import org.tudelft.rho.$namespace$._

class $namespace$ extends FnNamespace {

  type State = $namespace$State

  override def descriptor: FnNamespaceDescriptor =
    named("$namespace$")
      .withQualifiedPaths(
      ${register("$function$", $function$FnDef)}::,::function$
      )
      .withSerializers(
      ${classOf[$function$InputType]}::,::function$
      )

  override def initialState: State = $namespace$State

  override def onPersist: EventHandler[State] = {
    ${case ($function$InputType(_), $namespace$State(_)) => $namespace$State(_)}::\n::function$
    case (_, state)                                => state // Do nothing with the State
  }
  

  ${def $function$FnDef(input: $function$InputType, ctx: ExecutionContext[$function$OutputType], state: $namespace$State): Directive = {
    
    // Your business logic here

    ctx.thenPersist($function$OutputType(_)) {
      response: $function$OutputType ⇒
        ctx.returnWith(response)
    }
  }
  }::\n::function$

}

object $namespace$ {
  ${
  case class $function$InputType(_) extends FnRequest
  case class $function$OutputType(_) extends FnResponse
  }::\n::function$

  case class $namespace$State(_) extends ManagedState // Define members of state here, use them in the onPersist handler

  type State = $namespace$#State
}
