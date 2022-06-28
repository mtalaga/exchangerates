package pl.mt.exchange.provider.openexchangerates

import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import pl.mt.exchange.provider.ExchangeProvider
import pl.mt.exchange.provider.ExchangeProviderRequest
import pl.mt.exchange.provider.ExchangeProviderResponse

@Singleton
class OpenExchangeRatesExchangeProvider(val openExchangeRatesApiClient: OpenExchangeRatesApiClient) : ExchangeProvider {
    companion object {
        val LOGGER = LoggerFactory.getLogger(this::class.java)
    }

    val converter = USDToCurrenciesConverter()

    override fun exchange(exchangeRequest: ExchangeProviderRequest): ExchangeProviderResponse {
        val latest = openExchangeRatesApiClient.getLatest().block()
        val exchangeResult = converter.convert(
            latest.rates,
            exchangeRequest.currencyCodeFrom,
            exchangeRequest.currencyCodeTo,
            exchangeRequest.value
        )
        LOGGER.info("Got response from exchangerates: {}", latest)
        return ExchangeProviderResponse.successful(exchangeResult.value!!, exchangeResult.currencyCode!!)
    }
}