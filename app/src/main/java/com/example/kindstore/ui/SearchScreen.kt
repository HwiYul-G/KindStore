package com.example.kindstore.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kindstore.NavigationItem
import com.example.kindstore.R
import com.example.kindstore.model.Shop
import com.example.kindstore.model.ShopRepo
import com.example.kindstore.model.shops

@Composable
fun SearchScreen(navController : NavHostController) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
    ) {
        // 검색창 관련
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painterResource(id = R.drawable.my_location),
                    contentDescription = "현재 위치 검색 버튼"
                )
            }
            Text(text = "현재 위치")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            CategoryDropdownMenu(modifier = Modifier.weight(8.5f))
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1.5f)
                    .padding(horizontal = 4.dp),
            ) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "검색 버튼",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "검색 결과",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )

        SearchResults(ShopRepo.getShops(), navController, modifier = Modifier.weight(1f))
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryDropdownMenu(modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = modifier
    ) {
        TextField(
            value = category,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "카테고리를 선택해주세요")
            },
            modifier = Modifier.fillMaxWidth()
        )

        // TODO : Item 추가
//        DropdownMenuItem(
//            text = { Text("") },
//            onClick = {
//                category = ""
//                isExpanded = false
//            }
//        )
    }
}

@Composable
private fun SearchResults(searchedShopList: List<Shop>, navController : NavHostController, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(searchedShopList.size) { index ->
            ShopCard(shopInfo = searchedShopList[index],
                onItemClick = {
                    navController.navigate("${NavigationItem.Search.route}/${shops[index].id}")
                })
        }
    }
}


@Composable
private fun ShopCard(
    shopInfo: Shop,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onItemClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            // TODO : 이미지 관련 처리 필요
            Image(
                painter = painterResource(id = R.drawable.my_location),
                contentDescription = "${shopInfo.name} 가게 이미지",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = shopInfo.name, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = shopInfo.address, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun LocationSearchDialog(

) {
    Dialog(onDismissRequest = { }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
        ) {
            Column(
                modifier = Modifier.padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "위치 설정",
                        fontSize = 18.sp, fontWeight = FontWeight.Bold
                    )
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = "위치 설정 닫기 버튼")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))

                LocationDropdownMenu(locations = stringArrayResource(id = R.array.address_array))
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Button(onClick = { /*TODO*/ }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.my_location),
                                contentDescription = "현재 위치로 설정"
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(text = "현재 위치")
                        }
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "확인")
                    }
                }


            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LocationDropdownMenu(locations: Array<String>, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    var category by remember { mutableStateOf("") }
    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = modifier
    ) {
        TextField(
            value = category,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
            },
            placeholder = {
                Text(text = "지역을 선택해주세요")
            },
            modifier = Modifier.fillMaxWidth()
        )

        locations.forEachIndexed { index, s ->
            DropdownMenuItem(
                text = { Text(s) },
                onClick = {
                    category = s
                    isExpanded = false
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewSearchScreen() {
    SearchScreen(navController = rememberNavController())
}