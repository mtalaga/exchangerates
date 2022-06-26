package pl.mt.exchange.provider.openexchangerates

import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client("\${openexchangerates.url}")
@Header(name = ACCEPT, value = "application/json")
interface OpenExchangeRatesApiClient {

    @Get("/latest.json?app_id=\${openexchangerates.appid}")
    fun getLatest(): Mono<Latest>
}