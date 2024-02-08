package com.example.kindstore.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kindstore.R

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        ExplainText(
            R.string.what_is_good_shop_title,
            R.string.what_is_good_shop_content,
            R.drawable.goodshop_image,
            "가게를 배경으로 여러 사람들이 서있는 이미지"
        )
        Spacer(modifier = Modifier.height(24.dp))
        ExplainText(
            R.string.goodshop_sticker_title,
            R.string.goodshop_sticker_content,
            R.drawable.sticker_image,
            "스티커 이미지"
        )
    }
}

@Composable
private fun ExplainText(
    @StringRes title: Int,
    @StringRes content: Int,
    image: Int,
    imageDescription: String
) {
    Column {
        Text(text = stringResource(id = title), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = content),
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 28.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = image), contentDescription = imageDescription)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}