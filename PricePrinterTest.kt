package com.example.dmitrii_korolev_shop

import org.junit.Test

import org.junit.Assert.*
import kotlin.math.roundToInt

class PricePrinterTest {
    @Test
    fun addition_isCorrect() {
        val assaultRifle = Product(5000.0, "Assault rifle", 10)
        val pumpShotgun = Product (3000.0, "Pump-action shotgun", 5)
        val SMG = Product (4000.0, "Submachine gun",20)

        val basket = Basket(listOf(assaultRifle, pumpShotgun, SMG))
        println(basket.calcTotalPrice())

        val basketPrinter = FullBasketProductsPrinter()
        basketPrinter.printBasket(basket)
    }

    class Basket(
        private val products: List<Product>
    ) {
        fun calcTotalPrice() : Double
        {
            var result: Double = 0.0
            for (element in products)  result+= element.calcDiscountPrice()
            return result
        }

        fun getProducts() : List<Product> = products
    }

    class Product(
        private val price: Double,
        private val name: String,
        private val salePercent: Int = 0
    ) {
        fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
        fun getName() = name
    }

    class FullBasketProductsPrinter : BasketPrinter{
        override fun printBasket(basket: Basket) {
            val allProducts: List<Product> = basket.getProducts()
            for (element in allProducts)  println(element.getName())
        }
    }

    interface BasketPrinter{
        fun printBasket(basket:Basket)
    }
}
