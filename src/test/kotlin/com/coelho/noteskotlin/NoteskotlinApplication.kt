package com.coelho.noteskotlin

import com.coelho.noteskotlin.container.MysqlContainer
import org.junit.BeforeClass
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Profile
import org.testcontainers.containers.Network

@Profile("test")
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = [NoteskotlinApplication::class])
class NoteskotlinApplication {

    companion object {
        private val mysqlContainer = MysqlContainer()

        @BeforeClass
        @JvmStatic
        fun setup() {
            if (!mysqlContainer.isRunning) mysqlContainer.start()

        }
    }

}