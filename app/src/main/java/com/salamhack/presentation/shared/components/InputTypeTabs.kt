package com.salamhack.presentation.shared.components

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.salamhack.domain.entity.TransactionType
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun InputTypeTabs(
    tabs: List<TransactionType>,
    selected: TransactionType,
    onTabSelected: (TransactionType) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFF3F4F5))
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach { type ->
            TabButton(
                type = type,
                isSelected = selected == type,
                onClick = { onTabSelected(type) },
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Composable
fun TabButton(
    type: TransactionType,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (isSelected) Color.White else Color.Transparent,
        label = "background"
    )

    val textColor by animateColorAsState(
        targetValue = if (isSelected) {
            when (type) {
                TransactionType.INCOME -> Color(0xFF00A63E)
                TransactionType.EXPENSE -> Color(0xFFE7000B)
            }
        } else {
            Color(0xFF6B7280)
        },
        label = "textColor"
    )

    val elevationModifier = if (isSelected) {
        Modifier.shadow(
            elevation = 4.dp,
            shape = RoundedCornerShape(14.dp),
            clip = false
        )
    } else Modifier

    Box(
        modifier = modifier
            .then(elevationModifier)
            .fillMaxHeight()
            .clip(RoundedCornerShape(14.dp))
            .background(backgroundColor)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = when (type) {
                TransactionType.INCOME -> "دخل"
                TransactionType.EXPENSE -> "مصروف"
            },
            style = Theme.textStyle.title.sub.copy(
                color = textColor
            )
        )
    }
}

@Preview
@Composable
private fun Preview() {
    var selected by remember { mutableStateOf(TransactionType.EXPENSE) }

    InputTypeTabs(
        tabs = listOf(TransactionType.INCOME, TransactionType.EXPENSE),
        selected = selected,
        onTabSelected = { selected = it }
    )
}