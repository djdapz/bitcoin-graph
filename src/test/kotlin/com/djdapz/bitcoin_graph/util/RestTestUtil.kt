package com.djdapz.bitcoin_graph.util

import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.verify
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate


inline fun <reified T> verifyJsonGetList(
        restTemplate: RestTemplate,
        url: String
) {
    val headers = LinkedMultiValueMap<String, String>()
    headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE)


    verify(restTemplate).exchange(
            eq(url),
            eq(HttpMethod.GET),
            eq(HttpEntity<Any>(headers)),
            eq(object : ParameterizedTypeReference<List<T>>() {})
    )
}

fun <T> verifyJsonGetObject(
        restTemplate: RestTemplate,
        url: String,
        klass: Class<T>
) {
    val headers = LinkedMultiValueMap<String, String>()
    headers.add(CONTENT_TYPE, APPLICATION_JSON_VALUE)

    verify(restTemplate).exchange(
            eq(url),
            eq(HttpMethod.GET),
            eq(HttpEntity<Any>(headers)),
            eq(klass)
    )
}