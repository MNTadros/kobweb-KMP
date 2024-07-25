package com.mnt.web.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.FaFaceSmile
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.px
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
        attrs = Modifier
            .padding ( topBottom =10.px, leftRight = 20.px )
            .fontSize(20.px)
            .toAttrs {
                placeholder(value = "Enter your name")
                onInput { name = it.value }
            }
    )
}
}
