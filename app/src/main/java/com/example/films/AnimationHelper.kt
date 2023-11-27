package com.example.films

import android.app.Activity
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import java.util.concurrent.Executors
import kotlin.math.hypot
import kotlin.math.roundToInt

object AnimationHelper {
    private const val menuItems = 4
    //В метод у нас приходит 3 параметра:
    //1 - наше rootView, которое одновременно является и контейнером
    //и объектом анимации
    //2 - активити для того, чтобы вернуть выполнение нового треда в UI поток
    //3 - позиция в меню навигации, чтобы круг проявления расходился именно от иконки меню навигации
    fun performFragmentCircularRevealAnimation(view: View, activity: Activity, position: Int) {
        //Создаем новый тред
        Executors.newSingleThreadExecutor().execute {
            //В бесконечном цикле проверяем, когда наше анимированное view будет "прикреплено" к экрану
            while (true) {
                //Когда оно будет прикреплено, выполним код
                if (view.isAttachedToWindow) {
                    //Возвращаемся в главный тред, чтобы выполнить анимацию
                    activity.runOnUiThread {
                        //Cуперсложная математика вычисления старта анимации
                        val itemCenter = view.width / (menuItems * 2)
                        val step = (itemCenter * 2) * (position - 1) + itemCenter

                        val x: Int = step
                        val y: Int = view.y.roundToInt() + view.height

                        val startRadius = 0
                        val endRadius = hypot(view.width.toDouble(), view.height.toDouble())
                        //Создаем саму анимацию
                        ViewAnimationUtils.createCircularReveal(view, x, y, startRadius.toFloat(), endRadius.toFloat()).apply {
                            //Устанавливаем время анимации
                            duration = 500
                            //Интерполятор для более естественной анимации
                            interpolator = AccelerateDecelerateInterpolator()
                            //Запускаем
                            start()
                        }
                        //Выставляем видимость нашего элемента
                        view.visibility = View.VISIBLE
                    }
                    return@execute
                }
            }
        }
    }
}
