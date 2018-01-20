package com.djdapz.bitcoin_graph.util

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders.CONTENT_TYPE
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate

//fun <T> getJsonList(restTemplate: RestTemplate, url: String): List<T> {
//    return restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(headers), ReturnType<T>()).body
//}
//

inline fun <reified RESPONSE> getAll(restTemplate: RestTemplate,
                                     url: String): List<RESPONSE> =
        getJsonValue(restTemplate, url, object : ParameterizedTypeReference<List<RESPONSE>>() {})


fun <RESPONSE> getJsonValue(restTemplate: RestTemplate,
                            url: String,
                            type: Class<RESPONSE>): RESPONSE = restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(getHeaders()), type).body


fun <RESPONSE> getJsonValue(restTemplate: RestTemplate,
                            url: String,
                            type: ParameterizedTypeReference<RESPONSE>): RESPONSE = restTemplate.exchange(url, HttpMethod.GET, HttpEntity<Any>(getHeaders()), type).body


fun getHeaders() = LinkedMultiValueMap<String, String>().apply { add(CONTENT_TYPE, APPLICATION_JSON_VALUE) }