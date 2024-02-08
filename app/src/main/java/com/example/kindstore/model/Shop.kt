package com.example.kindstore.model

data class Shop(
    val id: Int,
    val imageUri : String,
    val name: String,
    val address: String,
    val phone: String,
    val boastDescription: String,
    val information: String
)

// A fake repo
object ShopRepo{
    fun getShop(shopId : Int) : Shop = shops.find { it.id == shopId }!!
    fun getShops() : List<Shop> = shops
}


val shops = listOf<Shop>(
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
    Shop(
        id = 1,
        imageUri = "https://cdn.pixabay.com/photo/2017/08/30/01/05/milky-way-2695569_960_720.jpg",
        name = "커피나무",
        address = "서울시 강남구 역삼동 123-45",
        phone = "02-123-4567",
        boastDescription = "커피나무는 1990년에 설립된 커피 전문점입니다. 매일 아침 신선한 원두를 사용하여 고객님께 최상의 커피를 제공합니다.",
        information = "영업시간 : 09:00 ~ 22:00\n휴무일 : 매주 일요일"
    ),
)
