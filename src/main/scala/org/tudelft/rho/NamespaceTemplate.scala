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
      ${classOf[$function$inputType]}::,::function$
      )

  override def initialState: State = $namespace$State

  override def onPersist: EventHandler[State] = {
    ${case ($function$inputType(_), $namespace$State(_)) => $namespace$State(_)}::\n::function$
    case (_, state)                                => state // Do nothing with the State
  }

  ${def $function$FnDef = FnDescriptor2[$function$inputType, $function$outputType, $namespace$State] {
    (req, ctx, state) =>
      ctx.actions.onRequest[$function$inputType, $function$outputType, $namespace$State] {
        case ($function$inputType(_), ctx, state) =>
          //processing
          ctx.thenPersist($function$outputType(_)) {
            response: $function$outputType =>
              // post persist actions
              ctx.returnWith(response)
          }
      }
  }}::\n::function$

}

object $namespace$ {
  ${
  case class $function$inputType(_) extends FnRequest
  case class $function$outputType(_) extends FnResponse
  }::\n::function$

  case class $namespace$State(_) extends ManagedState // Define members of state here, use them in the onPersist handler

  type State = $namespace$#State
}