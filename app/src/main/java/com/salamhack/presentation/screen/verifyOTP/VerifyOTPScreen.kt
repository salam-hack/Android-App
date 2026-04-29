package com.salamhack.presentation.screen.verifyOTP

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
import com.salamhack.presentation.shared.components.IconHolder
import com.salamhack.presentation.shared.components.OTPInputTextField
import com.salamhack.presentation.shared.designSystem.textStyle.ibm
import com.salamhack.presentation.shared.designSystem.theme.Theme
import org.koin.androidx.compose.koinViewModel

@Composable
fun VerifyOTPScreen(
    viewModel: VerifyOTPViewModel = koinViewModel()
){
    val state by viewModel.screenState.collectAsStateWithLifecycle()
    VerifyOTPScreenContent(
        action = viewModel,
        state = state
    )
}

@Composable
fun VerifyOTPScreenContent(
    action: VerifyOTPInteractionListener,
    state: VerifyOTPUiState,
    modifier: Modifier = Modifier
){

    var verifyOTPText by remember { mutableStateOf("") }

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
                text = "أدخل رمز التحقق",
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
                text = "لقد أرسلنا رمزاً مكوناً من 6 أرقام إلى رقم هاتفك المسجل.",
                style = Theme.textStyle.title.sub.copy(
                    color = Color(0xFF44474E),
                    textDirection = TextDirection.Rtl
                ),
                modifier = Modifier
                    .align(Alignment.End)
            )

            OTPInputTextField(
                otpText = verifyOTPText,
                onOtpTextChange = {
                    if (it.length <= 6) {
                        verifyOTPText = it
                    }
                },
                modifier = Modifier
                    .padding(top = 48.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                otpCount = 5
            )

            // Timer
            Row(
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "إعادة إرسال 00:59",
                    style = Theme.textStyle.title.sub.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = Theme.colors.bluePrimary
                    ),
                    modifier = Modifier
                        .padding(end = 4.dp)
                        .clickable{
                            //action.onClickResendCode()
                        }
                )
                Text(
                    text = "لم تستلم الرمز؟",
                    style = Theme.textStyle.title.sub.copy(
                        color = Theme.colors.graySubTitles
                    ),
                    modifier = Modifier
                        .padding(bottom = 56.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
        ) {
            // Save Button
            AppButton(
                text = "تحقق",
                type = AppButtonType.Primary,
                modifier = Modifier
                    .padding(top = 24.dp)
                    .clickable{
                        action.onClickVerify()
                    }
            )

            // Login
            Row(
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 56.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "اتصال مشفر ومحمي 256-bit",
                    style = Theme.textStyle.title.sub.copy(
                        color = Theme.colors.graySubTitles,
                        textDirection = TextDirection.Rtl
                    ),
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_secure_true),
                    contentDescription = null,
                    tint = Theme.colors.graySubTitles,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview(){
    VerifyOTPScreen()
}