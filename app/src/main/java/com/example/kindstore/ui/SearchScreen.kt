package com.example.kindstore.ui

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.kindstore.R

@Composable
fun SearchScreen() {
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

        // 검색 결과를 보여주는 RecyclerView
        // SearchResultsRecyclerView()
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

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun SearchResultsRecyclerView(modifier: Modifier = Modifier) {
//    Column {
//        Text(text = "검색 결과")
//        LazyColumn(content = ){
//
//        }
//
//    }
//
//}

@Composable
private fun ListItem(imageUri: Uri, name: String, address: String) {
    Surface(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row {
            // TODO : Coil 등 라이브러리로 Uri를 이미지로 변환
            // Image(painter =, contentDescription = "${name} 이미지")
            Column {
                Text(text = name)
                Text(text = address)
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
                        Row(verticalAlignment = Alignment.CenterVertically){
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
private fun LocationDropdownMenu(locations : Array<String>, modifier: Modifier = Modifier) {
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
//@Preview(showBackground = true, showSystemUi = true)
fun PreviewSearchScreen() {
    SearchScreen()
}