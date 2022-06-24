package pl.mt.exchange.provider

import jakarta.inject.Singleton
import java.math.BigDecimal

@Singleton
class OpenExchangeExchangeProvider : ExchangeProvider {

    override fun exchange(exchangeRequest: ExchangeProviderRequest): ExchangeProviderResponse {
        return ExchangeProviderResponse(BigDecimal.ZERO, "PLN")
    }
}