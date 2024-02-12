package com.example.kindstore.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kindstore.model.Shop
import com.example.kindstore.model.ShopRepo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopDetail(
    shopId: Int,
    navController: NavController
) {
    // TODO : 샘플용으로 넣은 것 (원래는 아마 VM을 이용해야함)
    val shop = remember(shopId) { ShopRepo.getShop(shopId) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
    ) {
        TopAppBar(
            title = { Text(text = "") },
            navigationIcon = {
                androidx.compose.material.Icon(
                    imageVector = Icons.Default.ArrowBack, contentDescription = "Back",
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            top = 16.dp,
                            bottom = 16.dp,
                            end = 16.dp
                        )
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }
        )

        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            ShopDetailContent(shop)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Google Map으로 가기")
                }
            }
        }
    }
}

@Composable
private fun ShopDetailContent(shop: Shop) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        // TODO : coil로 이미지 넣기
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(text = shop.name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(12.dp))

        ContentTitleText(icon = Icons.Outlined.LocationOn, title = "주소")
        Text(text = shop.address, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(10.dp))

        ContentTitleText(icon = Icons.Outlined.Phone, title = "전화 번호")
        Text(text = shop.phone, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(10.dp))

        ContentTitleText(icon = Icons.Outlined.Star, title = "자랑 거리")
        Text(text = shop.boastDescription, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(10.dp))

        ContentTitleText(icon = Icons.Outlined.Info, title = "정보")
        Text(text = shop.information, fontSize = 16.sp, fontWeight = FontWeight.Normal)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
private fun ContentTitleText(icon: ImageVector, title: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        androidx.compose.material.Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
@Preview(showBackground = true)
fun ShopDetailPreview() {
    ShopDetail(shopId = 1, navController = rememberNavController())
    // ShopDetailContent(ShopRepo.getShop(1))
}

