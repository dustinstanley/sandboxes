package com.example.demo.services

import org.amshove.kluent.shouldHaveTheSameClassAs

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

//import io.mockk.confirmVerified
//import io.mockk.junit5.MockKExtension
//import io.mockk.spyk
//import io.mockk.verify

class WeatherServiceTest : Spek({
    println("this is the root")
    describe("adding numbers") {
        it("two kotlin objects compared") {
            val test1 = WeatherService()
            val test2 = WeatherService()
            test1 shouldHaveTheSameClassAs test2
        }
        it("two java objects compared") {
            val test1 = WeatherServiceJava()
            val test2 = WeatherServiceJava()
            test1 shouldHaveTheSameClassAs test2
        }
    }
    group("some group") {
        println("some group")
        test("some test") {
            println("some test")
        }
    }
    group("another group") {
        println("another group")
        test("another test") {
            println("another test")
        }
    }
})
