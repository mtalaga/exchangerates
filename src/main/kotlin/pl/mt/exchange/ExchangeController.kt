package pl.mt.exchange

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import javax.validation.Valid

@Controller("/exchange")
open class ExchangeController(@Inject val exchangeService: ExchangeService) {

    companion object {
        val LOGGER = LoggerFactory.getLogger(this::class.java)
    }

    @Get(produces = [MediaType.APPLICATION_JSON])
    fun getExchange(): String {
        LOGGER.info("I'm there!")
        return "OK"
    }

    @Post(produces = [MediaType.APPLICATION_JSON])
    open fun exchange(@Body @Valid request: ExchangeRequest): ExchangeResponse {
        return exchangeService.exchange(request)
    }

}