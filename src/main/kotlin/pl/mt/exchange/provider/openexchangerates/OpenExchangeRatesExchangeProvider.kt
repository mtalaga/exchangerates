package pl.mt.exchange.provider.openexchangerates

import jakarta.inject.Singleton
import pl.mt.exchange.provider.ExchangeProvider
import pl.mt.exchange.provider.ExchangeProviderRequest
import pl.mt.exchange.provider.ExchangeProviderResponse

@Singleton
class OpenExchangeRatesExchangeProvider(private val openExchangeRatesApiClient: OpenExchangeRatesApiClient) :
    ExchangeProvider {

    private val converter = USDToCurrenciesConverter()

    override fun exchange(exchangeRequest: ExchangeProviderRequest): ExchangeProviderResponse {
        val latest = openExchangeRatesApiClient.getLatest().block()
            ?: return ExchangeProviderResponse.error("No exchange rates found in OpenExchangeRates")

        val exchangeResult = converter.convert(
            latest.rates,
            exchangeRequest.currencyCodeFrom,
            exchangeRequest.currencyCodeTo,
            exchangeRequest.value
        )

        if (exchangeResult.value != null && exchangeResult.currencyCode != null) {
            return ExchangeProviderResponse.successful(exchangeResult.value, exchangeResult.currencyCode)
        }

        return ExchangeProviderResponse.error(exchangeResult.errorMessage ?: "Unknown error occurred")
    }
}