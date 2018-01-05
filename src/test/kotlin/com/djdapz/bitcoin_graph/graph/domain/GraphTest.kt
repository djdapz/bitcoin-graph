package com.djdapz.bitcoin_graph.graph.domain

import com.djdapz.bitcoin_graph.util.randomCryptoQuote
import com.djdapz.bitcoin_graph.util.randomString
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.util.Arrays.asList
import java.util.Collections.singletonList

class TwoNodeGraphTest {
    private val firstCurrencyCode = randomString(3)
    private val secondCurrencyCode = randomString(3)

    private val quote = randomCryptoQuote(
            baseCurrency = firstCurrencyCode,
            quoteCurrency = secondCurrencyCode
    )

    private val cryptoQuotes = singletonList(quote)
    private val currencies = asList(firstCurrencyCode, secondCurrencyCode)


    private val subject = Graph(
            currencies = currencies,
            quotes = cryptoQuotes
    )

    private val firstNode = subject.nodes.getValue(firstCurrencyCode)
    private val secondNode = subject.nodes.getValue(secondCurrencyCode)

    @Test
    fun `should Create Graph With Two Nodes When Passed Two Currencies`() {
        assertThat(subject.nodes.size).isEqualTo(currencies.size)
        currencies.forEach {
            assertThat(subject.nodes.containsKey(it))
        }
    }

    @Test
    fun `should Give Each Node One Connection When There Is A Ticker Between the Two`() {
        val expectedFirstCurrencyConnection = CryptoNodeConnection(
                secondNode,
                quote.ask
        )

        val expectedSecondCurrencyConnection = CryptoNodeConnection(
                firstNode,
                1 / quote.bid
        )

        assertThat(subject.nodes.getValue(firstCurrencyCode).connections.values).containsExactly(expectedFirstCurrencyConnection)
        assertThat(subject.nodes.getValue(secondCurrencyCode).connections.values).containsExactly(expectedSecondCurrencyConnection)
    }

    @Test
    internal fun `should be able to traverse back to original`() {
        val expectedFirstNode = firstNode
                .connections.getValue(secondCurrencyCode).node
                .connections.getValue(firstCurrencyCode).node
        assertThat(expectedFirstNode).isEqualTo(firstNode)
    }

}