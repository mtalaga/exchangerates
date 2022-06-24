package pl.mt.exchange.provider

interface ExchangeProvider {

    fun exchange(exchangeRequest: ExchangeProviderRequest): ExchangeProviderResponse
}