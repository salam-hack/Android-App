package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.salamhack.R
import com.salamhack.domain.entity.InputType
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun AddTransactionTypes(
    modifier: Modifier = Modifier,
    selected: InputType,
    onSelectedChange: (InputType) -> Unit
) {
    val items = listOf(
        InputType.CameraInput,
        InputType.ManualInput,
        InputType.VoiceInput,
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items.forEach { type ->
            AddTransactionCard(
                modifier = Modifier.weight(1f),
                type = type,
                isSelected = selected == type,
                onClick = { onSelectedChange(type) }
            )
        }
    }
}

@Composable
fun AddTransactionCard(
    modifier: Modifier = Modifier,
    type: InputType,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val (icon, text) = when (type) {
        InputType.CameraInput -> R.drawable.ic_camera to "تصوير إيصال"
        InputType.ManualInput -> R.drawable.ic_typing to "ادخال يدوي"
        InputType.VoiceInput -> R.drawable.ic_mic to "تسجيل صوتي"
        InputType.SmartInput -> R.drawable.ic_typing to "ذكي" // عدّل الأيقونة لو عندك واحدة
    }

    val elevationModifier = if (isSelected) {
        Modifier.shadow(
            elevation = 6.dp,
            shape = CircleShape
        )
    } else Modifier

    val backgroundColor = if (isSelected) Theme.colors.bluePrimary else Theme.colors.white
    val borderColor = if (isSelected) Theme.colors.bluePrimary else Color(0xFFE2E8F0)
    val borderWidth = if (isSelected) 2.dp else 1.dp
    val containerBackground = if (isSelected) Theme.colors.white else Color(0xFFF8FAFC)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(108.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(containerBackground)
            .border(borderWidth, borderColor, RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .then(elevationModifier)
                    .background(backgroundColor, CircleShape)
                    .size(48.dp)
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = null,
                    tint = if (isSelected) Theme.colors.white else Theme.colors.grayNonActive,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }

            Text(
                text = text,
                style = Theme.textStyle.title.regular.copy(
                    fontSize = 12.sp,
                    color = if (isSelected) Theme.colors.bluePrimary else Color(0xFF62748E)
                )
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    var selected by remember { mutableStateOf(InputType.ManualInput) }

    AddTransactionTypes(
        selected = selected,
        onSelectedChange = { selected = it }
    )
}