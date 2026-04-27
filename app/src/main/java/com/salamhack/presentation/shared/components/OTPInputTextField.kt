package com.salamhack.presentation.shared.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.salamhack.presentation.shared.designSystem.theme.AppTheme
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun OTPInputTextField(
    otpText: String,
    onOtpTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    otpCount: Int = 5
) {
    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= otpCount) {
                onOtpTextChange(it)
            }
        },
        modifier = modifier,
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(otpCount) { index ->
                    val char = otpText.getOrNull(index)?.toString() ?: ""
                    val isCurrentPosition = index  == otpText.length
                    val isFilled = char.isNotEmpty()

                    val borderColor = when {
                        isCurrentPosition -> Color(0xFF2563EB)
                        isFilled -> Theme.colors.blueBackground
                        else -> Theme.colors.blueBackground
                    }

                    val textColor = when {
                        isCurrentPosition && char.isEmpty() -> Theme.colors.bluePrimary
                        isFilled -> Theme.colors.bluePrimary
                        else -> Theme.colors.graySubTitles
                    }

                    val animatedBorderColor = animateColorAsState(borderColor).value
                    val animatedTextColor = animateColorAsState(textColor).value

                    OtpItem(char, animatedBorderColor, animatedTextColor)
                    Spacer(modifier = Modifier.width(12.dp))

                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next
        )
    )
}

@Composable
private fun OtpItem(
    text: String,
    borderColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(64.dp)
            .width(53.dp)
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .background(Theme.colors.background)
            .padding(horizontal = 19.dp),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(text.isEmpty()) {
            if (it) {
                Text(
                    text = "",
                    style = Theme.textStyle.header.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = textColor
                )
            } else {
                Text(
                    text = text,
                    style = Theme.textStyle.header.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = textColor
                )
            }
        }

    }
}

@Preview(showSystemUi = false, showBackground = true)
@PreviewLightDark
@Composable
private fun OTPInputTextFieldPreview() {
    AppTheme {
        OTPInputTextField(
            otpText = "1234",
            onOtpTextChange = {},
            modifier = Modifier.padding(16.dp),
            otpCount = 5
        )
    }

}