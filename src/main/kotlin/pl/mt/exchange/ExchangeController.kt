package pl.mt.exchange

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import javax.validation.Valid

@Controller("/exchange")
open class ExchangeController(@Inject private val exchangeService: ExchangeService) {

    @Post(produces = [MediaType.APPLICATION_JSON])
    open fun exchange(@Body @Valid request: ExchangeRequest): ExchangeResponse {
        return exchangeService.exchange(request)
    }

}