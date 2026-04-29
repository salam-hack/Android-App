package com.salamhack.presentation.shared.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun MoneyTextField(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {},
    placeholder: String = "200.00",
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "ج.م",
                    style = Theme.textStyle.title.regular.copy(
                        fontSize = 24.sp,
                        color = Color(0xFF90A1B9)
                    ),
                    modifier = Modifier
                )
                BasicTextField(
                    value = textFieldValue,
                    onValueChange = { newValue ->
                        textFieldValue = newValue
                        onTextChange(newValue.text)
                    },
                    singleLine = true,
                    maxLines = 1,
                    modifier = Modifier,
                    textStyle = Theme.textStyle.header.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 48.sp,
                        color = Theme.colors.bluePrimary,
                        textDirection = TextDirection.Rtl,
                        textAlign = TextAlign.Center
                    ),
                    cursorBrush = SolidColor(Color(0xFF1976D2)),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                        ) {
                            if (textFieldValue.text.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    style = Theme.textStyle.header.copy(
                                        fontWeight = FontWeight.SemiBold,
                                        fontSize = 48.sp,
                                        color = Theme.colors.grayNonActive
                                    ),
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .width(212.dp),
                            ) {
                                innerTextField()
                            }
                        }
                    }
                )

            }

            HorizontalDivider(
                modifier = Modifier
                    .width(254.dp),
                thickness = 2.dp,
                color = if (isFocused) Theme.colors.bluePrimary else Color(0xFFE2E8F0)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    MoneyTextField(
        placeholder = "200.00",
    )
}