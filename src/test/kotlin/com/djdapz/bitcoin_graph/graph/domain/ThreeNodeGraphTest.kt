package com.djdapz.bitcoin_graph.graph.domain

import com.djdapz.bitcoin_graph.util.randomCryptoQuote
import com.djdapz.bitcoin_graph.util.randomString
import org.assertj.core.api.Assertions.assertThat

import org.junit.Test
import java.util.*

class ThreeNodeGraphTest {
    private val firstCurrencyCode = randomString(3)
    private val secondCurrencyCode = randomString(3)
    private val thirdCurrencyCode = randomString(3)

    private val quote_1_to_2 = randomCryptoQuote(
            baseCurrency = firstCurrencyCode,
            quoteCurrency = secondCurrencyCode
    )

    private val quote_2_to_3 = randomCryptoQuote(
            baseCurrency = secondCurrencyCode,
            quoteCurrency = thirdCurrencyCode
    )

    private val quote_3_to_1 = randomCryptoQuote(
            baseCurrency = thirdCurrencyCode,
            quoteCurrency = firstCurrencyCode
    )

    private val cryptoQuotes = Arrays.asList(quote_1_to_2, quote_2_to_3, quote_3_to_1)
    private val currencies = Arrays.asList(firstCurrencyCode, secondCurrencyCode, thirdCurrencyCode)


    private val subject = Graph(
            currencies = currencies,
            quotes = cryptoQuotes
    )

    private val firstNode = subject.nodes.getValue(firstCurrencyCode)
    private val secondNode = subject.nodes.getValue(secondCurrencyCode)
    private val thirdNode = subject.nodes.getValue(thirdCurrencyCode)

    @Test
    internal fun `should create graph with three nodes`() {
        assertThat(subject.nodes.size).isEqualTo(3)
    }

    @Test
    internal fun `should give each node two connections`() {
        assertThat(firstNode.connections.values.size).isEqualTo(2)
        assertThat(secondNode.connections.values.size).isEqualTo(2)
        assertThat(thirdNode.connections.values.size).isEqualTo(2)
    }

    @Test
    internal fun `should be able to reuturn to first node`() {
        val expectedSecondNode = firstNode.connections.getValue(secondNode.currency).node
        val expectedThirdNode = expectedSecondNode.connections.getValue(thirdNode.currency).node
        val expectedFirstNode = expectedThirdNode.connections.getValue(firstNode.currency).node

        assertThat(expectedFirstNode).isEqualTo(firstNode)
        assertThat(expectedSecondNode).isEqualTo(secondNode)
        assertThat(expectedThirdNode).isEqualTo(thirdNode)
    }
}