package com.djdapz.bitcoin_graph.graph.domain

import java.time.LocalDateTime

data class CryptoQuote(
        val ask: Double,
        val bid: Double,
        val last: Double,
        val open: Double,
        val volume: Double,
        val timestamp: LocalDateTime,
        val symbol: String,
        val baseCurrency: String,
        val quoteCurrency: String
)