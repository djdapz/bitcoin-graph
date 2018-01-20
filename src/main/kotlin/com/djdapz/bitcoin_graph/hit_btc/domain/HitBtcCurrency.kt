package com.djdapz.bitcoin_graph.hit_btc.domain

class HitBtcCurrency(
        val id: String,
        val fullName: String,
        val crypto: Boolean,
        val payinEnabled: Boolean,
        val payinPaymentId: Boolean,
        val payinConfirmations: Int,
        val payoutEnabled: Boolean,
        val payoutIsPaymentId: Boolean,
        val transferEnabled: Boolean
)