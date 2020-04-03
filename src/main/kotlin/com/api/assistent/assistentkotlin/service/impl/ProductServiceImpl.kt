package com.api.assistent.assistentkotlin.service.impl

import com.api.assistent.assistentkotlin.entities.ProductEntitie
import com.api.assistent.assistentkotlin.exception.BusinessException
import com.api.assistent.assistentkotlin.repositorie.ProductRepositorie
import com.api.assistent.assistentkotlin.service.ProductService
import org.apache.logging.log4j.kotlin.logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service("productService")
class ProductServiceImpl : ProductService {

    @Autowired
    lateinit var repositorie : ProductRepositorie

    override fun insert(productEntitie : ProductEntitie) : ProductEntitie? {
        return try {
            val product = repositorie.save(productEntitie)
            if (product != null) {
                return product
            }
            throw BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Problema ao salvar produto")
        } catch (e : Exception) {
            throw BusinessException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.message.toString())
        }
    }





}