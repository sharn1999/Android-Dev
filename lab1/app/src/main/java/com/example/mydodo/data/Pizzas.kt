package com.example.mydodo.data

import com.example.mydodo.R
import com.example.mydodo.templates.PizzaItem

class Pizzas {
    fun getPizzasInfo(): List<PizzaItem> {
        return listOf(
            PizzaItem("Вау Кебаб!", "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус", R.drawable.vay, 2900),
            PizzaItem("Пеперони с грибами", "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо", R.drawable.pepperoni, 2000),
            PizzaItem("Ветчина и огурчики", "Соус ранч, моцарелла, ветчина из цыпленка, маринованные огурчики, красный лук", R.drawable.vetchina, 2300),
            PizzaItem("Миксик", "Пицца четвертинками с ветчиной из цыпленка, томатами, брынзой, моцареллой, фирменным соусом альфредо. Набор юного садовода в подарок", R.drawable.smeshariki, 4000)
        );
    }
}