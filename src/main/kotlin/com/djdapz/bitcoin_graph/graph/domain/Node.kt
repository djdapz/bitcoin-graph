package com.djdapz.bitcoin_graph.graph.domain

class Node (val currency: String, val connections: MutableMap<String, CryptoNodeConnection> = HashMap())