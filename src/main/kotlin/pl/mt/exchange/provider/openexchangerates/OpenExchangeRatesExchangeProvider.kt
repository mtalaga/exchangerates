package pl.mt.exchange.provider.openexchangerates

import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import pl.mt.exchange.provider.ExchangeProvider
import pl.mt.exchange.provider.ExchangeProviderRequest
import pl.mt.exchange.provider.ExchangeProviderResponse
import java.math.BigDecimal

@Singleton
class OpenExchangeRatesExchangeProvider(val openExchangeRatesApiClient: OpenExchangeRatesApiClient) : ExchangeProvider {

    companion object {
        val LOGGER = LoggerFactory.getLogger(this::class.java)
    }

    override fun exchange(exchangeRequest: ExchangeProviderRequest): ExchangeProviderResponse {
        val latest = openExchangeRatesApiClient.getLatest().block()
        LOGGER.info("Got response from exchangerates: {}", latest)
        return ExchangeProviderResponse(BigDecimal.ZERO, "PLN")
    }
}