package com.finale.neulhaerang.ui.app.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.finale.neulhaerang.domain.KakaoAuthViewModel
import com.finale.neulhaerang.ui.R
import com.finale.neulhaerang.ui.theme.Typography

@Composable
fun LoginScreen() {
    val viewModel = viewModel<KakaoAuthViewModel>()

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier.fillMaxHeight(0.5f),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = "늘해랑", style = Typography.displayLarge
            )
        }
        Image(painter = painterResource(id = R.drawable.kakao_login_large_wide),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(48.dp)
                .clickable {
                    viewModel.kakaoLogin()
                })
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview(navController: NavHostController = rememberNavController()) {
    LoginScreen()
}
