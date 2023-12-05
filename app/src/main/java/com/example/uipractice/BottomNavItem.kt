package com.example.uipractice

sealed class BottomNavItem( val icon:Int, val title:String?){

    object Home: BottomNavItem(R.drawable.home_icon, "")
    object Search: BottomNavItem(R.drawable.search_icon, "")
    object Add: BottomNavItem(R.drawable.add_post_icon, "")
    object Reels: BottomNavItem(R.drawable.reels_icon, "")
    object Profile: BottomNavItem(R.drawable.dog_image, "")

}
