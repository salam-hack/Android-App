package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun TransactionNoteTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "ملاحظات (اختياري)..."
) {
    // State to hold the text field value
    var textValue by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }


    // Colors sampled from the image
    val textColor = Color(0xFF314158)
    val inputTextColor = Theme.colors.bluePrimary
    val borderColor = Color(0xFFF1F5F9)
    val backgroundColor = if (isFocused) Color(0xFFF8FAFC) else Theme.colors.white
    val iconColor = Color(0xFF90A1B9)

    // Enforce RTL layout direction for Arabic
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            // Label
            Text(
                text = "ملاحظات (اختياري)",
                style = Theme.textStyle.title.sub.copy(
                    color = textColor,
                ),
                modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
            )

            // Input Field Container
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = backgroundColor,
                        shape = RoundedCornerShape(12.dp) // Rounded corners
                    )
                    .border(
                        width = 1.dp,
                        color = borderColor,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 16.dp)
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Leading Icon (on the right side in RTL)
                Icon(
                    painter = painterResource(id = R.drawable.ic_notes), // You can replace this with your exact icon drawable
                    contentDescription = "Menu Icon",
                    tint = iconColor,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Text Input
                BasicTextField(
                    value = textValue,
                    onValueChange = { textValue = it },
                    textStyle = TextStyle(
                        color = inputTextColor,
                        fontSize = 16.sp,
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    decorationBox = { innerTextField ->

                        if (textValue.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = TextStyle(
                                    fontFamily = ibm,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    color = Color(0xFF90A1B9),
                                    lineHeight = 20.sp,
                                    textDirection = TextDirection.Rtl
                                ),
                                modifier = Modifier
                            )
                        }
                        Box(
                            contentAlignment = Alignment.CenterStart
                        ) {
                            innerTextField()
                        }
                    }
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun Preview() {
    TransactionNoteTextField()
}