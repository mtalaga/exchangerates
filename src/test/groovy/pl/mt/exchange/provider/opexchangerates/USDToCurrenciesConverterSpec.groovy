package pl.mt.exchange.provider.opexchangerates

import pl.mt.exchange.provider.openexchangerates.USDToCurrenciesConverter
import spock.lang.Specification

class USDToCurrenciesConverterSpec extends Specification {

    void 'should successfully convert values'(String fromCurrency, String toCurrency, BigDecimal value, BigDecimal expectedValue) {

        given:
        def rates = [PLN: 4.424048, EUR: 0.943686, USD: 1.0]
        def converter = new USDToCurrenciesConverter()

        expect:
        def result = converter.convert(rates, fromCurrency, toCurrency, value)
        result.currencyCode == toCurrency
        result.value == expectedValue
        result.errorMessage == null

        where:
        fromCurrency | toCurrency | value | expectedValue
        "PLN"        | "EUR"      | 10    | 2.13
        "EUR"        | "PLN"      | 2.1   | 9.87
        "USD"        | "EUR"      | 100   | 94.37
        "EUR"        | "USD"      | 100   | 105.97
    }

    void 'should return 0 when fromCurrency not found'() {
        given:
        def rates = [PLN: 4.424048, EUR: 0.943686, USD: 1.0]
        def converter = new USDToCurrenciesConverter()

        when:
        def result = converter.convert(rates, "GBP", "USD", 1.0)

        then:
        result.currencyCode == null
        result.value == null
        result.errorMessage == "Did not found currency from which you would like convert in provided rates"
    }

    void 'should return 0 when toCurrency not found'() {
        given:
        def rates = [PLN: 4.424048, EUR: 0.943686, USD: 1.0]
        def converter = new USDToCurrenciesConverter()

        when:
        def result = converter.convert(rates, "USD", "GBP", 1.0)

        then:
        result.currencyCode == null
        result.value == null
        result.errorMessage == "Did not found currency to which you would like convert in provided rates"
    }
}
