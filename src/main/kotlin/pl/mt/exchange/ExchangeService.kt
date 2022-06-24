package pl.mt.exchange

import jakarta.inject.Singleton
import pl.mt.exchange.provider.ExchangeProvider
import pl.mt.exchange.provider.ExchangeProviderRequest

@Singleton
class ExchangeService(val exchangeProvider: ExchangeProvider) {

    fun exchange(request: ExchangeRequest): ExchangeResponse {
        val response = exchangeProvider.exchange(ExchangeProviderRequest.from(request))
        return ExchangeResponse.from(response)
    }
}