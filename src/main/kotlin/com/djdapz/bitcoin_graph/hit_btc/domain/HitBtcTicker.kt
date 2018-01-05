package com.djdapz.bitcoin_graph.hit_btc.domain

import java.time.LocalDateTime

data class HitBtcTicker(
        val ask: Double,
        val bid: Double,
        val last: Double,
        val open: Double,
        val low: Double,
        val high: Double,
        val volume: Double,
        val volumeQuote: Double,
        val timestamp: LocalDateTime,
        val symbol: String
)
