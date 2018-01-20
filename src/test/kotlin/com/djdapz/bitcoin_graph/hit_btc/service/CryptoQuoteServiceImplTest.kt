package com.djdapz.bitcoin_graph.hit_btc.service

import com.djdapz.bitcoin_graph.graph.domain.CryptoQuote
import com.djdapz.bitcoin_graph.hit_btc.client.HitBtcClient
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import com.djdapz.bitcoin_graph.util.randomHitBtcCurrency
import com.djdapz.bitcoin_graph.util.randomHitBtcSymbol
import com.djdapz.bitcoin_graph.util.randomHitBtcTicker
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Arrays.asList

class CryptoQuoteServiceImplTest {

    private val firstCurrency = randomHitBtcCurrency()
    private val secondCurrency = randomHitBtcCurrency()

    private val firstSymbol = randomHitBtcSymbol()
    private val secondSymbol = randomHitBtcSymbol()

    private val firstTicker = randomHitBtcTicker(symbol = firstSymbol.id)
    private val secondTicker = randomHitBtcTicker(symbol = secondSymbol.id)

    private val hitBtcClient = mock<HitBtcClient>{
        on{getTickers()} doReturn asList(firstTicker, secondTicker)
        on{getSymbols()} doReturn asList(firstSymbol, secondSymbol)
        on { getCurrencies() } doReturn asList(firstCurrency, secondCurrency)
    }

    private val subject = CryptoQuoteServiceImpl(hitBtcClient)


    @Test
    internal fun `should return hash of tickers`(){
        val actual = subject.getTickersHash()

        val expected = HashMap<String, HitBtcTicker>()
        expected.put(firstTicker.symbol, firstTicker)
        expected.put(secondTicker.symbol, secondTicker)

        assertThat(expected).containsAllEntriesOf(actual)
    }

    @Test
    internal fun `should return list of symbols`(){
        val actual = subject.getSymbolsHash()

        val expected = HashMap<String, HitBtcSymbol>()
        expected.put(firstSymbol.id, firstSymbol)
        expected.put(secondSymbol.id, secondSymbol)

        assertThat(expected).containsAllEntriesOf(actual)
    }

    @Test
    internal fun `should return list of tickers `(){
        val expected = subject.getTickers()
        assertThat(expected).contains(firstTicker, secondTicker)
    }

    @Test
    internal fun `should return list of symbols `(){
        val expected = subject.getSymbols()
        assertThat(expected).contains(firstSymbol, secondSymbol)
    }

    @Test
    internal fun `should return list of currencies `() {
        val expected = subject.getCurrencies()
        assertThat(expected).contains(firstCurrency.id, secondCurrency.id)
    }

    @Test
    internal fun `should return list of crytoquotes`() {
        val firstCryptoQuote = CryptoQuote(
                ask = firstTicker.ask,
                bid = firstTicker.bid,
                last = firstTicker.last,
                open = firstTicker.open,
                volume = firstTicker.volume,
                timestamp = firstTicker.timestamp,
                symbol = firstTicker.symbol,
                baseCurrency = firstSymbol.baseCurrency,
                quoteCurrency = firstSymbol.quoteCurrency
        )

        val secondCryptoQuote = CryptoQuote(
                ask = secondTicker.ask,
                bid = secondTicker.bid,
                last = secondTicker.last,
                open = secondTicker.open,
                volume = secondTicker.volume,
                timestamp = secondTicker.timestamp,
                symbol = secondTicker.symbol,
                baseCurrency = secondSymbol.baseCurrency,
                quoteCurrency = secondSymbol.quoteCurrency
        )
        assertThat(subject.getCryptoQuotes()).containsExactly(firstCryptoQuote, secondCryptoQuote)
    }

}