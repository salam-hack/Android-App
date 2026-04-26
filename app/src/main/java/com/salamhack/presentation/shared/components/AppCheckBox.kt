package com.salamhack.presentation.shared.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salamhack.R
import com.salamhack.presentation.shared.designSystem.theme.Theme

@Composable
fun AppCheckBox(
    modifier: Modifier = Modifier,
    isChecked: Boolean = false,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    val shape = RoundedCornerShape(4.dp)

    Box(
        modifier = modifier
            .size(20.dp)
            .clip(shape)
            .then(
                if (isChecked) {
                    modifier.background(Theme.colors.bluePrimary)
                } else {
                    modifier
                }
            )
            .border(
                width = 1.dp,
                color = if (isChecked) Theme.colors.bluePrimary else Theme.colors.blueBackground,
                shape = shape
            )
            .semantics(mergeDescendants = true) {
                stateDescription = if (isChecked) "Checked" else "Unchecked"
            }
            .clickable(
                enabled = enabled,
                role = Role.Checkbox,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                onCheckedChange(!isChecked)
            }
    ) {
        if (isChecked) {
            Icon(
                painter = painterResource(id = R.drawable.ic_checked),
                contentDescription = null,
                tint = Theme.colors.white,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(16.dp)
            )
        }
    }
}

@Composable
@Preview
private fun Preview(){
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        AppCheckBox(
            isChecked = true
        )
        AppCheckBox(
            isChecked = false
        )
    }
}