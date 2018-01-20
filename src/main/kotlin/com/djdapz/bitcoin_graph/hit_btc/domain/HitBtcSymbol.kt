package com.djdapz.bitcoin_graph.hit_btc.domain

data class HitBtcSymbol(
        val id: String,
        val baseCurrency: String,
        val quoteCurrency: String,
        val quantityIncrement: Double,
        val tickSize: Double,
        val takeLiquidityRate: Double,
        val provideLiquidityRate: Double,
        val feeCurrency: String
)
