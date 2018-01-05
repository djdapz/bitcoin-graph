package com.djdapz.bitcoin_graph.util

import org.springframework.core.ParameterizedTypeReference

class ReturnType<T> : ParameterizedTypeReference<List<T>>()