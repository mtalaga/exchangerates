package pl.mt.exchange.provider.opexchangerates

import pl.mt.exchange.provider.ExchangeProviderRequest
import pl.mt.exchange.provider.openexchangerates.OpenExchangeRatesApiClient
import pl.mt.exchange.provider.openexchangerates.OpenExchangeRatesExchangeProvider
import reactor.core.publisher.Mono
import spock.lang.Specification

class OpenExchangeRatesExchangeProviderSpec extends Specification {

    void 'when no rates returned should return specific message'() {
        given:
        OpenExchangeRatesApiClient openExchangeRatesApiClient = Stub()
        openExchangeRatesApiClient.latest >> Mono.empty()
        def openExchangeRatesExchangeProvider = new OpenExchangeRatesExchangeProvider(openExchangeRatesApiClient)
        def request = new ExchangeProviderRequest(10.0, "USD", "EUR")

        when:
        def result = openExchangeRatesExchangeProvider.exchange(request)

        then:
        result.value == null
        result.currencyCode == null
        result.errorMessage == "No exchange rates found in OpenExchangeRates"

    }
}
