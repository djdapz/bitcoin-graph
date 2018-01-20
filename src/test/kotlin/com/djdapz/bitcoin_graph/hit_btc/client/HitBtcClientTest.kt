package com.djdapz.bitcoin_graph.hit_btc.client

import com.djdapz.bitcoin_graph.hit_btc.config.UrlConfig
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcCurrency
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import com.djdapz.bitcoin_graph.util.*
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import java.util.*

class HitBtcClientTest {

    private val symbols = randomList { randomHitBtcSymbol() }
    private val tickers = randomList { randomHitBtcTicker() }
    private val currencies = randomList { randomHitBtcCurrency() }

    private val symbolUrl = randomUrl()
    private val tickerUrl = randomUrl()
    private val currencyUrl = randomUrl()

    private val restTemplate = mock<RestTemplate> {
        on { exchange(eq(symbolUrl.toString()), any(), any(), any<ParameterizedTypeReference<*>>()) } doReturn ResponseEntity(symbols, HttpStatus.OK)
        on { exchange(eq(tickerUrl.toString()), any(), any(), any<ParameterizedTypeReference<*>>()) } doReturn ResponseEntity(tickers, HttpStatus.OK)
        on { exchange(eq(currencyUrl.toString()), any(), any(), any<ParameterizedTypeReference<*>>()) } doReturn ResponseEntity(currencies, HttpStatus.OK)
    }

    private val urlConfig = mock<UrlConfig> {
        on { getSymbolsUrl() } doReturn symbolUrl
        on { getTickerUrl() } doReturn tickerUrl
        on { getCurrencyUrl() } doReturn currencyUrl
    }

    private val subject = HitBtcClient(restTemplate, urlConfig)

    @Test
    internal fun `should return all symbols`() {
        val actual: List<HitBtcSymbol> = subject.getSymbols()
        assertThat(actual).containsExactlyElementsOf(symbols)
    }

    @Test
    internal fun `should call rest template to get all symbols`() {
        subject.getSymbols()
        verifyJsonGetList<HitBtcSymbol>(restTemplate, symbolUrl.toExternalForm())
    }

    @Test
    internal fun `should return all tickers`() {
        val actual: List<HitBtcTicker> = subject.getTickers()
        assertThat(actual).containsExactlyElementsOf(tickers)
    }

    @Test
    internal fun `should call rest template to get all tickers`() {
        subject.getTickers()
        verifyJsonGetList<HitBtcTicker>(restTemplate, tickerUrl.toExternalForm())
    }

    @Test
    internal fun `should get all currencies`() {
        val actual: List<HitBtcCurrency> = subject.getCurrencies()
        assertThat(actual).containsExactlyElementsOf(currencies)
    }

    @Test
    internal fun `should call rest template to get all currencies`() {
        subject.getCurrencies()
        verifyJsonGetList<Currency>(restTemplate, currencyUrl.toExternalForm())
    }
}