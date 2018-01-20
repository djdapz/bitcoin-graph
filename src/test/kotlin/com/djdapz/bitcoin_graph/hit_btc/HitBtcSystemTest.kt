package com.djdapz.bitcoin_graph.hit_btc

import com.djdapz.bitcoin_graph.config.JacksonConfig.Companion.asString
import com.djdapz.bitcoin_graph.util.randomHitBtcSymbol
import com.djdapz.bitcoin_graph.util.randomHitBtcTicker
import com.djdapz.bitcoin_graph.util.randomList
import com.djdapz.bitcoin_graph.util.randomString
import com.github.tomakehurst.wiremock.client.WireMock.*
import com.github.tomakehurst.wiremock.junit.WireMockRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.Arrays.asList

@RunWith(SpringJUnit4ClassRunner::class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HitBtcSystemTest() {

    @Suppress("RedundantVisibilityModifier", "unused")
    @get:Rule
    public var wireMockRule = WireMockRule(8901)

    @Autowired
    private var restTemplate: TestRestTemplate = TestRestTemplate()


    private val currencies = asList(randomList { randomString() })
    private val symbols = asList(randomList { randomHitBtcSymbol() })
    private val tickers = asList(randomList { randomHitBtcTicker() })

    @Before
    fun setUp() {
        stubFor(get(urlMatching(".*/currency.*"))
                .withHeader(CONTENT_TYPE, equalTo(APPLICATION_JSON.toString()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(asString(currencies))))

        stubFor(get(urlMatching(".*/symbol.*"))
                .withHeader(CONTENT_TYPE, equalTo(APPLICATION_JSON.toString()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(asString(symbols))))

        stubFor(get(urlMatching(".*/ticker.*"))
                .withHeader(CONTENT_TYPE, equalTo(APPLICATION_JSON.toString()))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody(asString(tickers))))
    }

    @Test
    internal fun `should create a list of CryptoQuotes`() {
        restTemplate.getForObject("/graph", String::class.java)
    }
}