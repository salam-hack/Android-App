package com.salamhack.presentation.shared.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salamhack.presentation.shared.designSystem.theme.Theme

enum class GoalStatus(val title: String, val selectedTextColor: Color) {
    CANCELLED("ملغي", Color(0xFFDC2626)),
    COMPLETED("مكتمل", Color(0xFF2563EB)),
    ACTIVE("نشط", Color(0xFF15803D)),
}

@Composable
fun GoalStatusSelector(
    selectedStatus: GoalStatus,
    onStatusSelected: (GoalStatus) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                color = Color(0xFFF1F5F9),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val statuses = GoalStatus.values().toList()

        statuses.forEach { status ->
            StatusTabItem(
                modifier = Modifier.weight(1f),
                status = status,
                isSelected = status == selectedStatus,
                onClick = { onStatusSelected(status) }
            )
        }
    }
}

@Composable
fun StatusTabItem(
    status: GoalStatus,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val textColor by animateColorAsState(
        targetValue = if (isSelected) status.selectedTextColor else Color(0xFF64748B),
        label = "textColorAnimation"
    )

    val itemModifier = if (isSelected) {
        modifier
            .fillMaxHeight()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(12.dp)
            )
    } else {
        modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.Transparent)
            .clickable { onClick() }
    }

    Box(
        modifier = itemModifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = status.title,
            style = Theme.textStyle.title.sub.copy(
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                color = textColor
            ),
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
    name = "Goal Status Selector"
)
@Composable
fun GoalStatusSelectorPreview() {
    Surface(
        modifier = Modifier.padding(16.dp),
        color = Color.White
    ) {
        GoalStatusSelector(
            selectedStatus = GoalStatus.ACTIVE,
            onStatusSelected = {}
        )
    }
}