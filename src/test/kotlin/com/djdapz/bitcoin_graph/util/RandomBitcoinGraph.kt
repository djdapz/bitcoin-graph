package com.djdapz.bitcoin_graph.util

import com.djdapz.bitcoin_graph.graph.domain.CryptoQuote
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcCurrency
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcSymbol
import com.djdapz.bitcoin_graph.hit_btc.domain.HitBtcTicker
import java.time.LocalDateTime

fun randomHitBtcSymbol(
        id: String = randomString(),
        baseCurrency: String = randomString(),
        quoteCurrency: String = randomString(),
        quantityIncrement: Double = randomDouble(),
        tickSize: Double = randomDouble(),
        takeLiquidityRate: Double = randomDouble(),
        provideLiquidityRate: Double = randomDouble(),
        feeCurrency: String = randomString()
): HitBtcSymbol =
        HitBtcSymbol(
                id = id,
                baseCurrency = baseCurrency,
                quoteCurrency = quoteCurrency,
                quantityIncrement = quantityIncrement,
                tickSize = tickSize,
                takeLiquidityRate = takeLiquidityRate,
                provideLiquidityRate = provideLiquidityRate,
                feeCurrency = feeCurrency
        )

fun randomHitBtcTicker(
        ask: Double = randomDouble(),
        bid: Double = randomDouble(),
        last: Double = randomDouble(),
        open: Double = randomDouble(),
        low: Double = randomDouble(),
        high: Double = randomDouble(),
        volume: Double = randomDouble(),
        volumeQuote: Double = randomDouble(),
        timestamp: LocalDateTime = randomLocalDateTime(),
        symbol: String = randomString()
): HitBtcTicker =
        HitBtcTicker(
                ask = ask,
                bid = bid,
                last = last,
                open = open,
                low = low,
                high = high,
                volume = volume,
                volumeQuote = volumeQuote,
                timestamp = timestamp,
                symbol = symbol)

fun randomCryptoQuote(
        ask: Double = randomDouble(),
        bid: Double = randomDouble(),
        last: Double = randomDouble(),
        open: Double = randomDouble(),
        volume: Double = randomDouble(),
        timestamp: LocalDateTime = randomLocalDateTime(),
        symbol: String = randomString(),
        quoteCurrency: String = randomString(),
        baseCurrency: String = randomString()
): CryptoQuote =
        CryptoQuote(
                ask = ask,
                bid = bid,
                last = last,
                open = open,
                volume = volume,
                timestamp = timestamp,
                symbol = symbol,
                quoteCurrency = quoteCurrency,
                baseCurrency = baseCurrency
        )

fun randomHitBtcCurrency(
        id: String = randomString(),
        fullName: String = randomString(),
        crypto: Boolean = randomBoolean(),
        payinEnabled: Boolean = randomBoolean(),
        payinPaymentId: Boolean = randomBoolean(),
        payinConfirmations: Int = randomInt(),
        payoutEnabled: Boolean = randomBoolean(),
        payoutIsPaymentId: Boolean = randomBoolean(),
        transferEnabled: Boolean = randomBoolean()
): HitBtcCurrency =
        HitBtcCurrency(
                id = id,
                fullName = fullName,
                crypto = crypto,
                payinEnabled = payinEnabled,
                payinPaymentId = payinPaymentId,
                payinConfirmations = payinConfirmations,
                payoutEnabled = payoutEnabled,
                payoutIsPaymentId = payoutIsPaymentId,
                transferEnabled = transferEnabled
        )