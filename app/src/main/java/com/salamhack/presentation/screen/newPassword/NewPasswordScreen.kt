package com.salamhack.presentation.screen.newPassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.salamhack.R
import com.salamhack.presentation.shared.components.AppButton
import com.salamhack.presentation.shared.components.AppButtonType
import com.salamhack.presentation.shared.components.AppPasswordTextField
import com.salamhack.presentation.shared.components.IconHolder
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewPasswordScreen(
    viewModel: NewPasswordViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    NewPasswordScreenContent(
        action = viewModel,
        state = state
    )
}


@Composable
fun NewPasswordScreenContent(
    action: NewPasswordInteractionListener,
    state: NewPasswordUiState,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(253.dp)
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(253.dp)
                .background(Theme.colors.bluePrimary.copy(alpha = 0.7f))
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 55.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ){
                Column {
                    Text(
                        text = "بوابــــــــــة الأمــــــــــــان",
                        style = TextStyle(
                            fontFamily = ibm,
                            fontSize = 16.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textDirection = TextDirection.Rtl
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = "وصول موثوق وآمن لحساباتك المصرفية.",
                        style = TextStyle(
                            fontFamily = ibm,
                            fontSize = 12.sp,
                            color = Color(0xE6B1C7F3),
                            fontWeight = FontWeight.Bold,
                            textDirection = TextDirection.Rtl
                        ),
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                IconHolder(
                    icon = R.drawable.ic_security,
                    color = Color(0xFFFED65B)
                )
            }
        }

        // body
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topEnd = 32.dp, topStart = 32.dp))
                .background(Color.White)
                .align(Alignment.BottomCenter)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(0.8f)
        ) {
            Text(
                text = "تعيين كلمة مرور جديدة",
                style = Theme.textStyle.header.copy(
                    color = Theme.colors.bluePrimary,
                    fontWeight = FontWeight.SemiBold,
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .padding(top = 32.dp)
                    .align(Alignment.End)
            )
            Text(
                text = "يرجي ادخال كلمة مرور جديدة وتأكيدها للدخول الي حسابك.",
                style = Theme.textStyle.title.sub.copy(
                    color = Color(0xFF44474E),
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .align(Alignment.End)
            )

            AppPasswordTextField(
                title = "كلمة المرور الجديدة",
                placeholder = "A123456a",
                modifier = Modifier.padding(top = 24.dp)
            )
            AppPasswordTextField(
                title = "تأكيد كلمة المرور الجديدة",
                placeholder = "A123456a",
                modifier = Modifier.padding(top = 24.dp)
            )


            // Save Button
            AppButton(
                text = "حفظ كلمة المرور",
                type = AppButtonType.Primary,
                modifier = Modifier.padding(top = 24.dp),
                onClick = {
                    action.onClickSavePassword()
                }
            )


            // Create Account
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "تسجيل الدخول",
                    style = Theme.textStyle.title.sub.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Theme.colors.bluePrimary
                    ),
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable{
                            action.onClickLogin()
                        }
                )
                Text(
                    text = "تذكرت كلمة المرور؟",
                    style = Theme.textStyle.title.sub.copy(
                        color = Theme.colors.graySubTitles
                    ),
                    modifier = Modifier
                        .padding(bottom = 56.dp)
                )
            }

        }
    }
}

@Preview
@Composable
private fun Preview(){
    NewPasswordScreen()
}