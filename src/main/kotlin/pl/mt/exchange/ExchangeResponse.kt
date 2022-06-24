package pl.mt.exchange

import pl.mt.exchange.provider.ExchangeProviderResponse
import java.math.BigDecimal

data class ExchangeResponse(val value: BigDecimal, val currency: String) {
    companion object {
        fun from(exchangeProviderResponse: ExchangeProviderResponse): ExchangeResponse {
            return ExchangeResponse(exchangeProviderResponse.value, exchangeProviderResponse.currencyCode)
        }
    }
}