package com.example.kindstore.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class SearchUiState(
    val location : String = "현재 위치",
    val category : String = "",
)

class SearchViewModel : ViewModel() {
    // UI 상태 업데이트를 listen하고, 화면 전환에도 데이터 유지하기 위함
    private val _uiState = MutableStateFlow(SearchUiState())
    // 그냥 StateFlow는  현재 상태를 관찰하기 위함(읽기 전용 흐름)
    val uiState : StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun updateLocation(location : String) {
        _uiState.value = _uiState.value
    }

    fun updateCategory(category : String) {
        _uiState.value = _uiState.value
    }

    fun getCurrentLocation(){
        // 사용자의 현재 x좌표와 y좌표를 이용해서 현재 위치의 "시"를 가져온다.
        // 가져온 "시"를 uiState에 업데이트한다.
    }

    fun getShopList(){
        // 검색 버튼을 클릭했을 때, 실행된다.
        // 현재 위치와 카테고리를 이용해서 가게 리스트를 가져온다.
        // 가져온 가게 리스트를 ShopListFragment로 보낸다.
    }

}