package com.coelho.noteskotlin.container

import com.github.dockerjava.api.model.ExposedPort
import com.github.dockerjava.api.model.PortBinding
import com.github.dockerjava.api.model.Ports.Binding.bindPort
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.MySQLContainer

class MysqlContainer: GenericContainer<MysqlContainer> {

    constructor() : super("mysql:5.6") {
        withEnv("MYSQL_ROOT_PASSWORD", "password")
        withEnv("MYSQL_DATABASE", "demo")
        withEnv("MYSQL_USER", "demo_user")
        withEnv("MYSQL_PASSWORD", "demo_pass")
        withCreateContainerCmdModifier { consumer ->
            consumer.withName("mysql-test")
            consumer.withPortBindings(PortBinding(bindPort(MySQLContainer.MYSQL_PORT), ExposedPort(MySQLContainer.MYSQL_PORT)))
        }
    }
}