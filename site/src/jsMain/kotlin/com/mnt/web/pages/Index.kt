package com.mnt.web.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaFaceSmile
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.style.selectors.focus
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Page
@Composable
fun HomePage() {
    var name by remember { mutableStateOf("") }
Column (
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Row(verticalAlignment = Alignment.CenterVertically){
        FaFaceSmile(
            modifier = Modifier.margin (right = 10.px),
            size = IconSize.XL,
            style = IconStyle.OUTLINE
        )
        P(
            attrs = Modifier
                .fontSize(45.px)
                .toAttrs()
        ) {
            Text(value = "Hello, ${name.capitalize()}!")
        }
    }
    Input(
        type = InputType.Text,
        attrs = InputStyle.toModifier()
            .padding ( topBottom =10.px, leftRight = 20.px )
            .fontSize(20.px)
            .outline(
                width = 0.px,
                style = LineStyle.None,
                color = Colors.Azure

            )
            .backgroundColor(Theme.Bloo.color)
            .transition(CSSTransition(property = "border", duration = 350.ms))
            .toAttrs {
                placeholder(value = "Enter your name")
                onInput { name = it.value }
            }
    )
    Button(
        modifier =  Modifier.margin (top = 24.px)
            .outlineColor(Theme.Aqua.color),
        onClick = { println("Testing!") }
    )
    {
        Text(value = "Press me!")
    }
}
}
val InputStyle by ComponentStyle{
    base {
        Modifier.border (
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Bloo.color
        )
    }
    focus{
        Modifier.border (
            width = 2.px,
            style = LineStyle.Solid,
            color = Theme.Aqua.color
        )
    }
}

enum class  Theme(val color : CSSColorValue){
    Bloo(color = rgb(165, 224, 239)),
    Aqua(color = rgb(35, 96, 112))
}